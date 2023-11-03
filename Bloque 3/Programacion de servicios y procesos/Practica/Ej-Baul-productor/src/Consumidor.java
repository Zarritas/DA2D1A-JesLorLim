public class Consumidor implements Runnable{

    private char letra;
    private final Baul baul;

    public Consumidor(char letra, Baul baul) {
        this.letra = letra;
        this.baul = baul;
    }

    @Override
    public void run() {
        synchronized (baul){
            for (int i = 0; i < 3; i++) {
                while (baul.getContenido()!=letra) {
                    try {
                        System.out.println("soy el consumidor del carter "+letra+"y estoy esperando.");
                        baul.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("soy el consumidor del caracter "+letra+"y mo lo llevo.");
                baul.vaciarBaul();
                baul.notifyAll();
            }
        }
    }

}

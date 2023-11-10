public class Consumidor implements Runnable{

    private final char letra;
    private final Baul baul;

    public Consumidor(char letra, Baul baul) {
        this.letra = letra;
        this.baul = baul;
    }

    @Override
    public void run() {
        synchronized (baul){
            for (int i = 0; i < 3; i++) {
                while (baul.estaVacio() || baul.getContenido()!=letra) {
                    try {
                        baul.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("soy el consumidor y saco la letra "+baul.vaciar()+" y ya me he llevado "+(i+1)+" caracteres.");
                baul.notifyAll();
            }
        }
    }

}

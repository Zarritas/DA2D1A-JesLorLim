public class Productor implements Runnable {

    private final Baul baul;
    int contadorA = 0;
    int contadorB = 0;
    int contadorC = 0;

    public Productor(Baul baul) {
        this.baul = baul;
    }


    @Override
    public void run() {
        synchronized (baul) {
            while (contadorA + contadorB + contadorC == 9) {
                while (!baul.baulVacio()) {
                    try {
                        baul.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                char letra = '\0';
                int numAleatorio = (int) (Math.random() * 3 + 1);
                switch (numAleatorio) {
                    case 1:
                        if (contadorA == 3) {
                            break;
                        } else {
                            letra = 'A';
                            contadorA++;
                        }
                        break;
                    case 2:
                        if (contadorB == 3) {
                            break;
                        } else {
                            letra = 'B';
                            contadorB++;
                        }
                        break;
                    case 3:
                        if (contadorC == 3) {
                            break;
                        } else {
                            letra = 'C';
                            contadorC++;
                        }
                        break;
                    default:
                        letra = '\0';
                        break;
                }
                ;
                if (baul.getContenido() == '\0') {
                    System.out.println("Soy el productor y añado al baul el caracter" + letra);
                    baul.llenarBaul(letra);
                    baul.notifyAll();
                }
            }

        }
    }
}

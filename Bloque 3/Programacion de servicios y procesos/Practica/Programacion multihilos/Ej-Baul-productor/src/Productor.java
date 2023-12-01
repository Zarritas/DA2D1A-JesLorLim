import java.security.SecureRandom;

public class Productor implements Runnable {

    private final Baul baul;
    int contadorA = 0;
    int contadorB = 0;
    int contadorC = 0;
    SecureRandom random = new SecureRandom();
    public Productor(Baul baul) {
        this.baul = baul;
    }


    @Override
    public void run() {
        synchronized (baul) {
            while (contadorA + contadorB + contadorC != 9) {
                while (!baul.estaVacio()) {
                    try {
                        baul.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                int numAleatorio;
                char letra = '\0';
                numAleatorio = random.nextInt(4);
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
                }
                if (letra != '\0') {
                    System.out.println("Soy el productor y añado al baul el caracter " + letra);
                    System.out.println(numAleatorio);
                    baul.setContenido(letra);
                    baul.notifyAll();
                }
            }

        }
    }
}

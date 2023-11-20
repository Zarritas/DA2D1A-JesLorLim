import java.security.SecureRandom;

public class Infante implements Runnable{
    private final String apodo;
    private final int TIEMPO1=3000;
    private final SecureRandom random;
    private Bola bolsillo;
    private Bombo bombo;
    private Combinacion numPremiado;

    public Infante(String apodo,Bombo bombo, Combinacion numPremiado) {
        this.apodo = apodo;
        this.bombo = bombo;
        this.numPremiado = numPremiado;
        random = new SecureRandom();
    }

    @Override
    public void run() {
        while (!numPremiado.estaLleno());{
            try {
                Thread.sleep(random.nextInt(TIEMPO1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (bombo){

            }

            synchronized (numPremiado){

            }
        }
    }
}

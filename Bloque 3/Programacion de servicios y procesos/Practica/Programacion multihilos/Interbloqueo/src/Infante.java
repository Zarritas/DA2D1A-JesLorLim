import org.jetbrains.annotations.NotNull;

public class Infante implements Runnable {
    private static final int TIEMPO1=3000;      // Tiempo de juego con el primer juguete
    private String apodo;       // NO NULO
    private Juguete juguete1;
    private Juguete juguete2;

    public Infante(String apodo, Juguete juguete1, Juguete juguete2) {
        setApodo(apodo);
        this.juguete1=juguete1;
        this.juguete2=juguete2;
    }

    public String getApodo() {
        return apodo;
    }

    private void setApodo(@NotNull String apodo) {
        this.apodo=apodo;
    }

    @Override
    public void run() {
        synchronized (juguete1) {
            System.out.printf("[%s] Tengo %s\n", apodo, juguete1);
            try {
                System.out.printf("[%s] Voy a jugar %d segundos con %s\n", apodo, TIEMPO1, juguete1);
                Thread.sleep(TIEMPO1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("[%s] Tengo %s y voy a intentar coger %s\n", apodo, juguete1, juguete2);
            synchronized (juguete2) {
                System.out.printf("[%s] He conseguido coger %s y %s\n", apodo, juguete1, juguete2);
            }
        }
    }

    @Override
    public String toString() {
        return apodo;
    }
}

import org.jetbrains.annotations.NotNull;

public class Invitado
        extends Persona
        implements Runnable{
    private Caja caja;              // NO NULO
    private Regalo regalo;
    private boolean salir;

    public Invitado(String apodo, Caja caja) {
        super(apodo);
        setCaja(caja);
        salir = false;
    }

    private void setCaja(@NotNull Caja caja) {
        this.caja = caja;
    }

    @Override
    public void run() {
        synchronized (caja) {
            while (caja.estaVacia() && !salir) {
                try {
                    wait(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            regalo = caja.sacarRegalo();
            caja.notifyAll();
        }

        // Pienso durante 3 segundos
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("[%s] ¡Qué fiesta más aburrida", getApodo());
        System.out.printf("[%s] Me voy", getApodo());
    }
}

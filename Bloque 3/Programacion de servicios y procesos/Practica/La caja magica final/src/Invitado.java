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

    //Con este metodo hacemos que los Hilos terminen
    public void acabarFiesta(){
        salir = true;
    };

    public Regalo getRegalo() {
        return regalo;
    }

    @Override
    public void run() {
        System.out.printf("BIENVENIDO %s\n",getApodo());

        synchronized (caja) {
            while (caja.estaVacia() && !salir) {
                try {
                    caja.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.printf("[%s] Me llevo el regalo %s\n\n",getApodo(),caja.toString());
            regalo = caja.sacarRegalo();
            caja.notifyAll();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (!salir) {
            // Pienso durante 3 segundos
            System.out.printf("[%s] ¡Qué fiesta más aburrida\n\n", getApodo());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("[%s] Me voy\n\n", getApodo());

    }
}

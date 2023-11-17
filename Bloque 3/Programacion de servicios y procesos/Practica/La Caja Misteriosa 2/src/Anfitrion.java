import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Anfitrion
        extends Persona
        implements Runnable {
    private List<Regalo> regalos;   // NO NULO
    private Caja caja;              // NO NULO

    public Anfitrion(String apodo, List<Regalo> regalos, Caja caja) {
        super(apodo);
        setRegalos(regalos);
        setCaja(caja);
    }

    private void setCaja(@NotNull Caja caja) {
        this.caja = caja;
    }

    private void setRegalos(@NotNull List<Regalo> regalos) {
        this.regalos = regalos;
    }


    @Override
    public void run() {
        System.out.println("Soy el anfitrión");

        // Meto un regalo en la caja mientras queden regalos
        while (!regalos.isEmpty())
            synchronized (caja) {
                // ¿Hay regalo en la caja? --> Me espero
                if (!caja.estaVacia()) {
                    try {
                        caja.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Meto regalo en la caja
                caja.meterRegalo(regalos.remove(0));

                // Aviso a los invitados de que he metido el regalo en la caja
                // ("toco la campana")
                caja.notifyAll();
            }
    }
}

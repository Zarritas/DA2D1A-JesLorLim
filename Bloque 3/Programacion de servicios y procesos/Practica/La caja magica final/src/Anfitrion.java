import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Anfitrion
        extends Persona
        implements Runnable {
    private List<Regalo> regalos;   // NO NULO
    private Caja caja;              // NO NULO
    private boolean salir;          //Interruptor de salida de la fiesta

    public Anfitrion(String apodo, Caja caja) {
        super(apodo);
        regalos = new ArrayList<>(Fabrica.generarRegalos());
        setCaja(caja);
        salir=false;
    }

    private void setCaja(@NotNull Caja caja) {
        this.caja = caja;
    }

    public List<Regalo> getRegalos() {
        return regalos;
    }

    //Con este metodo hacemos que los Hilos terminen
    public void acabarFiesta(){
        salir = true;
    };

    @Override
    public void run() {
        System.out.printf("Soy %s ¡¡¡¡¡BIENVENIDOS A MI FIESTA!!!!!\n",getApodo());

        // Meto un regalo en la caja mientras queden regalos
        synchronized (caja) {
            while (!regalos.isEmpty() && !salir) {
                // ¿Hay regalo en la caja? --> Me espero
                while (!caja.estaVacia()) {
                    try {
                        caja.wait(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Meto regalo en la caja
                System.out.printf("Soy %s y meto este regalo : %s en la caja.\n", getApodo(), regalos.get(0));
                try {
                    caja.meterRegalo(regalos.remove(0));
                }catch (Exception e){
                    e.printStackTrace();
                }
                // Aviso a los invitados de que he metido el regalo en la caja
                caja.notifyAll();
            }
        }

        while (!salir){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("[%s]Gracias por venir a mi fiesta.\n",getApodo());
    }
}

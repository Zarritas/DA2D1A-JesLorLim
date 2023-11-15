import java.util.ArrayList;
import java.util.List;

public class Anfitrion implements Runnable{

    private final String nombre;
    private final List<String> regalos;
    private final Caja caja;
    private boolean running = true;

    public Anfitrion(String nombre, Caja caja) {
        this.nombre = nombre;
        regalos = new ArrayList<>() {{add("Anillo");add("Relog");add("Pistola");add("Caramelo");add("Movil");add("Rosa");}};
        this.caja = caja;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getRegalos() {
        return regalos;
    }

    public String guardarRegalo() {
        String regalo = regalos.get(0);
        regalos.remove(0);
        return regalo;
    }

    @Override
    public void run() {
        System.out.println("SOY EL ANFITRION - dijo "+nombre);
        synchronized (caja){
            while (!regalos.isEmpty() && running) {
                System.out.println("Soy "+nombre+" y he añadido el regalo "+regalos.get(0)+" a la caja.");
                caja.setRegalo(guardarRegalo());
                try {
                    System.out.println("Estoy pensando - dijo "+nombre);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    caja.notifyAll();
                    caja.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (regalos.isEmpty()&&running){
                try {
                    caja.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            caja.notifyAll();
        }
        System.out.println("UN PLACER JUGAR CON VOSOTROS - dijo "+nombre);
    }

    public void detener(){
        running = false;
    }
}

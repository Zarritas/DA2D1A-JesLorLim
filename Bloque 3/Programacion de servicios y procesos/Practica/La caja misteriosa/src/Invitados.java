public class Invitados implements Runnable {

    private final String nombre;
    private String regalo;
    private final Caja caja;
    private boolean running = true;

    public Invitados(String nombre, Caja caja) {
        this.nombre = nombre;
        this.caja = caja;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRegalo() {
        return regalo;
    }

    @Override
    public void run() {
        System.out.println("BIENVENIDO "+nombre);
        synchronized (caja){
            while(caja.vacia()&& running){
                try {
                    caja.wait(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (running) {
                this.regalo = caja.getRegalo();
                System.out.println("Soy "+nombre+" y saco de la caja el regalo: "+regalo);
                try {
                    System.out.println(nombre+" dijo - estoy pensando");
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("¡QUÉ FIESTA MÁS ABURRIDA! - dijo "+nombre);
                caja.notifyAll();
            }
            while(running) {
                try {
                    caja.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            caja.notifyAll();
        }
        System.out.println("ADIOS - dijo "+nombre);
    }
    public void detener(){
        running = false;
    }
}

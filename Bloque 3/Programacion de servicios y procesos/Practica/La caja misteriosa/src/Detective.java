import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Detective implements Runnable{
    private final String nombre;
    private final List<Invitados> invitados;
    private boolean pistolaEncontrada=false;
    SecureRandom random = new SecureRandom();
    private final Caja caja;
    private final Anfitrion anfitrion;
    private int preguntas=0;

    public Detective(String nombre, Invitados invi1, Invitados invi2, Invitados invi3, Invitados invi4, Invitados invi5, Invitados invi6,Anfitrion anfi, Caja caja) {
        this.nombre = nombre;
        this.invitados = new ArrayList<>(){{
            add(invi1);
            add(invi2);
            add(invi3);
            add(invi4);
            add(invi5);
            add(invi6);
        }};
        this.anfitrion=anfi;
        this.caja=caja;
    }

    public int getPreguntas() {
        return preguntas;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        System.out.println("BIENVENIDO "+nombre);
        synchronized (caja) {
            while (!pistolaEncontrada) {
                try {
                    caja.wait(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int numaleatorio = random.nextInt(invitados.size());
                System.out.println(nombre+" dijo - ¿Acaso tu " + invitados.get(numaleatorio).getNombre() + " eres el portador de la pistola?");
                preguntas++;
                if (Objects.equals(invitados.get(numaleatorio).getRegalo(), "Pistola")) {
                    System.out.println(invitados.get(numaleatorio).getNombre() + " dijo - SI.");
                    System.out.println(invitados.get(numaleatorio).getNombre() + " HA MATADO AL SR. LEMON CON LA PISTOLA - dijo "+nombre);
//                    Thread.currentThread().interrupt();
                    pistolaEncontrada = true;
                    for (Invitados invitado : invitados) {
                        invitado.detener();
                    }
                    anfitrion.detener();
                    caja.notifyAll();
                }else {
                    System.out.println(invitados.get(numaleatorio).getNombre()+" dijo - NO.");
                    try {
                        System.out.println(nombre+" dijo - Me voy a descansar");
                        Thread.sleep(random.nextInt(500) + 100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("ADIOS - dijo: "+nombre);
    }
}

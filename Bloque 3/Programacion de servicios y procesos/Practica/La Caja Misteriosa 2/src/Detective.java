import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Detective extends Persona implements Runnable{
    private List<Invitado> invitados;
    private Regalo regalo;
    private Anfitrion anfitrion;
    private boolean pistolaEncontrada;
    public Detective(String apodo, List<Invitado> invitados, Anfitrion anfitrion, Regalo regalo) {
        super(apodo);
        this.invitados = invitados;
        this.anfitrion = anfitrion;
        this.regalo = regalo;
    }

    @Override
    public void run() {
        System.out.println("BIENVENIDO "+getApodo());
        while (!pistolaEncontrada) {
            int numaleatorio = random.nextInt(invitados.size());
            System.out.println(nombre+" dijo - ¿Acaso tu " + invitados.get(numaleatorio).getNombre() + " eres el portador de la pistola?");
            preguntas++;
            if (Objects.equals(invitados.get(numaleatorio).getRegalo(), pistola) {
                System.out.println(invitados.get(numaleatorio).getNombre() + " dijo - SI.");
                System.out.println(invitados.get(numaleatorio).getNombre() + " HA MATADO AL SR. LEMON CON LA PISTOLA - dijo "+nombre);
                pistolaEncontrada = true;
                for (Invitados invitado : invitados) {
                    invitado.detener();
                }
                anfitrion.detener();
            }else {
                System.out.println(invitados.get(numaleatorio).getNombre()+" dijo - NO.");
                try {
                    System.out.println(nombre+" dijo - Me voy a descansar");
                    Thread.sleep(random.nextInt(5000) + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("ADIOS - dijo: "+nombre);
    }
}

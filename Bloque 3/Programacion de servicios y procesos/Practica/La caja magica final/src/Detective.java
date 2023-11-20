import java.security.SecureRandom;
import java.util.List;
import java.util.Objects;

public class Detective extends Persona implements Runnable{
    private final List<Invitado> invitados;       //Invitados a los que pregunta por la pistola
    SecureRandom random =new SecureRandom();                    //Para generar los numeros aleatorios Thread Safe
    private final Regalo regalo;                  //Regalo que busca el detective para acabar la fiesta
    private final Anfitrion anfitrion;            //El anfitrion para aviarle de que la fiesta se acabó
    private boolean salir;
    private int preguntas;                  //Contador de preguntas realizadas por el detective

    //Constructor
    public Detective(String apodo, List<Invitado> invitados, Anfitrion anfitrion, Regalo regalo) {
        super(apodo);
        this.invitados = invitados;
        this.anfitrion = anfitrion;
        this.regalo = regalo;
        salir = false;
        preguntas=0;
    }

    //Getter
    public int getPreguntas() {
        return preguntas;
    }

    @Override
    public void run() {
        System.out.printf("BIENVENIDO %s\n",getApodo());
        while (!salir) {
            int numaleatorio = random.nextInt(invitados.size());
            System.out.printf("[%s]  ¿Acaso tu %s eres el portador de la pistola?\n",getApodo(),invitados.get(numaleatorio).getApodo());
            preguntas++;
            if (Objects.equals(invitados.get(numaleatorio).getRegalo(), regalo)) {

                System.out.printf("[%s] SI.\n",invitados.get(numaleatorio).getApodo());
                System.out.printf("[%s] %s HA MATADO AL SR. LEMON CON LA PISTOLA\n\n",getApodo(),invitados.get(numaleatorio).getApodo());
                salir= true;

                for (Invitado invitado : invitados) {
                    invitado.acabarFiesta();
                }
                anfitrion.acabarFiesta();

            }else {
                System.out.printf("[%s] NO.\n",invitados.get(numaleatorio).getApodo());

                try {
                    System.out.printf("[%s] Me voy a descansar\n\n",getApodo());
                    Thread.sleep(random.nextInt(5000) + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        System.out.printf("[%s]ADIOS\n",getApodo());
    }
}

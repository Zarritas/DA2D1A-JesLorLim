import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Principal {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(8);
        Caja caja = new Caja();
        Anfitrion anfitrion = new Anfitrion("ANFITRION", caja);
        List<Invitado> invitados = Fabrica.generarInvitados(caja);
        Detective detective = new Detective("COLOMBO", invitados, anfitrion, new Regalo("PISTOLA"));

        executor.submit(anfitrion);
        for (Invitado invitado: invitados) {
            executor.submit(invitado);
        }
        executor.submit(detective);
        System.out.println("Todos los hilos creados");


        executor.shutdown();
        try {
            if (!executor.awaitTermination(100, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Memoria");
        if (caja.estaVacia()){
            System.out.println("Soy la caja y estoy vacía");
        }else {
            System.out.printf("Soy la caja y tengo en mi interior :%s\n",caja);
        }
        System.out.printf("Soy %s y me faltaban por entregar los regalos : ",anfitrion.getApodo());
        for (Regalo regalo: anfitrion.getRegalos()) {
            System.out.printf("%s ,",regalo);
        }
        for (Invitado invitado: invitados) {
            System.out.printf("\nSoy %s y tengo en mi posesión el regalo: %s\n",invitado.getApodo(),invitado.getRegalo());
        }

        System.out.printf("Soy %s y he adivinado el portador de la pistola en un total de %d preguntas\n",detective.getApodo(),detective.getPreguntas());
        System.out.println("Todos los hilos terminados.");
    }
}

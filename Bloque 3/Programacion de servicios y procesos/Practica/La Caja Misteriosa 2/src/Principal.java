import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Principal {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(8);
        Caja caja = new Caja();
        Anfitrion anfitrion = new Anfitrion("ANFITRION", Fabrica.generarRegalos(), caja);
        List<Invitado> invitados = Fabrica.generarInvitados(caja);
        Detective detective = new Detective("COLOMBO", invitados, anfitrion, new Regalo("PISTOLA"));

        executor.execute(anfitrion);
        for (Invitado invitado: invitados) {
            executor.execute(invitado);
        }
        executor.execute(detective);

        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Memoria");
        if (caja.estaVacia()){
            System.out.println("Soy la caja y estoy vacía");
        }else {
            System.out.println("Soy la caja y tengo en mi interior :"+caja.to());
        }
        System.out.print("Soy "+anfitrion.getApodo()+" y me faltaban por entregar los regalos : ");
        for (String regalo: anfitrion.getRegalos()) {
            System.out.print(regalo+" ");
        }
        for (Invitado invitado: invitados) {
            System.out.println("\nSoy "+invitado.getApodo()+" y tengo en mi posesión el regalo: "+invitado.getRegalo());
        }

        System.out.println("Soy "+detective.getApodo()+" y he adivinado el portador de la pistola");
        System.out.println("Todos los hilos terminados.");
    }
}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Principal {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(8);
        Caja caja = new Caja();
        Anfitrion anfitrion = new Anfitrion("SR. LEMON", caja);
        Invitados invi1 = new Invitados("SRTA. AMAPOLA",caja);
        Invitados invi2 = new Invitados("PROFESORA RUBIO", caja);
        Invitados invi3 = new Invitados("SRTA. PRADO",caja);
        Invitados invi4 = new Invitados("DR. MANDARINO",caja);
        Invitados invi5 = new Invitados("SR. PIZARRO",caja);
        Invitados invi6 = new Invitados("MARQUES DE MARINA",caja);
        Detective detective = new Detective("COLOMBO",invi1,invi2,invi3,invi4,invi5,invi6,anfitrion);

        executor.submit(anfitrion);
        executor.submit(invi1);
        executor.submit(invi2);
        executor.submit(invi3);
        executor.submit(invi4);
        executor.submit(invi5);
        executor.submit(invi6);
        executor.submit(detective);
        System.out.println("Todos los hilos creados");


        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("Memoria");
        if (caja.vacia()){
            System.out.println("Soy la caja y estoy vacía");
        }else {
            System.out.println("Soy la caja y tengo en mi interior :"+caja.getRegalo());
        }
        System.out.print("Soy "+anfitrion.getNombre()+" y me faltaban por entregar los regalos : ");
        for (String regalo: anfitrion.getRegalos()) {
            System.out.print(regalo+" ");
        }
        System.out.println("\nSoy "+invi1.getNombre()+" y tengo en mi posesión el regalo: "+invi1.getRegalo());
        System.out.println("Soy "+invi2.getNombre()+" y tengo en mi posesión el regalo: "+invi2.getRegalo());
        System.out.println("Soy "+invi3.getNombre()+" y tengo en mi posesión el regalo: "+invi3.getRegalo());
        System.out.println("Soy "+invi4.getNombre()+" y tengo en mi posesión el regalo: "+invi4.getRegalo());
        System.out.println("Soy "+invi5.getNombre()+" y tengo en mi posesión el regalo: "+invi5.getRegalo());
        System.out.println("Soy "+invi6.getNombre()+" y tengo en mi posesión el regalo: "+invi6.getRegalo());
        System.out.println("Soy "+detective.getNombre()+" y he hecho un total de "+detective.getPreguntas()+" preguntas antes de adivinar el portador de la pistola");
        System.out.println("Todos los hilos terminados.");
    }
}
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Creacion de objetos
        Cofre cofre = new Cofre();
        Infante infante1= new Infante("ANGELINA", cofre);
        Infante infante2= new Infante("BRAD", cofre);

        // Inicialización de los hilos
        executor.execute(infante1);
        executor.execute(infante2);
        System.out.printf("COFRE: %s\n", cofre.contenidoCaja());

        // Finalización de los hilos
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        // Memoria
        System.out.println("Memoria");
        System.out.println(infante1);
        System.out.println(infante2);
        System.out.println("COFRE: "+ cofre.contenidoCaja());

    }



}
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Principal {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Baul baul = new Baul();
        Productor productor = new Productor(baul);
        Consumidor consumidor1 = new Consumidor('A',baul);
        Consumidor consumidor2 = new Consumidor('B',baul);
        Consumidor consumidor3 = new Consumidor('C',baul);

        executor.submit(productor);
        executor.submit(consumidor1);
        executor.submit(consumidor2);
        executor.submit(consumidor3);
        System.out.println("Todos los hilos iniciados");

        try {
            executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdownNow();
        System.out.println("todos los hilos terminados");
    }
}
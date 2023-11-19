import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Principal {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Caja caja = new Caja();

        Infante infante1= new Infante("ANGELINA",caja);
        Infante infante2= new Infante("BRAD",caja);

        executor.submit(infante1);
        executor.submit(infante2);

        executor.shutdown();


    }



}
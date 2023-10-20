import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.time.LocalDateTime.now;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Principal {


    public static void main(String[] args) {
        Vector vector= new Vector(18);
        Escritor escritor1=new Escritor("Calderon",vector,1);
        Escritor escritor2=new Escritor("Machado",vector,11);
        Escritor escritor3=new Escritor("Lope de Vega",vector,111);
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(escritor1);
        executorService.execute(escritor2);
        executorService.execute(escritor3);
        executorService.shutdown();
    }
}
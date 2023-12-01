import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class Principal {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Creamos cada uno de los objetos a usar
        Bombo bombo = new Bombo();
        Combinacion numPremiado = new Combinacion();
        //Los infantes se generan desde fabrica como lista inamovible
        List<Infante> infantes = Fabrica.generarInfantes(bombo,numPremiado);

        // Lanzamos los Hilos
        for (Infante infante: infantes) {
            executor.execute(infante);
        }

        executor.shutdown();
        try {
            // Si el tiempo de espera de 20 segundos se supera salta la excepción
            // y finaliza todos los Hilos para que no se quede ninguno sin cerrar
            // en caso contrario ejecuta el now para que siga el programa main.
            if(!executor.awaitTermination(20, TimeUnit.SECONDS))
                executor.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
            executor.shutdownNow();
        }
        System.out.println("Felicidades al "+numPremiado+"\n Te has llevado 10€ en amazon");
    }
}
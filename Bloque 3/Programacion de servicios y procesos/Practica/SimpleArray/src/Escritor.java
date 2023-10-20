import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.function.Function;

import static java.time.LocalDateTime.now;

public class Escritor implements Runnable{
    private static SecureRandom s = new SecureRandom();
    private static final int MAX_TIEMPO = 500;
    private static final int CANTIDAD= 6;
    private String nombre;
    private Vector vector;
    private int inicial;
    public Escritor(String nombre, Vector vector, int inicial) {
        this.nombre = nombre;
        this.vector=vector;
        this.inicial=inicial;
    }


    @Override
    public void run() {
        LocalDateTime fh = now();
        Function<LocalDateTime, String> ffh = (fechaHora) -> DateTimeFormatter.ofPattern("HH:mm:ss.SSS").format(fechaHora);
        System.out.printf("Soy %s y voy a empezar a escribir en el vector compartido a las "+ ffh.apply(now())+"%n",nombre);
        for (int i = inicial; i < inicial+CANTIDAD; i++) {
            synchronized (vector){
                int tiempo=s.nextInt(MAX_TIEMPO);
                System.out.printf("Soy %s y voy a esperar %d ms a las "+ ffh.apply(now())+"%n",nombre,tiempo);
                vector.agregarValor(i);
                System.out.printf("Soy %s y he escrito un %d en el vector %s a las "+ ffh.apply(now())+"%n",nombre,i,vector);
                vector.notify();
                try {
                    vector.wait(tiempo);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        System.out.println("Codigo terminado a las "+ffh.apply(now()));
    }

    @Override
    public String toString() {
        return "Escritor{" +
                "vector=" + vector +
                ", inicial=" + inicial +
                "} \n";
    }
}

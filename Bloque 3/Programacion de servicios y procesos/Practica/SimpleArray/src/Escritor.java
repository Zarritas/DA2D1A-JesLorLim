import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

import static java.time.LocalDateTime.now;

public class Escritor implements Runnable{
    private static SecureRandom s = new SecureRandom();
    private static final int MAX_TIEMPO = 500;
    private static final int CANTIDAD= 6;
    private String nombre;
    private Vector vector;
    private int inicial;
    private static int turno=0;
    private int numero;

    private synchronized void cambiarTurno(){
        turno = 1-numero;
    }
    public Escritor(String nombre, Vector vector, int inicial, int turno) {
        this.nombre = nombre;
        this.vector=vector;
        this.inicial=inicial;
        this.numero = turno;
    }


    @Override
    public void run() {
        LocalDateTime fh = now();
        Function<LocalDateTime, String> ffh = (fechaHora) -> DateTimeFormatter.ofPattern("HH:mm:ss.SSS").format(fechaHora);
        System.out.printf("Soy %s y voy a empezar a escribir en el vector compartido a las "+ ffh.apply(now())+"%n",nombre);
        for (int i = inicial; i < inicial+CANTIDAD; i++) {
            synchronized (vector){
                int tiempo = s.nextInt(MAX_TIEMPO);
                System.out.printf("Soy %s y voy a esperar %d ms a las " + ffh.apply(now()) + "%n", nombre, tiempo);
//                vector.notify();
                while(numero!=turno) {
                    try {
                        vector.wait(tiempo);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                vector.agregarValor(i);
                System.out.printf("Soy %s y he escrito un %d en el vector %s a las " + ffh.apply(now()) + "%n", nombre, i, vector);
                cambiarTurno();
            }
        }
    }

    @Override
    public String toString() {
        return "Escritor{" +
                "vector=" + vector +
                ", inicial=" + inicial +
                "} \n";
    }
}

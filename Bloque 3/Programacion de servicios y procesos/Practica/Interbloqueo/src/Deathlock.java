import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.function.Function;

import static java.time.LocalDateTime.now;

public class Deathlock implements Runnable{
    private static SecureRandom s = new SecureRandom();
    private static final int MAX_TIEMPO = 500;
    private static final int CANTIDAD= 6;
    private String nombre;
    private Vector vector1;
    private Vector vector2;
    private int inicial;
    private static int turno=0;
    private int numero;

    private synchronized void cambiarTurno(){
        turno = 1-numero;
    }
    public Deathlock(String nombre, Vector vector1, Vector vector2, int inicial, int turno) {
        this.nombre = nombre;
        this.vector1=vector1;
        this.vector2=vector2;
        this.inicial=inicial;
        this.numero = turno;
    }


    @Override
    public void run() {

    }

    @Override
    public String toString() {
        return "Escritor{" +
                "vector1=" + vector1 +
                ", inicial=" + inicial +
                "vector2=" + vector2 +
                "} \n";
    }
}

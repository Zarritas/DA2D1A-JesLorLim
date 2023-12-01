import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

import static java.time.LocalDateTime.now;

public class Infante implements Runnable{
    private final String apodo;
    private final int TIEMPO1=3000;
    private final SecureRandom random;
    private Bola bolsillo;
    private final Bombo bombo;
    private final Combinacion numPremiado;

    public Infante(String apodo,Bombo bombo, Combinacion numPremiado) {
        this.apodo = apodo;
        this.bombo = bombo;
        this.numPremiado = numPremiado;
        random = new SecureRandom();
    }

    public void setBolsillo(Bola bola) {
        this.bolsillo = bola;
    }

    @Override
    public void run() {
        LocalDateTime fh = now();
        Function<LocalDateTime,String> ffh =
                (fechaHora) -> DateTimeFormatter.ofPattern("HH:mm:ss.SSS").format(fechaHora);
        // Momento de Silbar para ver que todos los hilos entran sin problema
        try {
            System.out.printf("[%s] SILVO\n",apodo);
            Thread.sleep(random.nextInt(TIEMPO1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (bombo){
            // Generamos aleatoriamente la Bola que vamos a coger
            int numeroAleatorio= random.nextInt(bombo.tamanioBombo());

            // Cogemos la bola del bombo y creamos la copia en el bolsillo
            setBolsillo(bombo.cogerBola(numeroAleatorio));
            System.out.printf("[%s] cojo la bola %s a las %s\n",apodo,bolsillo,ffh.apply(fh));

            // Volvemos a meter la misma bola en el Bombo
            bombo.meterBola(bolsillo);

        }
        // Canta la Bola que vamos a meter
        try {
            System.out.printf("[%s] BOOOOOOOOOOOOOOOOOOLA %s\n",apodo,bolsillo);
            Thread.sleep(random.nextInt(TIEMPO1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (numPremiado){
            // Metemos la Bola en el numero premiado y damos la información del mismo
            numPremiado.meterBola(bolsillo);
            System.out.println(numPremiado+" a las "+ffh.apply(fh));

        }
    }
}

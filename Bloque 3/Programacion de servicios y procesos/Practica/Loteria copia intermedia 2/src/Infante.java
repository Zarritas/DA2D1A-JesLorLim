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
    private Bombo bombo;
    private Combinacion numPremiado;

    public Infante(String apodo,Bombo bombo, Combinacion numPremiado) {
        this.apodo = apodo;
        this.bombo = bombo;
        this.numPremiado = numPremiado;
        random = new SecureRandom();
    }

    public void setBolsillo(Bola bolsillo) {
        this.bolsillo = bolsillo;
    }

    @Override
    public void run() {
        LocalDateTime fh = now();
        Function<LocalDateTime,String> ffh =
                (fechaHora) -> DateTimeFormatter.ofPattern("HH:mm:ss.SSS").format(fechaHora);
        while (!numPremiado.estaLleno() && bolsillo != null);{
            // Momento de Silbar
            try {
                System.out.printf("[%s] SILVO\n",apodo);
                Thread.sleep(random.nextInt(TIEMPO1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (bombo){
                int numeroAleatorio= random.nextInt(bombo.tamanioBombo());
                setBolsillo(bombo.cogerBola(numeroAleatorio));
                System.out.printf("[%s] cojo la bola %s a las %s\n",apodo,bolsillo,ffh.apply(fh));

                bombo.meterBola(bolsillo);

                // Canta la Bola que va a meter
                try {
                    System.out.printf("[%s] BOOOOOOOOOOOOOOOOOOLA %s\n",apodo,bolsillo);
                    Thread.sleep(random.nextInt(TIEMPO1));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            synchronized (numPremiado){
                numPremiado.meterBola(bolsillo);
                System.out.println(numPremiado+" a las "+ffh.apply(fh));
                numPremiado.notifyAll();
            }

        }
    }
}

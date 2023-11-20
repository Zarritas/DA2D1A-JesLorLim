import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.time.LocalDateTime.now;


public class Infante implements Runnable{

    private final String apodo;
    private final List<Juguete> bolsillo;
    private final Cofre cofre;
    private final SecureRandom random;
    private final List<Juguete> tiposDeJuguetes;


    public Infante(String apodo, Cofre cofre) {
        this.apodo = apodo;
        this.cofre = cofre;
        this.tiposDeJuguetes = new ArrayList<>() {{
            add(new Juguete(TipoJuguete.ARCO));
            add(new Juguete(TipoJuguete.FLECHA));
        }};
        bolsillo = new ArrayList<>();
        this.random = new SecureRandom();
    }

    public String getApodo() {
        return apodo;
    }

    public void setJuguete(Juguete juguete){
        bolsillo.add(juguete);
    }

    @Override
    public String toString() {
        return "'" + apodo + "', bolsillo=" + bolsillo;
    }

    @Override
    public void run() {
        // Info de entrada de los Hilos
        System.out.printf("[%s] Entro al programa.\n",getApodo());

        // Formateo de Tiempos de ejecución
        Function<LocalDateTime, String> ffh =
                (fechaHora) -> DateTimeFormatter.ofPattern("HH:mm:ss.SSS").format(fechaHora);

        // Bucle para que coja 2 juguetes
        while(bolsillo.size()!=2) {
            // Mandamos a pensar a los hilos
            try {
                System.out.printf("[%s] voy a esperar un tiempo aleatorio de entre 0 y 3 segundos. Tiempo de ejecución en : %s\n", getApodo(),ffh.apply(now()));
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Elejimos el que juguete queremos coger
            Juguete jugueteNuevo = tiposDeJuguetes.get(random.nextInt(tiposDeJuguetes.size()));
            System.out.printf("Soy %s y quiero cojer un %s. Tiempo de ejecución en : %s \n", getApodo(), jugueteNuevo.getColor(),ffh.apply(now()));

            // Zona Crítica
            synchronized (cofre) {
                // Comprobamos que el juguete que queremos esté en la caja
                if (cofre.getListaJuguetes().contains(jugueteNuevo)) {
                    // Si está en la caja
                    setJuguete(cofre.sacarJuguete(cofre.getListaJuguetes().indexOf(jugueteNuevo)));
                    System.out.printf("Soy %s y he cogido un %s. Tiempo de ejecución en : %s \n", getApodo(), jugueteNuevo.getColor(),ffh.apply(now()));
                } else {
                    // Si no está en la caja
                    System.out.printf("Soy %s y no he podido cojer el %s que necesito para jugar. Tiempo de ejecución en : %s\n", getApodo(), bolsillo.get(0).getColor(),ffh.apply(now()));
                }
                System.out.printf("COFRE: %s\n", cofre.contenidoCaja());
            }
        }

        // Comprobante de que Juguete tiene.
        if (bolsillo.contains(tiposDeJuguetes.get(0)) && bolsillo.contains(tiposDeJuguetes.get(1))){
            System.out.printf("Soy %s y estoy contento porq voy a jugar con mi arco y flecha. Tiempo de ejecución en : %s\n",getApodo(),ffh.apply(now()));
        }else if(bolsillo.get(0).equals(bolsillo.get(1))) {
            if (bolsillo.get(0).equals(tiposDeJuguetes.get(0))){
                System.out.printf("Soy %s y estoy triste porq tengo dos %s pero no puedo jugar porq me fata un %s. Tiempo de ejecución en : %s\n", getApodo(), bolsillo.get(0).getColor(), tiposDeJuguetes.get(1).getColor(),ffh.apply(now()));
            }else if (bolsillo.get(0).equals(tiposDeJuguetes.get(1))){
                System.out.printf("Soy %s y estoy triste porq tengo dos %s pero no puedo jugar porq me fata una %s. Tiempo de ejecución en : %s\n", getApodo(), bolsillo.get(0).getColor(), tiposDeJuguetes.get(0).getColor(),ffh.apply(now()));
            }
        }
    }
}


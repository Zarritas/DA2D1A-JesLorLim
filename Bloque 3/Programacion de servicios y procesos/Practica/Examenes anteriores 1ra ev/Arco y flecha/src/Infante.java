import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Infante implements Runnable{

    private final String apodo;

    private final List<Juguete> juguetes;

    private final Caja caja;

    private final SecureRandom random;

    private final List<Juguete> tiposJuguetes;

    public Infante(String apodo, Caja caja) {
        this.apodo = apodo;
        this.caja=caja;
        this.tiposJuguetes = new ArrayList<>() {{
            add(new Juguete(TipoJuguete.ARCO));
            add(new Juguete(TipoJuguete.FLECHA));
        }};
        juguetes = new ArrayList<>();
        this.random = new SecureRandom();
    }

    public String getApodo() {
        return apodo;
    }

    public List<Juguete> getJuguetes() {
        return juguetes;
    }

    public void setJuguete(Juguete juguete){
        juguetes.add(juguete);
    }

    @Override
    public void run() {
        // Info de entrada de los Hilos
        System.out.printf("[%s] Entro al programa.\n",getApodo());

        // Bucle para que coja 2 juguetes
        while(juguetes.size()!=2) {
            synchronized (caja) {

                //Mandamos a pensar a los hilos
                try {
                    System.out.printf("[%s] voy a esperar un tiempo aleatorio de entre 0 y 3 segundos.\n", getApodo());
                    caja.wait(random.nextInt(3000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                //Elejimos el
                Juguete jugueteNuevo = tiposJuguetes.get(random.nextInt(tiposJuguetes.size()));
                System.out.printf("Soy %s y quiero cojer un %s\n", getApodo(), jugueteNuevo.getColor());

                if (caja.getListaJuguetes().contains(jugueteNuevo)) {
                    setJuguete(caja.sacarJuguete(caja.getListaJuguetes().indexOf(jugueteNuevo)));
                    caja.notifyAll();
                } else {
                    System.out.printf("Soy %s y no he podido cojer el %s que necesito para jugar.\n", getApodo(), juguetes.get(0).getColor());
                }

            }
        }

        //Comprobante de que Juguetes tiene.
        if (juguetes.contains(tiposJuguetes.get(0)) && juguetes.contains(tiposJuguetes.get(1))){
            System.out.printf("Soy %s y estoy contento porq voy a jugar con mi arco y flecha\n",getApodo());
        }else if(getJuguetes().get(0).equals(getJuguetes().get(1))) {
            if (getJuguetes().get(0).equals(tiposJuguetes.get(0))){
                System.out.printf("Soy %s y estoy triste porq tengo dos %s pero no puedo jugar porq me fata una %s\n", getApodo(), getJuguetes().get(0).getColor(), tiposJuguetes.get(0).getColor());
            }else if (getJuguetes().get(0).equals(tiposJuguetes.get(1))){
                System.out.printf("Soy %s y estoy triste porq tengo dos %s pero no puedo jugar porq me fata una %s\n", getApodo(), getJuguetes().get(0).getColor(), tiposJuguetes.get(1).getColor());
            }
        }

    }
}


import java.util.ArrayList;

public class Combinacion {
    private static ArrayList<Bola> numPremiado = new ArrayList<>();

    public void meterBola(Bola numBola) {
        numPremiado.add(numBola);
    }

    @Override
    public String toString() {
        return "NumPremiado=" + numPremiado;
    }
}

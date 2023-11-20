import java.util.ArrayList;

public class Combinacion {
    private static ArrayList<Bola> numPremiado = new ArrayList<>();

    public void meterBola(Bola numBola) {
        numPremiado.add(numBola);
    }

    public boolean estaLleno(){
        return numPremiado.size()==5;
    }

    @Override
    public String toString() {
        return "NumPremiado=" + numPremiado;
    }
}

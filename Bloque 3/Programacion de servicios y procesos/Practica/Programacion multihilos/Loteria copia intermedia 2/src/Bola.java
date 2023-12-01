public class Bola {
    private int numero;
    private static int aux;

    public Bola() {
        this.numero = aux++;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return ""+numero+"";
    }
}

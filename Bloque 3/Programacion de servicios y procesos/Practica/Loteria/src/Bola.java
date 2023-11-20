public class Bola {
    private Integer numero;
    // Usamos el auxiliar para no tener que pasarle por parametro nada a las bolas
    // y podamos simplemente crearlas con un for en la clase Bombo
    private static Integer aux = 0;

    public Bola() {
        this.numero = aux++;
    }

    @Override
    public String toString() {
        return Integer.toString(numero);
    }
}

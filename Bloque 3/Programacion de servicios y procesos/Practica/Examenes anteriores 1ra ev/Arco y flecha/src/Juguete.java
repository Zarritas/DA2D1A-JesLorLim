public class Juguete {

    private final int numero;
    private final TipoJuguete color;
    private static int aux;

    public Juguete(TipoJuguete color) {
        numero = aux++;
        this.color = color;

    }

    public TipoJuguete getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Juguete juguete)) return false;
        return color == juguete.color;
    }

    @Override
    public String toString() {
        return "Juguete tipo=" + color +" ";
    }
}

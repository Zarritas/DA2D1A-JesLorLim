public class Baul {
    private char contenido;

    public Baul() {
        this.contenido = '\0';
    }

    public void setContenido(char contenido) {
        this.contenido = contenido;
    }

    public char getContenido() {
        return contenido;
    }

    public char vaciar(){
        char caracter = contenido;
        this.contenido = '\0';
        return caracter;
    }

    public boolean estaVacio() {
            return contenido=='\0';
    }

    @Override
    public String toString() {
        return "Baul{" +
                "contenedor=" + contenido +
                '}';
    }
}

public class Baul {
    private char contenido;

    public Baul() {
        this.contenido = '\0';
    }

    public void llenarBaul(char contenido) {
        this.contenido = contenido;
    }

    public char getContenido() {
        return contenido;
    }

    public void vaciarBaul(){
        this.contenido = '\0';
    }

    public boolean baulVacio() {
            return contenido=='\0';
    }

    @Override
    public String toString() {
        return "Baul{" +
                "contenedor=" + contenido +
                '}';
    }
}

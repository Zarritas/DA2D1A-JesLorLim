import org.jetbrains.annotations.NotNull;

public class Juguete {
    private String nombre;      // NO NULO

    public Juguete(String nombre) {
        setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(@NotNull String nombre) {
        this.nombre=nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

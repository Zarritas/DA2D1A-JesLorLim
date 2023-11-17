import org.jetbrains.annotations.NotNull;

public class Regalo {
    private String nombre;      // NO NULO, NO VACIO, NO BLANCO

    /**
     * Constructor de un regalo
     * @param nombre    NO NULO, NO VACIO, NO BLANCO
     */
    public Regalo(String nombre) {
        setNombre(nombre);
    }

    private void setNombre(@NotNull String nombre) {
        if (nombre.isEmpty())
            throw new IllegalArgumentException("El nombre del regalo no puede ser vacío");
        if (nombre.isBlank())
            throw new IllegalArgumentException("El nombre del regalo no puede estar en blanco");
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

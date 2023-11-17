import org.jetbrains.annotations.NotNull;

public class Persona {
    private String apodo;   // NO NULO, NO VACIO, NO BLANCO

    /**
     * Constructor de una persona
     * @param apodo    NO NULO, NO VACIO, NO BLANCO
     */

    public Persona(String apodo) {
        setApodo(apodo);
    }

    private void setApodo(@NotNull String apodo) {
        if (apodo.isEmpty())
            throw new IllegalArgumentException("El apodo de una persona no puede ser vacío");
        if (apodo.isBlank())
            throw new IllegalArgumentException("El apodo de una persona no puede estar en blanco");
        this.apodo = apodo;
    }

    protected String getApodo() {
        return apodo;
    }

    @Override
    public String toString() {
        return apodo;
    }
}

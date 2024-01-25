package util;

// Configuración común del servidor y del cliente
public enum Conf {
    APODO_SERVIDOR("SERVIDOR"),
    HOST("localhost"),
    PUERTO(8000),
    MIN_PUERTO(1),
    MAX_PUERTO(65535),
    FINAL("/fin"),
    MENSAJE_DESPEDIDA("¡Adios querido cliente!"),
    MAX_CLIENTES(9);
    private Object o;

    Conf(Object o) {
        this.o = o;
    }

    public int n() {
        return (int) o;
    }

    public String s() {
        return (String)o;
    }
}

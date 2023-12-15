package cliente;

import org.jetbrains.annotations.NotNull;

public class Cliente {
    private final String Nombre;
    private final int numero;
    private static int aux = 1;

    public Cliente(@NotNull String nombre) {
        Nombre = nombre;
        this.numero = aux++;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getNumero() {
        return numero;
    }

}

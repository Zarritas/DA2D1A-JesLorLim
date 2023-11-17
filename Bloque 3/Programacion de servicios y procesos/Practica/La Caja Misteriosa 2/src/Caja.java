import org.jetbrains.annotations.NotNull;

public class Caja {
    private Regalo regalo;

    public Caja() {
    }

    public void meterRegalo(@NotNull Regalo regalo) {
        this.regalo = regalo;
    }

    public Regalo sacarRegalo() {
        Regalo aux = this.regalo;
        regalo = null;
        return aux;
    }

    public boolean estaVacia() {
        return regalo==null;
    }

    @Override
    public String toString() {
        return regalo.toString();
    }
}

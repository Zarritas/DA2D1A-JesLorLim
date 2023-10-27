import java.util.Arrays;

public class Vector {

    private int[] R1;
    private int indice1;

    public Vector(int longitud) {
        this.R1 = new int[longitud];
        this.indice1 = 0;
    }

    public void agregarValor(int x){
        R1[indice1] = x;
        indice1++;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "R1=" + Arrays.toString(R1) +
                ", indice1=" + indice1 +
                '}';
    }
}

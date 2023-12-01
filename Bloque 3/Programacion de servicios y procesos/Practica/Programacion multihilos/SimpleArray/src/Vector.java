import java.util.Arrays;

public class Vector {
    private int[] array;
    private int pos;

    public Vector(int longitud) {
        this.array = new int[longitud];
        this.pos = 0;
    }

    public void agregarValor(int x){
        array[pos] = x;
        pos++;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "array=" + Arrays.toString(array) +
                ", pos"+pos+
                '}';
    }
}
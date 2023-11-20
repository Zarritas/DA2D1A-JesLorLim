import java.util.ArrayList;
import java.util.List;

public class Fabrica {
    public static List<Infante> generarInfantes(Bombo bombo, Combinacion numPremiado) {
        List<String> apodos =new ArrayList<>(List.of("AMANDA", "BEATRIZ", "CARLOS", "DANIELA", "EDUARDO"));
        return apodos.stream().map(a -> new Infante(a, bombo, numPremiado)).toList();
    }
}

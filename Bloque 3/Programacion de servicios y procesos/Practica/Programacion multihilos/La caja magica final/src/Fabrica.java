import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fabrica {
    private Fabrica() {}

    public static List<Invitado> generarInvitados(Caja caja) {
        List<String> apodos =new ArrayList<> (List.of("SRTA. AMAPOLA", "DR. MANDARINO", "SRTA. PRADO", "PROFESORA RUBIO", "SR. PIZARRO", "MARQUES DE MARINA"));
        return apodos.stream().map(a -> new Invitado(a, caja)).toList();
    }

    public static List<Regalo> generarRegalos() {
        List<String> regalos = new ArrayList<> (List.of("ANILLO", "RELOJ", "PISTOLA", "CARAMELO", "MOVIL", "ROSA"));
        return regalos.stream().map(Regalo::new).toList();
    }
}

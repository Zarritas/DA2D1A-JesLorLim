import java.util.List;

public class Principal {

    public static void main(String[] args) {
        Caja caja = new Caja();
        Anfitrion anfitrion = new Anfitrion("ANFITRION", Fabrica.generarRegalos(), caja);
        List<Invitado> invitados = Fabrica.generarInvitados(caja);
    }
}

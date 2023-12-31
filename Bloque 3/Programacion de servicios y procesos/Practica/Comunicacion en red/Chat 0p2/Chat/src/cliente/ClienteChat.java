package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.jetbrains.annotations.NotNull;
import util.Util;

import static util.EchoError.ERROR_HOST_INVALIDO;
import static util.Util.error;
import static util.Util.mensaje;
import static util.Conf.APODO_SERVIDOR;

/**
 * Cliente Chat
 * arg[0]   Apodo del cliente
 * arg[1]   IP del servidor
 * arg[2]   Puerto del servidor
 * Palabra clave de finalización: /fin
 *
 * @author Eduardo Barra Balao
 * @version 0.2
 */
public class ClienteChat {
    private String apodo;               // Apodo del cliente
    private InetAddress ipServidor;     // IP del servidor
    private int puertoServidor;         // Puerto del servidor

    public ClienteChat(@NotNull String apodo, @NotNull InetAddress ipServidor, @NotNull int puertoServidor) {
        this.apodo = apodo;
        this.ipServidor = ipServidor;
        this.puertoServidor = puertoServidor;
    }

    public static void main(String[] args)  {
        if (args.length != 3) {
            uso();
            System.exit(1);
        }
        String apodo = args[0];

        // TODO: 17/12/2023 Usar parámetro args[1] como IP del servidor. Por ahora se usa localhost
        InetAddress ipServidor = null;
        try {
            ipServidor = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            error(ERROR_HOST_INVALIDO, "localhost");      // TODO: 17/12/2023 Cambiar localhost a args[1]
            uso();
            System.exit(1);
        }

        int puertoServidor = Integer.parseInt(args[2]);         // TODO: 17/12/2023 T05, T08
        try {
            new ClienteChat(apodo, ipServidor, puertoServidor).iniciar();
            System.out.println("Fin del cliente: "+apodo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void iniciar() throws IOException {
        try (
                Socket socket = new Socket(ipServidor, puertoServidor);
                PrintWriter salidaSocket = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader entradaSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader entradaEstandar = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String entradaUsuario;
            while ((entradaUsuario = entradaEstandar.readLine()) != null) {
                salidaSocket.println(mensaje(apodo, entradaUsuario, socket));   // Mensaje del cliente al servidor
                System.out.println(mensaje(apodo, entradaUsuario, socket));     // Mensaje del cliente por pantalla

//                Mostrar el mensaje del servidor por pantalla
//                System.out.println(mensaje(APODO_SERVIDOR.s(), entradaSocket.readLine(), socket));
                
                if (entradaUsuario.equals("/fin")) {
                    break;
                }
            }
        }
    }

    private static void uso() {
        Util.uso("apodo puerto");
    }
}

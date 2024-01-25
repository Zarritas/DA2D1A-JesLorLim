package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.jetbrains.annotations.NotNull;
import util.Conf;
import util.EchoError;
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
 * @version 0.3.1
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

    public static void main(String[] args) {
        try {
            String apodo =APODO_SERVIDOR.s() ;
            InetAddress ipServidor = InetAddress.getByName(Conf.HOST.s());
            int puertoServidor = Conf.PUERTO.n();
            if (args.length == 3) {
                apodo = args[0];
                ipServidor = InetAddress.getByName(args[1]);
                puertoServidor = Integer.parseInt(args[2]);
            }
            new ClienteChat(apodo, ipServidor, puertoServidor).iniciar();
            System.out.println("Fin del cliente: " + apodo);
        } catch (IOException e) {
            uso();
            System.exit(1);
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
            String linea;
            while ((entradaUsuario = entradaEstandar.readLine()) != null) {
                System.out.println(mensaje(apodo, entradaUsuario, socket));     // Mensaje del cliente por pantalla
                salidaSocket.println(mensaje(apodo, entradaUsuario, socket));   // Mensaje del cliente al servidor

                // Mostrar el mensaje del servidor por pantalla
                System.out.println(mensaje(APODO_SERVIDOR.s(), entradaSocket.readLine(), socket));
                if (entradaUsuario.equals("/fin")) {
                    // Mostrar el mensaje de despedida del servidor por pantalla
                    System.out.println(mensaje(APODO_SERVIDOR.s(), entradaSocket.readLine(), socket));
                    break;
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
            error(EchoError.valueOf(e.getMessage()), e.getMessage());
            System.exit(1);
        }
    }

    private static void uso() {
        Util.uso("apodo ip_servidor puerto_servidor");
    }
}

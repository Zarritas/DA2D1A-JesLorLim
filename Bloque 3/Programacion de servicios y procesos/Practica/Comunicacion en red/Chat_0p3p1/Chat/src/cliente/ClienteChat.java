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

import static util.Conf.*;
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

    public static void main(String[] args){
        String apodo = args[0]; // Obligatorio por parametros
        InetAddress ipServidor = null;
        int puertoServidor = 0;         // TODO: 17/12/2023 T05, T08

        if (args.length != 3) {
            try {
                ipServidor = InetAddress.getByName(HOST.s());
                puertoServidor = PUERTO.n();

            } catch (UnknownHostException e) {
                error(ERROR_HOST_INVALIDO, HOST.s());
                uso();
                System.exit(1);
            }
        }else {
            try {
                ipServidor = InetAddress.getByName(args[1]);
                puertoServidor = Integer.parseInt(args[2]);
            } catch (UnknownHostException e) {
                error(ERROR_HOST_INVALIDO, args[1]);
                uso();
                System.exit(1);
            }
        }
        try {
            new ClienteChat(apodo, ipServidor, puertoServidor).iniciar();
            System.out.println("Fin del cliente: " + apodo);
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
        }
    }

    private static void uso() {
        Util.uso("apodo ip_servidor puerto_servidor");
    }
}

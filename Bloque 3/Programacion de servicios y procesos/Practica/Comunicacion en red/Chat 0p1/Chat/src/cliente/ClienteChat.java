package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

import util.Util;

/**
 * Cliente Chat
 * arg[0]   Puerto del servidor
 *
 * Palabra clave de finalización: /fin
 *
 * @author Eduardo Barra Balao
 * @version 0.1
 */
public class ClienteChat {
    private static int aux=1;
    private int numero;
    private static String nombre;

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            uso();
            System.exit(1);
        }
        nombre = args[1];
        System.out.println("Bienvenido "+nombre);
        InetAddress ip = InetAddress.getLocalHost();
        int puerto = Integer.parseInt(args[0]);
        try (
                Socket socket = new Socket(ip, puerto);
                PrintWriter salidaSocket = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader entradaSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader entradaEstandar = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String entradaUsuario;
            try {
                while ((entradaUsuario = entradaEstandar.readLine()) != null) {
                    if (entradaUsuario.equals("/fin")) {
                        break;
                    }
                    salidaSocket.println(entradaUsuario);
                    System.out.println("echo: " + entradaSocket.readLine());
                }
            }catch (SocketException e){
                System.out.println("Se ha anulado una conexión establecida por el software en su equipo host.");
                System.exit(1);
            }

        }
    }

    private static void uso() {
        Util.uso("puerto");
    }
}

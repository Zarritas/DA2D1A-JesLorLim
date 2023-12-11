package cliente;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import util.Util;

/**
 * Cliente Echo
 * arg[0]   Puerto del servidor
 *
 * Palabra clave para terminar una conexión: fin
 */
public class ClienteChat {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            uso();
            System.exit(1);
        }
        InetAddress ip = InetAddress.getLocalHost();
        int puerto = Integer.parseInt(args[0]);
        try (
                Socket socket = new Socket(ip, puerto);
                PrintWriter salidaSocket = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader entradaSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader entradaEstandar = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInput;
            while ((userInput = entradaEstandar.readLine()) != null) {
                salidaSocket.println(userInput);
                System.out.println("echo: " + entradaSocket.readLine());
            }
        }
    }

    private static void uso() {
        Util.uso("puerto");
    }


}

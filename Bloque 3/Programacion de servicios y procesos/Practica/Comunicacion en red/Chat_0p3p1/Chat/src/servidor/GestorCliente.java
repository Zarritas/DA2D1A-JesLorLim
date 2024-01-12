package servidor;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static util.Util.mensaje;


/**
 * GestorCliente
 *
 * Palabra clave de finalización: /fin
 */
public class GestorCliente implements Runnable {
    private Socket socket;
    private String apodoServidor;

    public GestorCliente(@NotNull Socket clienteSocket, @NotNull String apodoServidor) {
        this.socket = clienteSocket;
        this.apodoServidor = apodoServidor;
    }

    @Override
    public void run() {
        try (PrintWriter salidaSocket = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entradaSocket = new BufferedReader(
                     new InputStreamReader(socket.getInputStream())
             );
        ) {
            System.out.println("Servidor esperando a que el cliente envíe una línea de texto");
            String entradaUsuario;
            while ((entradaUsuario = entradaSocket.readLine()) != null) {
                System.out.println(entradaUsuario);         // Mostrar mensaje del cliente por pantalla

                // Mostrar mensaje de eco del servidor por pantalla
                System.out.println(mensaje(apodoServidor, entradaUsuario, socket));
                salidaSocket.println(entradaUsuario);       // Envío de mensaje de eco del servidor al cliente

                String[] palabrasEntradaUsuario = entradaUsuario.split(": ");
                if (palabrasEntradaUsuario.length==2 && palabrasEntradaUsuario[1].equals("/fin")) {
                    String despedida = "¡Adios querido cliente!";
                    // Mostrar mensaje de despedida del servidor por pantalla
                    System.out.println(mensaje(apodoServidor, despedida, socket));
                    salidaSocket.println(despedida);         // Envío de mensaje de despedida del servidor al cliente
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                System.out.println("El servidor ha cerrado la conexión con el cliente " + socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
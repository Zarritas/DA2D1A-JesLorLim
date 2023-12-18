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
    private Socket clienteSocket;
    private String apodoServidor;

    public GestorCliente(@NotNull Socket clienteSocket, @NotNull String apodoServidor) {
        this.clienteSocket = clienteSocket;
        this.apodoServidor = apodoServidor;
    }

    @Override
    public void run() {
        try (PrintWriter salidaSocket = new PrintWriter(clienteSocket.getOutputStream(), true);
             BufferedReader entradaSocket = new BufferedReader(
                     new InputStreamReader(clienteSocket.getInputStream())
             );
        ) {
            System.out.println("Servidor esperando a que el cliente envíe una línea de texto");
            String entradaUsuario;
            String linea;
            while ((entradaUsuario = entradaSocket.readLine()) != null) {
                System.out.println(entradaUsuario);
                salidaSocket.println(entradaUsuario);
                linea=mensaje(apodoServidor, entradaUsuario, clienteSocket);
                System.out.println(linea);
                if (entradaUsuario.equals("/fin")) {
                    String despedida = "¡Adios querido cliente!";
                    System.out.println(mensaje(apodoServidor, despedida, clienteSocket));
                    salidaSocket.println(despedida);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clienteSocket.close();
                System.out.println("El servidor ha cerrado la conexión con el cliente " + clienteSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
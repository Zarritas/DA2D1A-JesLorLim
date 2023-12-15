package servidor;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * GestorCliente
 *
 * Palabra clave de finalización: /fin
 */
public class GestorCliente implements Runnable {
    private Socket clienteSocket;
    private String nombre;

    public GestorCliente(@NotNull Socket clienteSocket) {
        this.clienteSocket = clienteSocket;
    }

    @Override
    public void run() {
        try (PrintWriter socketOut = new PrintWriter(clienteSocket.getOutputStream(), true);
             BufferedReader socketIn = new BufferedReader(
                     new InputStreamReader(clienteSocket.getInputStream())
             );
        ) {
            System.out.println("Servidor esperando a que el cliente envíe una línea de texto");
            String linea;
            while ((linea = socketIn.readLine()) != null) {
                System.out.printf("clientSocket %s echo: %s%n", clienteSocket, linea);
                socketOut.println(linea);
                if (linea.equals("/fin")) {
                    String despedida = "¡Adios querido cliente!";
                    socketOut.println(despedida);
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
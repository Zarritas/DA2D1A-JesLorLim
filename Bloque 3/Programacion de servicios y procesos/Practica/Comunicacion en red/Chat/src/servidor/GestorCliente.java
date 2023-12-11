package servidor;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.Socket;

public class GestorCliente implements Runnable {
    private Socket clienteSocket;

    public GestorCliente(@NotNull Socket clienteSocket) {
        this.clienteSocket = clienteSocket;
    }

    public static String mensaje() {
        return "Hola cliente";
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
            socketOut.println(mensaje());
            while ((linea = socketIn.readLine()) != null) {
                System.out.printf("clientSocket %s echo: %s%n", clienteSocket, linea);

                socketOut.println(linea);
                if (linea.equals("fin")) {
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
                System.out.println("El cliente " + clienteSocket + " se ha desconectado");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
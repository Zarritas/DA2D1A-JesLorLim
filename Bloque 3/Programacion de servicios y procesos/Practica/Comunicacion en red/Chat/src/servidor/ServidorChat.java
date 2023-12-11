package servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import util.Util;

import static util.EchoError.ERROR_PUERTO_INVALIDO;
import static util.Util.error;

/**
 * Servidor Chat
 *
 * Palabra clave para terminar una conexión: #fin
 */
public class ServidorChat {
    private int puerto;                         // Puerto del servidor
    private int maxClientes;                    // Máximo número de clientes conectados
    private ThreadGroup clientes;               // Clientes de chat

    /**
     * ServidorChat
     *
     * @param puerto        Puerto del servidor
     * @param maxCLientes   Máximo número de clientes conectados
     */
    public ServidorChat(int puerto, int maxCLientes) {
        this.puerto = puerto;
        this.maxClientes = maxCLientes;
        this.clientes = new ThreadGroup("Clientes");
    }

    /**
     * main
     *
     * @param args  [0] Puerto del servidor
     */
    public static void main(String[] args) {
        final int MAX_CLIENTES=10;
        int puerto=0;

        if (args.length != 1) {
            uso();
            System.exit(1);
        }

        try {
            puerto = Integer.parseInt(args[0]);
            if (puerto < 1 || puerto > 65535) {
                error(ERROR_PUERTO_INVALIDO, puerto);
                uso();
                System.exit(1);
            }
        } catch (NumberFormatException e) {
            error(ERROR_PUERTO_INVALIDO, puerto);
            uso();
            System.exit(1);
        }

        new ServidorChat(puerto, MAX_CLIENTES).iniciar();
    }

    public void iniciar() {
        int contador=0;
        try (ServerSocket servidorSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado en puerto "+puerto);
            while (++contador<=maxClientes) {
//                System.out.println("Esperando peticiones de conexión del cliente "+contador);
                Socket clienteSocket = servidorSocket.accept();
                System.out.println("Se ha establecido la conexión con el cliente "+contador);
                new Thread(clientes, new GestorCliente(clienteSocket)).start();
//                difusion("saludo");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void uso() {
        Util.uso("puerto");
    }
//    private void difusion(String mensaje) {
//        Thread[] threads = new Thread[clientes.activeCount()];
//        clientes.enumerate(threads);
//
//        for (Thread thread : threads) {
//            if (thread != null && !thread.equals(Thread.currentThread())) {
//
//            }
//        }
//    }
}
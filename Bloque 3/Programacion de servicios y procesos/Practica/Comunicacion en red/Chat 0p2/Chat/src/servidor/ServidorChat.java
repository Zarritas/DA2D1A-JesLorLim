package servidor;

import java.net.ServerSocket;
import java.net.Socket;
import util.Util;

import static util.Conf.MAX_PUERTO;
import static util.EchoError.ERROR_PUERTO_INVALIDO;
import static util.Util.error;
import static util.Conf.APODO_SERVIDOR;
import static util.Conf.MIN_PUERTO;
import static util.Conf.MAX_PUERTO;


/**
 * Servidor Chat
 *
 * En el servidor creamos un hilo para cada cliente conectado y simplemente hacemos eco del mensaje del cliente.
 * Es decir, una vez recibido el mensaje del cliente, lo mostramos por pantalla y se lo enviamos de vuelta al cliente.
 * Esta tarea la realiza el hilo asociado a un objeto GestorCliente.
 *
 * @author Eduardo Barra Balao
 * @version 0.2
 */
public class ServidorChat {
    private int puerto;                                 // Puerto del servidor
    private int maxClientes;                            // Máximo número de clientes conectados
    private ThreadGroup clientes;                       // Clientes de chat

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
        final int MAX_CLIENTES=9;
        int puerto=0;

        if (args.length != 1) {
            uso();
            System.exit(1);
        }

        try {
            puerto = Integer.parseInt(args[0]);
            if (puerto < MIN_PUERTO.n() || puerto > MAX_PUERTO.n()) {
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
        System.out.println("Fin del servidor: "+APODO_SERVIDOR.s());
    }

    public void iniciar() {
        int contador=0;
        try (ServerSocket servidorSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado en puerto "+puerto);
            while (++contador<=maxClientes) {
                Socket clienteSocket = servidorSocket.accept();     // Esperando peticiones de conexión del cliente
                System.out.println("Se ha establecido la conexión con el cliente "+contador);
                new Thread(clientes, new GestorCliente(clienteSocket, APODO_SERVIDOR.s())).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void uso() {
        Util.uso("puerto");
    }
}
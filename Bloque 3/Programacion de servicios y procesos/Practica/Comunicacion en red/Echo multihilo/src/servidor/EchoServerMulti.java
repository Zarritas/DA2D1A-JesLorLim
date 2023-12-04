package src.servidor;

import src.util.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static src.util.EchoError.ERROR_PUERTO_INVALIDO;

public class EchoServerMulti {
    private static int puerto;
    private static final int MAX_CONEXIONES = 3;
    /**
     * El metodo principal de las Servidor
     *
     * @param  args  argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        new EchoServerMulti().inicializacion(args);

        int portNumber = puerto;


        int contador=0;
        try (ServerSocket echoSocket = new ServerSocket(portNumber)) {
            System.out.println("Servidor iniciado en el puerto: " + portNumber);

            while (++contador<=MAX_CONEXIONES) {
                System.out.printf("Esperando peticiones de conexión del cliente %d%n", contador);
                Socket clientSocket = echoSocket.accept();
                System.out.println("Se ha establecido la conexión con el cliente "+contador);
                int finalContador = contador;
                new Thread(() -> {
                    try (PrintWriter socketOut = new PrintWriter(clientSocket.getOutputStream(), true);
                         BufferedReader socketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                    ) {
                        System.out.println("Servidor esperando a que el cliente"+ finalContador +" envíe una línea de texto");
                        String inputLine;
                        while ((inputLine = socketIn.readLine()) != null) {
                            System.out.printf("[%s]clientSocket %s echo: %s%n",finalContador, clientSocket, inputLine);
                            socketOut.println(inputLine);
                            if (inputLine.equals("fin")) {
                                String despedida="ADIOS QUERIDO CLIENTE";
                                socketOut.println(despedida);
                                break;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    /**
     * Intializa la variable puerto a partir de los argumentos
     *
     * @param  args  the arguments to initialize the function
     */
    private void inicializacion(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java src.servidor.EchoServer <port number>");
            uso();
            System.exit(1);
        }
        int puerto = Integer.parseInt(args[0]);
        if (puerto < 1 || puerto > 65535) {
            Util.error(ERROR_PUERTO_INVALIDO, puerto);
            uso();
            System.exit(1);
        }else
            EchoServerMulti.puerto = puerto;
    }
    private void uso() {
        Util.uso("puerto");
    }
}
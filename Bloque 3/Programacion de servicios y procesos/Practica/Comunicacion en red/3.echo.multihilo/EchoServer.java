import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        int contador=0;
        try (ServerSocket echoSocket = new ServerSocket(portNumber)) {
            while (++contador<=1) {
                Socket clientSocket = echoSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try (PrintWriter socketOut = new PrintWriter(clientSocket.getOutputStream(), true);
                             BufferedReader socketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        ) {
                            String inputLine;
                            while ((inputLine = socketIn.readLine()) != null) {
                                System.out.printf("clientSocket %s echo: %s%n", clientSocket, inputLine);
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
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}
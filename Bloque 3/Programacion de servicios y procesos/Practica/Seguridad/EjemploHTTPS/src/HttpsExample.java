import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/**
 * Esta clase realiza una solicitud HTTPS a un servidor y muestra la respuesta.
 */
public class HttpsExample {

    /**
     * Método principal que realiza la solicitud HTTPS y muestra la respuesta.
     *
     * @param args Argumentos de línea de comandos. Se espera que el primer argumento sea la
     *             URL a la que se realizará la solicitud.
     * @throws IOException Si hay algún error de entrada/salida durante la conexión
     */
    public static void main(String[] args){
        // Verificar si se proporcionó la URL como argumento
        if (args.length < 1) {
            System.out.println("Debe proporcionar la URL como argumento.");
            return;
        }
        try {
            // Obtener la URL del primer argumento
            String httpsURL = args[0];

            // Crear una conexión HTTPS
            URL url = new URL(httpsURL);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

            // Configurar la conexión
            conn.setRequestMethod("GET");

            // Obtener la respuesta del servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Mostrar la respuesta del servidor
            System.out.println("Respuesta del servidor:");
            System.out.println(response);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

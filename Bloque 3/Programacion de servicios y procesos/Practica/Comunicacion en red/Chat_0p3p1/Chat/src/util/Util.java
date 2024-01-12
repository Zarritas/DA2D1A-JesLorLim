package util;

import org.jetbrains.annotations.NotNull;

import java.net.Socket;

public class Util {
    private Util() {}
    public static void error(EchoError error, Object ...dato) {
        switch (error) {
            case ERROR_PUERTO_INVALIDO:
                System.out.printf("El puerto debe ser un número en el rango [1,65535] (puerto=%d)", dato[0]);
                break;
            default:
                System.err.println("Código de error desconocido: "+error);
                System.exit(1);
        }
    }

    public static String mensaje(@NotNull String apodo, @NotNull String mensaje, @NotNull Socket socket) {
        // TODO: 17/12/2023 Agregar información sobre el socket antes del apodo: [ip:puerto]
        String ip = socket.getLocalAddress().getHostAddress();
        int puerto = socket.getLocalPort();

        return String.format("[%s:%d] %s: %s", ip, puerto, apodo, mensaje);
    }

    public static void uso(@NotNull String mensaje) {
        System.out.printf("Uso: java %s %s\n", nombreClasePrincipal(), mensaje);
    }

    public static String nombreClasePrincipal() {
        // Obtenemos la pila de llamadas (stack trace)
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        // El último elemento es el método main de la clase principal
        StackTraceElement penultimoElemento = stackTrace[stackTrace.length - 1];
        return extraerNombreClase(penultimoElemento.getClassName());
    }

    public static String extraerNombreClase(@NotNull String nombreClaseCualificado) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(nombreClaseCualificado);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz.getSimpleName();
    }
}

package src.util;
import org.jetbrains.annotations.NotNull;

public class Util {
    public static void error(EchoError error, Object ...dato) {
        switch (error) {
            case ERROR_PUERTO_INVALIDO:
                System.out.printf("El puerto debe ser un número en el rango [1, 65535]: (puerto=%d)", dato[0]);
                break;
            default:
                System.err.println("Codigo de error desconocido" + error);
                System.exit(1);
        }
    }

    public static void uso(@NotNull String mensaje) {
        System.out.printf("Uso: java %s %s ", nombreClasePrincipal(), mensaje);
    }

    public static String nombreClasePrincipal() {
        StackTraceElement[] srackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement penultimoElemento = srackTrace[srackTrace.length - 1];
        return extraerNombreClase(penultimoElemento.getClassName());
    }

    private static String extraerNombreClase(@NotNull String nombreClaseCualificado) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(nombreClaseCualificado);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz.getSimpleName();
    }
}

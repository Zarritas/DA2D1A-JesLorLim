package util;

public enum EchoError {
    ERROR_PUERTO_INVALIDO(1),       // Puerto fuera de rango [1,65535]
    ERROR_HOST_INVALIDO(2);         // Nombre o dirección IP de máquina (host) no válido
    private int numero;                    // Código numérico de error para ser usado como salida del programa

    EchoError(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}

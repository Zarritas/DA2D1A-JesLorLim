public class Main {
    public static void main(String[] args) {
        Mensaje msg = new Mensaje("process it");
        Camarero Camarero = new Camarero(msg);
        new Thread(Camarero,"Camarero").start();

        Camarero Camarero1 = new Camarero(msg);
        new Thread(Camarero1, "Camarero1").start();

        Notificador Notificador = new Notificador(msg);
        new Thread(Notificador, "Notificador").start();
        System.out.println("Todos los hilos iniciados");
    }
}

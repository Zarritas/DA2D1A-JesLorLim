public class Principal {

    public static void main(String[] args) {
        Juguete arco=new Juguete("ARCO");
        Juguete flecha=new Juguete("FLECHA");

        // Creamos dos hilos con distintos órdenes de recursos para provocar el interbloqueo
        Thread hilo1 = new Thread(new Infante("CAIN", arco, flecha), "Hilo 1 [CAIN]");
        Thread hilo2 = new Thread(new Infante("ABEL", flecha, arco), "Hilo 2 [CAIN]");

        hilo1.start();
        hilo2.start();
    }
}

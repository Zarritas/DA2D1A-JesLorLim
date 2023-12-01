public class Camarero implements Runnable{
    private Mensaje msg;

    public Camarero(Mensaje m) {
        this.msg = m;
    }

    @Override
    public void run(){
        String nombre = Thread.currentThread().getName();
        synchronized (msg){
            try {
                System.out.println(nombre+" esperando a la notificación durante: "+System.currentTimeMillis());
                msg.wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(nombre+" ha sido notificado en: "+System.currentTimeMillis());
            //process the message now
            System.out.println(nombre+" procesada: "+msg.getMsg());
        }
    }
}

public class Notificador implements Runnable{

        private Mensaje msg;

        public Notificador(Mensaje msg) {
            this.msg = msg;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name+" iniciado");
            try {
                Thread.sleep(1000);
                synchronized (msg) {
                    msg.setMsg(name+" ha realizado el trabajo");
                    msg.notify();
                    // msg.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

public class Ejercicio9RelojesDesincronizados {
    static class Reloj implements Runnable {
        private String nombre;
        private int sleepMillis;

        public Reloj(String nombre, int sleepMillis) {
            this.nombre = nombre;
            this.sleepMillis = sleepMillis;
        }

        @Override
        public void run() {
            int segundosSimulados = 0;
            
            while (segundosSimulados < 10) {
                segundosSimulados++;
                System.out.println("[" + nombre + "] → " + segundosSimulados);
                try {
                    Thread.sleep(sleepMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread reloj1 = new Thread(new Reloj("Reloj1", 1000));  // 1 segundo
        Thread reloj2 = new Thread(new Reloj("Reloj2", 1500));  // 1.5 segundos
        Thread reloj3 = new Thread(new Reloj("Reloj3", 2000));  // 2 segundos

        reloj1.start();
        reloj2.start();
        reloj3.start();
    }
}

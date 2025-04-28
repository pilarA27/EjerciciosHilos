public class Ejercicio10CarreraDeHilos {
    static volatile boolean carreraTerminada = false;

    static class Corredor implements Runnable {
        private String nombre;
        private int avanceTotal = 0;

        public Corredor(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void run() {
            while (!carreraTerminada && avanceTotal < 100) {
                int paso = (int) (Math.random() * 10) + 1;
                avanceTotal += paso;
                System.out.println("[" + nombre + "] avanza " + paso + " → total: " + avanceTotal);

                if (avanceTotal >= 100) {
                    if (!carreraTerminada) {
                        carreraTerminada = true;
                        System.out.println("¡¡" + nombre + " ha ganado la carrera!!");
                    }
                    break;
                }
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Thread corredor1 = new Thread(new Corredor("Corredor 1"));
        Thread corredor2 = new Thread(new Corredor("Corredor 2"));
        Thread corredor3 = new Thread(new Corredor("Corredor 3"));
        
        corredor1.start();
        corredor2.start();
        corredor3.start();
    }
}

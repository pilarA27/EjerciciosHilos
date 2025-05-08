// Clase principal que simula relojes que "avanzan" en diferentes tiempos
public class Ejercicio9RelojesDesincronizados {

    // Clase interna que representa un reloj, implementa Runnable para correr en un hilo
    static class Reloj implements Runnable {
        private String nombre;        // Nombre identificador del reloj
        private int sleepMillis;      // Tiempo de espera (en milisegundos) entre cada "tic"

        // Constructor del reloj que recibe su nombre y el tiempo entre tics
        public Reloj(String nombre, int sleepMillis) {
            this.nombre = nombre;
            this.sleepMillis = sleepMillis;
        }

        // Método que ejecuta el comportamiento del reloj
        @Override
        public void run() {
            int segundosSimulados = 0; // Contador para simular segundos

            // Se simulan 10 "segundos" para cada reloj
            while (segundosSimulados < 10) {
                segundosSimulados++; // Incrementa el contador

                // Imprime el estado actual del reloj
                System.out.println("[" + nombre + "] → " + segundosSimulados);

                // El hilo se "duerme" por el tiempo especificado, simulando el paso del tiempo
                try {
                    Thread.sleep(sleepMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace(); // Manejo de interrupciones
                }
            }
        }
    }

    // Método principal: se crean e inician los hilos con sus respectivos relojes
    public static void main(String[] args) {
        // Se crean 3 hilos, cada uno ejecuta un reloj con diferente velocidad
        Thread reloj1 = new Thread(new Reloj("Reloj1", 1000));  // "tic" cada 1 segundo
        Thread reloj2 = new Thread(new Reloj("Reloj2", 1500));  // "tic" cada 1.5 segundos
        Thread reloj3 = new Thread(new Reloj("Reloj3", 2000));  // "tic" cada 2 segundos

        // Se inician los hilos, ejecutando sus ciclos de conteo en paralelo
        reloj1.start();
        reloj2.start();
        reloj3.start();
    }
}

// Clase principal que contiene la lógica de la carrera entre hilos
public class Ejercicio10CarreraDeHilos {

    // Variable compartida entre todos los hilos para indicar si alguien ganó la carrera
    static volatile boolean carreraTerminada = false;

    // Clase interna que representa a un corredor, implementando la interfaz Runnable
    static class Corredor implements Runnable {
        private String nombre;        // Nombre del corredor, para distinguir en la salida
        private int avanceTotal = 0;  // Total de avance acumulado por el corredor

        // Constructor que recibe el nombre del corredor
        public Corredor(String nombre) {
            this.nombre = nombre;
        }

        // Método que se ejecuta cuando el hilo comienza (por start())
        @Override
        public void run() {
            // Mientras la carrera no haya terminado y el corredor no haya llegado a 100
            while (!carreraTerminada && avanceTotal < 100) {

                // Se genera un paso aleatorio entre 1 y 10
                int paso = (int) (Math.random() * 10) + 1;

                // Se suma el paso al total de avance del corredor
                avanceTotal += paso;

                // Se imprime el avance actual de este corredor
                System.out.println("[" + nombre + "] avanza " + paso + " → total: " + avanceTotal);

                // Si el corredor alcanza o supera 100 unidades de avance
                if (avanceTotal >= 100) {
                    // Se verifica si todavía no se había declarado un ganador
                    if (!carreraTerminada) {
                        // Se marca que la carrera terminó
                        carreraTerminada = true;

                        // Se anuncia al ganador
                        System.out.println("¡¡" + nombre + " ha ganado la carrera!!");
                    }
                    // Se termina el ciclo (y por tanto el hilo)
                    break;
                }

                // El hilo duerme 1 segundo antes de volver a avanzar
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace(); // Manejo de posibles interrupciones
                }
            }
        }
    }

    // Método principal: punto de entrada del programa
    public static void main(String[] args) {
        // Se crean 3 hilos, cada uno con un corredor diferente
        Thread corredor1 = new Thread(new Corredor("Corredor 1"));
        Thread corredor2 = new Thread(new Corredor("Corredor 2"));
        Thread corredor3 = new Thread(new Corredor("Corredor 3"));

        // Se inician los tres hilos (los tres corredores comienzan a correr "simultáneamente")
        corredor1.start();
        corredor2.start();
        corredor3.start();
    }
}

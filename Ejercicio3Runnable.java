// Clase que implementa la interfaz Runnable para crear tareas ejecutables por hilos
class IncrementoRunnable implements Runnable {
    private int id;                     // Identificador del hilo
    private static int num = 0;        // Variable compartida por todos los hilos (acumulador estático)

    // Constructor que asigna un ID al hilo
    public IncrementoRunnable(int id) {
        this.id = id;
    }

    // Método que se ejecuta cuando el hilo comienza
    public void run() {
        // Bucle que incrementa la variable compartida 'num' 5000 veces
        for (int z = 0; z < 5000; z++) {
            num += 1; // No está sincronizado → pueden producirse errores por condiciones de carrera
        }

        // Muestra el valor actual de 'num' al finalizar este hilo
        System.out.println("El hilo [" + id + "] ha incrementado la variable num a: " + num);
    }

    // Método que crea e inicia 4 hilos usando esta clase como tarea
    public static void crearThreads() {
        for (int i = 1; i <= 4; i++) {
            IncrementoRunnable tarea = new IncrementoRunnable(i); // Crea la tarea
            Thread hilo = new Thread(tarea); // Asocia la tarea a un hilo
            hilo.start(); // Inicia el hilo
        }
    }
}

// Clase principal que ejecuta el programa
public class Ejercicio3Runnable {
    public static void main(String[] args) {
        IncrementoRunnable.crearThreads(); // Inicia la ejecución de los hilos
    }
}

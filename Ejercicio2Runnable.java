// Definimos la clase HolaMundoRunnable que implementa la interfaz Runnable para usarla en hilos
class HolaMundoRunnable implements Runnable {
    private int id; // Atributo para identificar el hilo

    // Constructor que recibe un identificador único para cada hilo
    public HolaMundoRunnable(int id) {
        this.id = id; // Asignamos el id al atributo
    }

    // Método run() que define lo que hace el hilo cuando se ejecuta
    public void run() {
        try {
            // El hilo duerme durante un tiempo determinado, que depende de su id (100 * id milisegundos)
            Thread.sleep(100 * id); // Retraso en milisegundos según el id
        } catch (InterruptedException e) {
            // Si el hilo es interrumpido durante su sueño, se captura la excepción
            System.out.println("Hilo " + id + " fue interrumpido.");
        }
        // Una vez que el hilo despierta, imprime su mensaje
        System.out.println("Hola Mundo desde el Hilo " + id);
    }

    // Método estático para crear y arrancar los hilos
    public static void crearHilos() {
        // Bucle para crear 6 hilos con id del 1 al 6
        for (int i = 1; i <= 6; i++) {
            // Creamos una nueva tarea (HolaMundoRunnable) con el id correspondiente
            HolaMundoRunnable tarea = new HolaMundoRunnable(i);
            // Creamos un nuevo hilo asociado a la tarea
            Thread hilo = new Thread(tarea);
            // Iniciamos el hilo
            hilo.start();
        }
    }
}

// Clase principal donde se ejecuta el programa
public class Ejercicio2Runnable {
    public static void main(String[] args) {
        // Llamamos al método estático crearHilos() para crear e iniciar los hilos
        HolaMundoRunnable.crearHilos();
    }
}

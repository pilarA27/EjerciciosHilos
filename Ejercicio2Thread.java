// Definimos una clase que extiende de Thread para crear hilos personalizados
class HolaMundoThread extends Thread {
    private int id; // Atributo para identificar cada hilo

    // Constructor que recibe un identificador único para cada hilo
    public HolaMundoThread(int id) {
        this.id = id; // Asignamos el id al atributo
    }

    // Método run() que define el comportamiento del hilo cuando se ejecuta
    public void run() {
        // Si el hilo tiene id == 0, es el hilo principal
        if (id == 0) {
            // El hilo principal crea y arranca 6 nuevos hilos con id del 1 al 6
            for (int i = 1; i <= 6; i++) {
                HolaMundoThread hilo = new HolaMundoThread(i); // Creamos un nuevo hilo con id = i
                hilo.start(); // Iniciamos el hilo
            }
        } else {
            // Si el id no es 0, el hilo secundario se ejecuta aquí
            try {
                // Cada hilo duerme por un tiempo basado en su id (100 * id milisegundos)
                Thread.sleep(100 * id); // Retraso en milisegundos según el id
            } catch (InterruptedException e) {
                // Si el hilo es interrumpido durante su sueño, se captura la excepción
                System.out.println("Hilo " + id + " fue interrumpido.");
            }
            // Una vez que el hilo despierta, imprime su mensaje
            System.out.println("Hola Mundo desde el Hilo " + id);
        }
    }
}

// Clase principal donde se ejecuta el programa
public class Ejercicio2Thread {
    public static void main(String[] args) {
        // Se crea y arranca un hilo principal con id 0
        new HolaMundoThread(0).start(); // El hilo principal crea otros hilos en su método run()
    }
}

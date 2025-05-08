// Clase que extiende de Thread para representar un hilo que incrementa una variable compartida
class IncrementoThread extends Thread {
    private static int num = 0; // Variable compartida entre todos los hilos (estática)
    private int id;             // Identificador del hilo (para mostrarlo en pantalla)

    // Constructor que recibe un ID para identificar al hilo
    public IncrementoThread(int id) {
        this.id = id;
    }

    // Método que se ejecuta cuando el hilo se inicia
    @Override
    public void run() {
        // Bucle que incrementa la variable 'num' 5000 veces
        for (int z = 0; z < 5000; z++) {
            num += 1; // No está sincronizado → puede causar condiciones de carrera (race condition)
        }

        // Muestra el valor de 'num' después de que el hilo terminó de incrementar
        System.out.println("El hilo [" + id + "] ha incrementado la variable num a: " + num);
    }
}

public class Ejercicio3Thread {
    public static void main(String[] args) {
        // Crea e inicia 4 hilos que ejecutarán la tarea de incrementar la variable 'num'
        for (int i = 1; i <= 4; i++) {
            IncrementoThread hilo = new IncrementoThread(i);
            hilo.start();
        }
    }
}

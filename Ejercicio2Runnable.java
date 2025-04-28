class HolaMundoRunnable implements Runnable {
    private int id;

    public HolaMundoRunnable(int id) {
        this.id = id;
    }

    public void run() {
        try {
            Thread.sleep(100 * id);
        } catch (InterruptedException e) {
            System.out.println("Hilo " + id + " fue interrumpido.");
        }
        System.out.println("Hola Mundo desde el Hilo " + id);
    }

    public static void crearHilos() {
        for (int i = 1; i <= 6; i++) {
            HolaMundoRunnable tarea = new HolaMundoRunnable(i);
            Thread hilo = new Thread(tarea);
            hilo.start();
        }
    }
}

public class Ejercicio2Runnable {
    public static void main(String[] args) {
        HolaMundoRunnable.crearHilos();
    }
}

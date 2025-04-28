class IncrementoRunnable implements Runnable {
    private int id;
    private static int num = 0;

    public IncrementoRunnable(int id) {
        this.id = id;
    }

    public void run() {
        for (int z = 0; z < 5000; z++) {
            num += 1;
        }
        System.out.println("El hilo [" + id + "] ha incrementado la variable num a: " + num);
    }

    public static void crearThreads() {
        for (int i = 1; i <= 4; i++) {
            IncrementoRunnable tarea = new IncrementoRunnable(i);
            Thread hilo = new Thread(tarea);
            hilo.start();
        }
    }
}

public class Ejercicio3Runnable {
    public static void main(String[] args) {
        IncrementoRunnable.crearThreads();
    }
}

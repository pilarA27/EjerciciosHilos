class HolaMundoThread extends Thread {
    private int id;

    public HolaMundoThread(int id) {
        this.id = id;
    }

    public void run() {
        if (id == 0) {
            for (int i = 1; i <= 6; i++) {
                HolaMundoThread hilo = new HolaMundoThread(i);
                hilo.start();
            }
        } else {
            try {
                Thread.sleep(100 * id);
            } catch (InterruptedException e) {
                System.out.println("Hilo " + id + " fue interrumpido.");
            }
            System.out.println("Hola Mundo desde el Hilo " + id);
        }
    }
}

public class Ejercicio2Thread {
    public static void main(String[] args) {
        new HolaMundoThread(0).start();
    }
}

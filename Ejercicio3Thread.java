class IncrementoThread extends Thread {
    private static int num = 0;
    private int id;

    public IncrementoThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int z = 0; z < 5000; z++) {
            num += 1;
        }
        System.out.println("El hilo [" + id + "] ha incrementado la variable num a: " + num);
    }
}

public class Ejercicio3Thread {
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            IncrementoThread hilo = new IncrementoThread(i);
            hilo.start();
        }
    }
}

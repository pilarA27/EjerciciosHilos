class ImprimeCeroYUno implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("0");
            System.out.println("1");
        }
    }
}

public class Ejercicio1Runnable {
    public static void main(String[] args) {
        ImprimeCeroYUno tarea = new ImprimeCeroYUno();
        Thread hilo = new Thread(tarea);

        hilo.start();
    }
}

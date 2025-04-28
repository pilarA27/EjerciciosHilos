class ImprimeCeroYUno extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("0");
            System.out.println("1");
        }
        
    }
}

public class Ejercicio1Thread {
    public static void main(String[] args) {
        ImprimeCeroYUno hiloCero = new ImprimeCeroYUno();
        hiloCero.start();
    }
}

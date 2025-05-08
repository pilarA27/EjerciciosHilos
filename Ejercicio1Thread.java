// Definimos la clase ImprimeCeroYUno que extiende de Thread para crear un hilo
class ImprimeCeroYUno extends Thread {
    
    // El método run() es donde definimos el comportamiento del hilo cuando se ejecuta
    public void run() {
        // Bucle que imprime 0 y 1 1000 veces
        for (int i = 0; i < 1000; i++) {
            System.out.println("0"); // Imprime el número 0
            System.out.println("1"); // Imprime el número 1
        }
    }
}

// Clase principal donde se ejecuta el programa
public class Ejercicio1Thread {
    public static void main(String[] args) {
        // Creamos una instancia de la clase ImprimeCeroYUno (un hilo)
        ImprimeCeroYUno hiloCero = new ImprimeCeroYUno();
        // Iniciamos el hilo, lo que invoca el método run() en un hilo separado
        hiloCero.start();
    }
}

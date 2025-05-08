// Definimos la clase ImprimeCeroYUno que implementa la interfaz Runnable para crear hilos
class ImprimeCeroYUno implements Runnable {
    
    // El método run() define lo que el hilo hará cuando se ejecute
    @Override
    public void run() {
        // Bucle que imprime 0 y 1 1000 veces
        for (int i = 0; i < 1000; i++) {
            System.out.println("0"); // Imprime el número 0
            System.out.println("1"); // Imprime el número 1
        }
    }
}

// Clase principal donde se ejecuta el programa
public class Ejercicio1Runnable {
    public static void main(String[] args) {
        // Creamos una instancia de la clase ImprimeCeroYUno (que implementa Runnable)
        ImprimeCeroYUno tarea = new ImprimeCeroYUno();
        
        // Creamos un nuevo hilo que recibe la tarea como argumento (el objeto ImprimeCeroYUno)
        Thread hilo = new Thread(tarea);
        
        // Iniciamos el hilo, lo que invoca el método run() en un hilo separado
        hilo.start();
    }
}

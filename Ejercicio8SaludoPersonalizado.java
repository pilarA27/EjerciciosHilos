// Clase principal que lanza varios hilos que saludan con un mensaje personalizado
public class Ejercicio8SaludoPersonalizado {

    // Clase interna que representa un hilo que imprime un saludo
    static class SaludoHilo implements Runnable {
        private String nombre; // Nombre común para todos los saludos
        private int numero;    // Número identificador del hilo

        // Constructor que recibe el nombre y el número del hilo
        public SaludoHilo(String nombre, int numero) {
            this.nombre = nombre;
            this.numero = numero;
        }

        // Método que ejecuta la acción del hilo
        @Override
        public void run() {
            // Muestra un mensaje con el nombre y número del hilo
            System.out.println("¡Hola " + nombre + ", soy el hilo " + numero + "!");
        }
    }

    // Método principal que crea y lanza varios hilos
    public static void main(String[] args) {
        String nombreComun = "Jupiter";   // Nombre común usado por todos los hilos
        int cantidadHilos = 5;            // Número total de hilos a crear

        // Se crea un bucle que lanza la cantidad de hilos especificada
        for (int i = 1; i <= cantidadHilos; i++) {
            // Para cada iteración se crea un nuevo hilo con el nombre común y el número correspondiente
            Thread hilo = new Thread(new SaludoHilo(nombreComun, i));
            hilo.start(); // Se inicia el hilo
        }
    }
}

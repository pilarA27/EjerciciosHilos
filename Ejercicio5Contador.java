public class Ejercicio5Contador {

    // Clase interna que representa un contador ejecutado por un hilo
    static class Contador extends Thread {
        private int contador;  // Valor actual del contador
        private String nombre; // Nombre del hilo (para identificarlo en la salida)
        private int limite;    // Límite hasta donde contará

        // Constructor que inicializa el nombre del hilo y su límite
        public Contador(String nombre, int limite) {
            this.nombre = nombre;
            this.limite = limite;
            this.contador = 0; // Comienza desde cero
        }

        // Método que se ejecuta cuando se inicia el hilo
        public void run() {
            // Mientras el contador no supere el límite...
            while (contador <= limite) {
                // Imprime el nombre del hilo y el valor actual
                System.out.println(nombre + ": " + contador);
                contador++; // Incrementa el contador

                // Pausa de 100 milisegundos entre cada número
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace(); // Si ocurre una interrupción, muestra el error
                }
            }
        }
    }

    // Método principal que lanza tres hilos con distintos límites
    public static void main(String[] args) {
        // Crea tres objetos Contador con distintos nombres y límites
        Contador contador1 = new Contador("Hilo A", 5);
        Contador contador2 = new Contador("Hilo B", 8);
        Contador contador3 = new Contador("Hilo C", 3);

        // Inicia los tres hilos simultáneamente
        contador1.start();
        contador2.start();
        contador3.start();
    }
}

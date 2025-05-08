public class Ejercicio7CuentaRegresiva {

    // Clase interna que representa un hilo que hace una cuenta regresiva
    static class CuentaRegresiva extends Thread {
        private int contador;  // Valor actual de la cuenta regresiva
        private String nombre; // Nombre del hilo
        private int limite;    // Límite inferior hasta donde cuenta

        // Constructor que recibe el nombre del hilo y un límite (pero no lo usa correctamente)
        public CuentaRegresiva(String nombre, int limite) {
            this.nombre = nombre;
            this.limite = 0;       // ERROR: se ignora el valor de 'limite' recibido
            this.contador = 5;     // Se inicia siempre desde 5
        }

        // Método que ejecuta la cuenta regresiva
        public void run() {
            while (contador >= limite) {
                System.out.println(nombre + ": " + contador);
                contador--;

                try {
                    Thread.sleep(100); // Espera 100 milisegundos entre números
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Método principal
    public static void main(String[] args) {
        // Se crean tres instancias con distintos límites, pero esos valores no se usan realmente
        CuentaRegresiva contador1 = new CuentaRegresiva("Hilo A", 5);
        CuentaRegresiva contador2 = new CuentaRegresiva("Hilo B", 8);
        CuentaRegresiva contador3 = new CuentaRegresiva("Hilo C", 3);

        // Se inician los tres hilos
        contador1.start();
        contador2.start();
        contador3.start();
    }
}

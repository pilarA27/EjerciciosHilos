public class Ejercicio4Runnable {

    // Clase interna que implementa la interfaz Runnable
    static class HilosNumerosLetras implements Runnable {
        private int tipo;  // Determina si el hilo imprimirá números o letras

        // Constructor que recibe el tipo de tarea que hará el hilo
        public HilosNumerosLetras(int tipo) {
            this.tipo = tipo;
        }

        // Método que se ejecuta cuando se inicia el hilo
        @Override
        public void run() {
            // Si el tipo es 1, imprime números del 0 al 30
            if (tipo == 1) {
                for (int z = 0; z <= 30; z++) {
                    System.out.println(z);
                }
            // Si el tipo es 2, imprime letras de la 'a' a la 'z'
            } else if (tipo == 2) {
                for (char i = 'a'; i <= 'z'; i++) {
                    System.out.println(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Se crean dos instancias de la clase: una para números, otra para letras
        HilosNumerosLetras numeros = new HilosNumerosLetras(1);
        HilosNumerosLetras letras = new HilosNumerosLetras(2);

        // Se crean hilos con esas instancias
        Thread hiloNumeros = new Thread(numeros);
        Thread hiloLetras = new Thread(letras);

        // Se inician los hilos, ejecutándose concurrentemente
        hiloNumeros.start();
        hiloLetras.start();
    }
}

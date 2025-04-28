public class Ejercicio5Contador {

    static class Contador extends Thread {
        private int contador;
        private String nombre;
        private int limite;

        public Contador(String nombre, int limite) {
            this.nombre = nombre;
            this.limite = limite;
            this.contador = 0;
        }

        public void run() {
            while (contador <= limite) {
                System.out.println(nombre + ": " + contador);
                contador++;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Contador contador1 = new Contador("Hilo A", 5);
        Contador contador2 = new Contador("Hilo B", 8);
        Contador contador3 = new Contador("Hilo C", 3);

        contador1.start();
        contador2.start();
        contador3.start();
    }
}



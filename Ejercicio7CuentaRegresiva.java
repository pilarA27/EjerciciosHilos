public class Ejercicio7CuentaRegresiva {
    static class CuentaRegresiva extends Thread {
        private int contador;
        private String nombre;
        private int limite;

        public CuentaRegresiva(String nombre, int limite) {
            this.nombre = nombre;
            this.limite = 0;
            this.contador = 5;
        }

        public void run() {
            while (contador >= limite) {
                System.out.println(nombre + ": " + contador);
                contador--;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        CuentaRegresiva contador1 = new CuentaRegresiva("Hilo A", 5);
        CuentaRegresiva contador2 = new CuentaRegresiva("Hilo B", 8);
        CuentaRegresiva contador3 = new CuentaRegresiva("Hilo C", 3);

        contador1.start();
        contador2.start();
        contador3.start();
    }
}

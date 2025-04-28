public class Ejercicio8SaludoPersonalizado {

    static class SaludoHilo implements Runnable {
        private String nombre;
        private int numero;

        public SaludoHilo(String nombre, int numero) {
            this.nombre = nombre;
            this.numero = numero;
        }

        @Override
        public void run() {
            System.out.println("¡Hola " + nombre + ", soy el hilo " + numero + "!");
        }
    }

    public static void main(String[] args) {
        String nombreComun = "Jupiter";
        int cantidadHilos = 5;

        for (int i = 1; i <= cantidadHilos; i++) {
            Thread hilo = new Thread(new SaludoHilo(nombreComun, i));
            hilo.start();
        }
    }
}
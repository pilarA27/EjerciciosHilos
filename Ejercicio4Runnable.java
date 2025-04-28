public class Ejercicio4Runnable {
    static class HilosNumerosLetras implements Runnable {
        private int tipo;

        public HilosNumerosLetras(int tipo) {
            this.tipo = tipo;
        }

        @Override
        public void run() {
            if (tipo == 1) {
                for (int z = 0; z <= 30; z++) {
                    System.out.println(z);
                }
            } else if (tipo == 2) {
                for (char i = 'a'; i <= 'z'; i++) {
                    System.out.println(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        HilosNumerosLetras numeros = new HilosNumerosLetras(1);
        HilosNumerosLetras letras = new HilosNumerosLetras(2);

        Thread hiloNumeros = new Thread(numeros);
        Thread hiloLetras = new Thread(letras);

        hiloNumeros.start();
        hiloLetras.start();
    }
}


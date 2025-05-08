public class Ejercicio6CuentaBancaria {

    // Clase que representa una cuenta bancaria
    static class CuentaBancaria {
        private int saldo;  // Saldo de la cuenta

        // Constructor que inicializa el saldo
        public CuentaBancaria(int saldoInicial) {
            this.saldo = saldoInicial;
        }

        // Método para consultar el saldo
        public void consultarSaldo(String cliente) {
            System.out.println(cliente + " consulta: Saldo = $" + saldo);
        }

        // Método para depositar dinero en la cuenta
        public void depositar(String cliente, int monto) {
            saldo += monto;
            System.out.println(cliente + " depositó $" + monto + " → Saldo = $" + saldo);
        }

        // Método para retirar dinero de la cuenta
        public void retirar(String cliente, int monto) {
            saldo -= monto;
            System.out.println(cliente + " retiró $" + monto + " → Saldo = $" + saldo);
        }
    }

    // Clase que representa un cliente que accede a la cuenta
    static class Cliente implements Runnable {
        private String nombre;           // Nombre del cliente
        private CuentaBancaria cuenta;   // Cuenta que el cliente usa

        // Constructor que recibe el nombre y la cuenta compartida
        public Cliente(String nombre, CuentaBancaria cuenta) {
            this.nombre = nombre;
            this.cuenta = cuenta;
        }

        // Método que se ejecuta cuando comienza el hilo
        @Override
        public void run() {
            // Sincroniza el acceso a la cuenta para evitar interferencias entre hilos
            synchronized(cuenta) {
                if (nombre.equals("Cliente 1")) {
                    // Cliente 1 consulta, deposita y luego retira
                    cuenta.consultarSaldo(nombre);
                    dormir(100);
                    cuenta.depositar(nombre, 50);
                    dormir(100);
                    cuenta.retirar(nombre, 30);
                } else if (nombre.equals("Cliente 2")) {
                    // Cliente 2 consulta, retira y luego deposita
                    cuenta.consultarSaldo(nombre);
                    dormir(150);
                    cuenta.retirar(nombre, 70);
                    dormir(100);
                    cuenta.depositar(nombre, 40);
                }
            }
        }

        // Método auxiliar para pausar el hilo (simula espera entre operaciones)
        private void dormir(int ms) {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Método principal: crea la cuenta y lanza dos hilos con clientes
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(100); // saldo inicial = 100

        // Se crean dos hilos con clientes que comparten la misma cuenta
        Thread hilo1 = new Thread(new Cliente("Cliente 1", cuenta));
        Thread hilo2 = new Thread(new Cliente("Cliente 2", cuenta));

        // Se inician los hilos (ambos acceden a la cuenta de forma segura)
        hilo1.start();
        hilo2.start();
    }
}

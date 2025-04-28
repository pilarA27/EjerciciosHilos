public class Ejercicio6CuentaBancaria {
    
    static class CuentaBancaria {
        private int saldo;
        
        public CuentaBancaria(int saldoInicial) {
            this.saldo = saldoInicial;
        }
        
        public void consultarSaldo(String cliente) {
            System.out.println(cliente + " consulta: Saldo = $" + saldo);
        }
        
        public void depositar(String cliente, int monto) {
            saldo += monto;
            System.out.println(cliente + " depositó $" + monto + " → Saldo = $" + saldo);
        }
        
        public void retirar(String cliente, int monto) {
            saldo -= monto;
            System.out.println(cliente + " retiró $" + monto + " → Saldo = $" + saldo);
        }
    }
    
    static class Cliente implements Runnable {
        private String nombre;
        private CuentaBancaria cuenta;
        
        public Cliente(String nombre, CuentaBancaria cuenta) {
            this.nombre = nombre;
            this.cuenta = cuenta;
        }
        
        @Override
        public void run() {
            synchronized(cuenta) {
                if (nombre.equals("Cliente 1")) {
                    cuenta.consultarSaldo(nombre);
                    dormir(100);
                    cuenta.depositar(nombre, 50);
                    dormir(100);
                    cuenta.retirar(nombre, 30);
                } else if (nombre.equals("Cliente 2")) {
                    cuenta.consultarSaldo(nombre);
                    dormir(150);
                    cuenta.retirar(nombre, 70);
                    dormir(100);
                    cuenta.depositar(nombre, 40);
                }
            }
        }
        
        private void dormir(int ms) {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        
        Thread hilo1 = new Thread(new Cliente("Cliente 1", cuenta));
        Thread hilo2 = new Thread(new Cliente("Cliente 2", cuenta));
        
        hilo1.start();
        hilo2.start();
    }
}
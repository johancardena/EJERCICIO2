public class CuentaCorriente extends CuentaBancaria {
    private static final double COMISION = 0.02;

    public CuentaCorriente(String numeroCuenta, Cliente cliente) {
        super(1000, numeroCuenta, cliente); // Saldo inicial de $1000
    }

    @Override
    public void retirar(double monto) {
        double montoConComision = monto * (1 + COMISION);
        if (montoConComision <= getSaldo()) {
            actualizarSaldo(getSaldo() - montoConComision);
            System.out.println("Retiro exitoso. Se aplicó una comisión del 2%.");
            System.out.println("Saldo actual: $" + getSaldo());
        } else {
            System.out.println("Fondos insuficientes para realizar el retiro con la comisión.");
        }
    }
}
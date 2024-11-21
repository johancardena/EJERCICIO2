public class CuentaAhorro extends CuentaBancaria {
    private static final double SALDO_MINIMO = 100;

    public CuentaAhorro(String numeroCuenta, Cliente cliente) {
        super(500, numeroCuenta, cliente);
    }

    @Override
    public void retirar(double monto) {
        if (getSaldo() - monto >= SALDO_MINIMO) {
            actualizarSaldo(getSaldo() - monto);
            System.out.println("Retiro exitoso. Saldo actual: $" + getSaldo());
        } else {
            System.out.println("No se puede realizar el retiro. El saldo no puede ser menor a $" + SALDO_MINIMO);
        }
    }
}
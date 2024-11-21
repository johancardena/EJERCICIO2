abstract class CuentaBancaria {
    private double saldo;
    private String numeroCuenta;
    private Cliente cliente;

    public CuentaBancaria(double saldo, String numeroCuenta, Cliente cliente) {
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso. Saldo actual: $" + saldo);
        } else {
            System.out.println("El monto a depositar debe ser mayor a cero.");
        }
    }

    public abstract void retirar(double monto);

    public void mostrarInformacion() {
        cliente.mostrarInformacion();
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Saldo actual: $" + saldo);
    }

    protected void actualizarSaldo(double nuevoSaldo) {
        saldo = nuevoSaldo;
    }
}


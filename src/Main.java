import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear clientes y cuentas
        Cliente cliente1 = new Cliente("Juan Pérez", "12345678");
        Cliente cliente2 = new Cliente("María Gómez", "87654321");

        CuentaCorriente cuentaCorriente = new CuentaCorriente("CC001", cliente1);
        CuentaAhorro cuentaAhorro = new CuentaAhorro("CA001", cliente2);

        // Menú interactivo
        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Ver información del cliente y saldo");
            System.out.println("2. Transferir entre cuentas");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Depositar dinero");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Cuenta Corriente ---");
                    cuentaCorriente.mostrarInformacion();
                    System.out.println("\n--- Cuenta Ahorro ---");
                    cuentaAhorro.mostrarInformacion();
                    break;
                case 2:
                    System.out.print("Ingrese el monto a transferir de Cuenta Corriente a Cuenta Ahorro: ");
                    double montoTransferir = scanner.nextDouble();
                    if (cuentaCorriente.getSaldo() >= montoTransferir) {
                        cuentaCorriente.retirar(montoTransferir);
                        cuentaAhorro.depositar(montoTransferir);
                        System.out.println("Transferencia realizada con éxito.");
                    } else {
                        System.out.println("Fondos insuficientes en la Cuenta Corriente.");
                    }
                    break;
                case 3:
                    System.out.print("¿De qué cuenta desea retirar? (1: Corriente, 2: Ahorro): ");
                    int tipoCuenta = scanner.nextInt();
                    System.out.print("Ingrese el monto a retirar: ");
                    double montoRetirar = scanner.nextDouble();
                    if (tipoCuenta == 1) {
                        cuentaCorriente.retirar(montoRetirar);
                    } else if (tipoCuenta == 2) {
                        cuentaAhorro.retirar(montoRetirar);
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;
                case 4:
                    System.out.print("¿En qué cuenta desea depositar? (1: Corriente, 2: Ahorro): ");
                    tipoCuenta = scanner.nextInt();
                    System.out.print("Ingrese el monto a depositar: ");
                    double montoDepositar = scanner.nextDouble();
                    if (tipoCuenta == 1) {
                        cuentaCorriente.depositar(montoDepositar);
                    } else if (tipoCuenta == 2) {
                        cuentaAhorro.depositar(montoDepositar);
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}

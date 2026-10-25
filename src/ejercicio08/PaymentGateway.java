package ejercicio08;

/**
 * Pasarela de pago real.
 * Mantiene una única instancia e implementa una interfaz
 * para permitir la inyección de dependencias.
 */
public class PaymentGateway implements PaymentService {

    // Referencia a la única instancia de la pasarela
    private static PaymentGateway instance;

    // Constructor privado para impedir otras instancias
    private PaymentGateway() {
        System.out.println("Pasarela de pago creada (una sola vez).");
    }

    // Crea la pasarela la primera vez que se solicita y devuelve siempre la misma instancia
    public static synchronized PaymentGateway getInstance() {
        if (instance == null) {
            instance = new PaymentGateway();
        }

        return instance;
    }

    // Simula el cobro a un cliente. Devuelve false si los datos no son válidos
    @Override
    public boolean charge(String customer, double amount) {
        if (!isValid(customer, amount)) {
            System.out.println("  [PASARELA] Error: los datos del cobro no son válidos.");
            return false;
        }

        System.out.printf(
                "  [PASARELA] Se cobraron $%.2f a %s.%n",
                amount,
                customer
        );

        return true;
    }

    // Simula el reembolso a un cliente. Devuelve false si los datos no son válidos
    @Override
    public boolean refund(String customer, double amount) {
        if (!isValid(customer, amount)) {
            System.out.println("  [PASARELA] Error: los datos del reembolso no son válidos.");
            return false;
        }

        System.out.printf(
                "  [PASARELA] Se reembolsaron $%.2f a %s.%n",
                amount,
                customer
        );

        return true;
    }

    // Comprueba que el cliente exista y que el monto sea finito y mayor que cero
    private boolean isValid(String customer, double amount) {
        return customer != null
                && !customer.isBlank()
                && Double.isFinite(amount)
                && amount > 0;
    }
}
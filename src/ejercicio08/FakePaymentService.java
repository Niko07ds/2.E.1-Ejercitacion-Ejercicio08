package ejercicio08;

/**
 * Doble de prueba que permite probar los consumidores
 * sin utilizar la pasarela de pago real.
 */
public class FakePaymentService implements PaymentService {

    private int calls = 0;

    @Override
    public boolean charge(String customer, double amount) {
        calls++;

        if (!isValid(customer, amount)) {
            System.out.println("  [FALSO] Error: datos del cobro no válidos.");
            return false;
        }

        System.out.printf(
                "  [FALSO] Simulando cobro de $%.2f a %s.%n",
                amount,
                customer
        );

        return true;
    }

    @Override
    public boolean refund(String customer, double amount) {
        calls++;

        if (!isValid(customer, amount)) {
            System.out.println("  [FALSO] Error: datos del reembolso no válidos.");
            return false;
        }

        System.out.printf(
                "  [FALSO] Simulando reembolso de $%.2f a %s.%n",
                amount,
                customer
        );

        return true;
    }

    public int getCalls() {
        return calls;
    }

    private boolean isValid(String customer, double amount) {
        return customer != null
                && !customer.isBlank()
                && Double.isFinite(amount)
                && amount > 0;
    }
}
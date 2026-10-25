package ejercicio08;

/**
 * Consumidor que recibe la dependencia a través del constructor.
 */
public class RefundService {

    private final PaymentService paymentService;

    public RefundService(PaymentService paymentService) {
        if (paymentService == null) {
            throw new IllegalArgumentException(
                    "El servicio de pago no puede ser nulo."
            );
        }

        this.paymentService = paymentService;
    }

    public void returnOrder(String customer, double amount) {
        boolean refunded = paymentService.refund(customer, amount);

        System.out.println(
                "  Reembolso " + (refunded ? "completado" : "fallido")
                        + " para " + customer
        );
    }
}
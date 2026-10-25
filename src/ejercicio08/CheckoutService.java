package ejercicio08;

/**
 * Consumidor que recibe la dependencia por constructor.
 * No realiza llamadas estáticas al Singleton.
 */
public class CheckoutService {

    private final PaymentService paymentService;

    public CheckoutService(PaymentService paymentService) {
        if (paymentService == null) {
            throw new IllegalArgumentException(
                    "El servicio de pago no puede ser nulo."
            );
        }

        this.paymentService = paymentService;
    }

    public void checkout(String customer, double total) {
        boolean paid = paymentService.charge(customer, total);

        System.out.println(
                "  Compra " + (paid ? "completada" : "fallida")
                        + " para " + customer
        );
    }
}
package ejercicio08;

public class Main {

    public static void main(String[] args) {

        // Raíz de composición: obtiene la instancia única de la pasarela
        PaymentService gateway = PaymentGateway.getInstance();

        System.out.println(
                "--- Producción: los consumidores comparten la única pasarela ---"
        );

        CheckoutService checkout = new CheckoutService(gateway);
        RefundService refunds = new RefundService(gateway);

        // Comprobamos que ambos consumidores reciban la misma referencia
        System.out.println(
                "¿Ambos servicios comparten la pasarela? "
                        + (gateway == PaymentGateway.getInstance())
        );

        checkout.checkout("Laura", 150.50);
        refunds.returnOrder("Laura", 50.00);

        System.out.println(
                "\n--- Pruebas: los consumidores utilizan un servicio falso ---"
        );

        // Inyectamos el doble de prueba sin modificar los consumidores
        FakePaymentService fake = new FakePaymentService();

        CheckoutService testCheckout = new CheckoutService(fake);
        RefundService testRefunds = new RefundService(fake);

        testCheckout.checkout("Usuario de prueba", 10.00);
        testRefunds.returnOrder("Usuario de prueba", 5.00);

        System.out.println(
                "Cantidad de llamadas al servicio falso: " + fake.getCalls()
        );
    }
}
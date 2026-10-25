package ejercicio08;

/**
 * Abstracción de la que dependen los consumidores (no el Singleton concreto).
 * Define las operaciones disponibles para los servicios de pago.
 */
public interface PaymentService {

    boolean charge(String customer, double amount);

    boolean refund(String customer, double amount);
}

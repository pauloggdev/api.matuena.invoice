package api.ecommerce.infrastructure.payment;
import org.springframework.stereotype.Component;
import api.ecommerce.domain.entity.Checkout;
import api.ecommerce.domain.strategy.PaymentStrategy;

@Component
public class PaypalPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(Checkout checkout) {
        System.out.println("Pagamento por PayPal");
        checkout.setStatus("PAID_PAYPAL");
    }

}

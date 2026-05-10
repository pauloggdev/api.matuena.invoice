package api.ecommerce.infrastructure.payment;

import org.springframework.stereotype.Component;

import api.ecommerce.domain.entity.Checkout;
import api.ecommerce.domain.strategy.PaymentStrategy;

@Component
public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(Checkout checkout) {
        System.out.println("Pagamento por cartão");
        checkout.setStatus("PAID_CARD");
    }

}

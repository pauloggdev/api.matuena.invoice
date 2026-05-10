package api.ecommerce.domain.factory;

import org.springframework.stereotype.Component;

import api.ecommerce.domain.strategy.DiscountStrategy;
import api.ecommerce.domain.strategy.PaymentStrategy;
import api.ecommerce.infrastructure.discount.NoDiscountStrategy;
import api.ecommerce.infrastructure.discount.VipDiscountStrategy;
import api.ecommerce.infrastructure.payment.CardPaymentStrategy;
import api.ecommerce.infrastructure.payment.PaypalPaymentStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CheckoutStrategyFactory {
    private final Map<String, PaymentStrategy> payments = new HashMap<>();
    private final Map<String, DiscountStrategy> discounts = new HashMap<>();

    public CheckoutStrategyFactory(List<PaymentStrategy> p, List<DiscountStrategy> d) {

        for (PaymentStrategy ps : p) {
            if (ps instanceof CardPaymentStrategy)
                payments.put("CARD", ps);

            if (ps instanceof PaypalPaymentStrategy)
                payments.put("PAYPAL", ps);
        }

        for (DiscountStrategy ds : d) {
            if (ds instanceof VipDiscountStrategy)
                discounts.put("VIP", ds);

            if (ds instanceof NoDiscountStrategy)
                discounts.put("NONE", ds);
        }
    }

    public PaymentStrategy getPayment(String type) {
        return payments.get(type);
    }

    public DiscountStrategy getDiscount(String type) {
        return discounts.get(type);
    }

}

package api.ecommerce.infrastructure.discount;
import org.springframework.stereotype.Component;

import api.ecommerce.domain.entity.Checkout;
import api.ecommerce.domain.strategy.DiscountStrategy;

@Component
public class NoDiscountStrategy implements DiscountStrategy {

    @Override
    public Double apply(Checkout checkout) {
        return checkout.getTotal();
    }
    
}

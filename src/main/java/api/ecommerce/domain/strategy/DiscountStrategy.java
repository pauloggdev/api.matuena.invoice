package api.ecommerce.domain.strategy;

import api.ecommerce.domain.entity.Checkout;

public interface DiscountStrategy {

    public Double apply(Checkout checkout);
    
}

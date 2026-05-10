package api.ecommerce.domain.strategy;
import api.ecommerce.domain.entity.Checkout;

public interface PaymentStrategy {
    public void pay(Checkout checkout);
    
}

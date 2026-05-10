package api.ecommerce.domain.entity;



import api.ecommerce.domain.strategy.DiscountStrategy;
import api.ecommerce.domain.strategy.PaymentStrategy;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class Checkout {

    @Id
    private String id;
    private String customerId;
    private Double total;
    private String paymentMethod; // CARD, PAYPAL
    private String discountType; // VIP, NONE
    private String status;
    @Transient
    private PaymentStrategy paymentStrategy;
    @Transient
    private DiscountStrategy discountStrategy;

    public void pay() {
        paymentStrategy.pay(this);
    }

    public void applyDiscount() {
        discountStrategy.apply(this);
    }
}

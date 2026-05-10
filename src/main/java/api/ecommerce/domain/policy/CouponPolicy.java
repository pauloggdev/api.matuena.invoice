package api.ecommerce.domain.policy;

import org.springframework.stereotype.Component;

@Component
public class CouponPolicy {
    public void apply(String couponCode) {

        if (couponCode != null && couponCode.equals("EXPIRED")) {
            throw new RuntimeException("Coupon expired");
        }
    }
}

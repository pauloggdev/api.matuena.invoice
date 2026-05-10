package api.ecommerce.domain.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import api.ecommerce.domain.entity.Checkout;
import api.ecommerce.dto.CheckoutRequest;

@Component
public class CheckoutMapper {

    public Checkout toEntity(CheckoutRequest req) {
        Checkout checkout = new Checkout();
        checkout.setId(UUID.randomUUID().toString());
        checkout.setCustomerId(req.getCustomerId());
        checkout.setTotal(req.getTotal());
        checkout.setPaymentMethod(req.getPaymentMethod());
        checkout.setDiscountType(req.getDiscountType());
        return checkout;
    }

}

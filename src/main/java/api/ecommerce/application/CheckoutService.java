package api.ecommerce.application;

import org.springframework.stereotype.Service;

import api.ecommerce.domain.entity.Checkout;
import api.ecommerce.domain.factory.CheckoutStrategyFactory;
import api.ecommerce.domain.mapper.CheckoutMapper;
import api.ecommerce.domain.policy.CouponPolicy;
import api.ecommerce.domain.repository.CheckoutRepository;
import api.ecommerce.domain.strategy.DiscountStrategy;
import api.ecommerce.domain.strategy.PaymentStrategy;
import api.ecommerce.domain.validation.CheckoutValidator;
import api.ecommerce.dto.CheckoutRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckoutService {

    private final CheckoutRepository repository;
    private final CheckoutMapper mapper;
    private final CheckoutValidator validator;
    private final CheckoutStrategyFactory factory;
    private final CouponPolicy couponPolicy;

    public Checkout process(CheckoutRequest req) {

        // 1. VALIDATION
        validator.validate(req);

        // 2. MAPPER
        Checkout checkout = mapper.toEntity(req);

        // 3. POLICY (coupon)
        couponPolicy.apply("VALID");

        // 4. STRATEGY - discount
        DiscountStrategy discount = factory.getDiscount(checkout.getDiscountType());
        checkout.setDiscountStrategy(discount);
        checkout.setTotal(discount.apply(checkout));

        // 5. STRATEGY - payment
        PaymentStrategy payment = factory.getPayment(checkout.getPaymentMethod());
        checkout.setPaymentStrategy(payment);

        payment.pay(checkout);
        return repository.save(checkout);

    }
}
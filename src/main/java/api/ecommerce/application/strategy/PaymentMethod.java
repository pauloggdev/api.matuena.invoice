package api.ecommerce.application.strategy;

import api.ecommerce.domain.entity.Invoice;

public interface PaymentMethod {
    public void pay(Invoice invoice);
}

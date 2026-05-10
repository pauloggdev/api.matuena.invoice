package api.ecommerce.domain.validation;
import org.springframework.stereotype.Component;
import api.ecommerce.dto.CheckoutRequest;

@Component
public class CheckoutValidator {
    public void validate(CheckoutRequest req) {

        if (req.getQty() <= 0) {
            throw new RuntimeException("Qty inválida");
        }

        if (req.getTotal() == null || req.getTotal() <= 0) {
            throw new RuntimeException("Total inválido");
        }
    }
}

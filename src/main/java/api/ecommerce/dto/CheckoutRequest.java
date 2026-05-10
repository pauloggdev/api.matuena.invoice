package api.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CheckoutRequest {

    @NotBlank
    private String customerId;

    @NotNull
    private Double total;

    @NotNull
    private String paymentMethod;

    @NotNull
    private String discountType;

    @NotNull
    private String productId;

    @NotNull
    private Integer qty;

}

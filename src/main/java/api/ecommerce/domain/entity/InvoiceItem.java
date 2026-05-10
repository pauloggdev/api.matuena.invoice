package api.ecommerce.domain.entity;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer productId;
    private String productCode;
    private String productDescription;
    private Double quantity;
    private Character unitOfMeasure;
    private BigDecimal unitPrice;
    private BigDecimal unitPriceBase;
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;
    @OneToMany(mappedBy = "invoiceItem")
    private List<Tax> taxes;

    @ManyToOne
    private Invoice invoice;

}

package api.ecommerce.domain.entity;

import java.math.BigDecimal;

import api.ecommerce.domain.enums.TaxType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TaxType taxType; // IVA, IS, IEC, CEOC, NS
    private String countryRegion; // AO
    private String taxCode; // NOR, EXE, etc
    private BigDecimal percentage;
    private BigDecimal amount;
    @ManyToOne
    private InvoiceItem invoiceItem;

}

package api.ecommerce.domain.entity;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import api.ecommerce.domain.enums.DocumentType;
import api.ecommerce.shared.signature.Signable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Invoice implements Signable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String taxRegistrationNumber;
    private String requestID;
    private String documentNo;
    private Character documentStatus;
    private Character rejectedDocumentNo;
    private String jwsDocumentSignature;
    private String documentDate;
    private DocumentType documentType;
    private String eacCode;
    private String systemEntryDate;
    private String customerId;
    private String customerTaxID;
    private String customerAddress;
    private String customerPhoneNumber;
    private String customerCountry;
    private String companyName;
    @OneToMany(mappedBy = "invoice")
    private List<InvoiceItem> items;
    @OneToMany(mappedBy = "invoice")
    private List<WithholdingTax> withholdingTaxes;
    private Double discount;
    private BigDecimal settlementAmount;
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<PaymentMethod> paymentMethod; // BANK_TRANSFER, CASH, EXPRESS
    private BigDecimal taxPayable;
    private BigDecimal netTotal;
    private BigDecimal grossTotal;

    @Override
    public Map<String, Object> signaturePayload() {
        Map<String, Object> payload = new LinkedHashMap<>();

        payload.put("number", companyName);
        payload.put("nif", companyName);

        return payload;
    }

}

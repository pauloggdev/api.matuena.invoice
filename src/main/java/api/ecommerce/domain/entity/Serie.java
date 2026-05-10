package api.ecommerce.domain.entity;

import java.util.LinkedHashMap;
import java.util.Map;

import api.ecommerce.shared.signature.Signable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String schemaVersion;
    private String submissionUUID;
    private String seriesYear;
    private String documentType;
    private String establishmentNumber;
    @Transient
    private String jwsSignature;
    private String taxRegistrationNumber;
    private String seriesContingencyIndicator;
    private String seriesCode;
    private String authorizedQuantity;
    private String firstDocumentNo;
    private String lastDocumentNo;

}


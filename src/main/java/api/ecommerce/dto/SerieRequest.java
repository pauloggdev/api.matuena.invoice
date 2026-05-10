package api.ecommerce.dto;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import api.ecommerce.domain.entity.BaseAgtRequest;
import api.ecommerce.shared.signature.Signable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder({
        "schemaVersion",
        "submissionUUID",
        "taxRegistrationNumber",
        "submissionTimeStamp",
        "softwareInfo",
        "seriesYear",
        "documentType",
        "establishmentNumber",
        "jwsSignature",
        "seriesContingencyIndicator",
        "seriesContingencyIndicator"
})
public class SerieRequest extends BaseAgtRequest implements Signable {
    @NotNull
    private String seriesYear;
    @NotBlank
    private String documentType;
    @NotBlank
    private String establishmentNumber;
    private String jwsSignature;
    @NotBlank
    private String seriesContingencyIndicator;
    private String taxRegistrationNumber;

    @Override
    public Map<String, Object> signaturePayload() {

        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("taxRegistrationNumber", String.valueOf(taxRegistrationNumber));
        payload.put("seriesYear", String.valueOf(seriesYear));
        payload.put("documentType", String.valueOf(documentType));
        payload.put("establishmentNumber", String.valueOf(establishmentNumber));
        payload.put("seriesContingencyIndicator", String.valueOf(seriesContingencyIndicator));

        return payload;
    }

}

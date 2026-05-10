package api.ecommerce.domain.entity;
import java.util.LinkedHashMap;
import java.util.Map;

import api.ecommerce.shared.signature.Signable;
import lombok.Data;

@Data
public class SoftwareInfoDetail implements Signable {

    private String productId;
    private String productVersion;
    private String softwareValidationNumber;


     @Override
    public Map<String, Object> signaturePayload() {
        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("productId", productId);
        payload.put("productVersion", productVersion);
        payload.put("softwareValidationNumber", softwareValidationNumber);
        return payload;
    }
  

}
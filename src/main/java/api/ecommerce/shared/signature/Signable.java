package api.ecommerce.shared.signature;

import java.util.Map;

public interface Signable {
    Map<String, Object> signaturePayload();
}

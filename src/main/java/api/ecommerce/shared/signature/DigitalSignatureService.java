package api.ecommerce.shared.signature;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

import org.springframework.stereotype.Service;

import java.security.interfaces.RSAPrivateKey;
import java.util.Map;

@Service
public class DigitalSignatureService {

    public String sign(
            Signable signable,
            String privateKeyPath
    ) {

        RSAPrivateKey privateKey = PemUtils.loadPrivateKey(privateKeyPath);

                System.out.println("private key: "+ privateKey);

        Algorithm algorithm =
                Algorithm.RSA256(null, privateKey);

        JWTCreator.Builder builder = JWT.create();
        addClaims(builder, signable.signaturePayload());

        return builder.sign(algorithm);
    }

    private void addClaims(
            JWTCreator.Builder builder,
            Map<String, Object> payload
    ) {

        payload.forEach((key, value) -> {

            if (value instanceof String v) {
                builder.withClaim(key, v);

            } else if (value instanceof Integer v) {
                builder.withClaim(key, v);

            } else if (value instanceof Long v) {
                builder.withClaim(key, v);

            } else if (value instanceof Double v) {
                builder.withClaim(key, v);

            } else if (value instanceof Boolean v) {
                builder.withClaim(key, v);

            } else {

                builder.withClaim(
                        key,
                        String.valueOf(value)
                );
            }
        });
    }
}
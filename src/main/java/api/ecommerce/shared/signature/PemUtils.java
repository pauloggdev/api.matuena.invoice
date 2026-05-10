package api.ecommerce.shared.signature;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
@Component
public class PemUtils {

    private PemUtils() {
    }

  public static RSAPublicKey loadPublicKey(String path) {

    try {

        ClassPathResource resource = new ClassPathResource(path);

        String key = new String(resource.getInputStream().readAllBytes());

        key = key
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s", "");

        byte[] decoded = Base64.getDecoder().decode(key);

        X509EncodedKeySpec spec =
                new X509EncodedKeySpec(decoded);

        KeyFactory keyFactory =
                KeyFactory.getInstance("RSA");

        return (RSAPublicKey)
                keyFactory.generatePublic(spec);

    } catch (Exception e) {

        throw new RuntimeException(
                "Erro ao carregar chave pública",
                e);
    }
}

    public static RSAPrivateKey loadPrivateKey(String path) {

        try {

            ClassPathResource resource = new ClassPathResource(path);

            String key = new String(resource.getInputStream().readAllBytes());
            key = key
                    .replace("-----BEGIN PRIVATE KEY-----", "")
                    .replace("-----END PRIVATE KEY-----", "")
                    .replaceAll("\\s", "");

            byte[] decoded = Base64.getDecoder().decode(key);

            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            return (RSAPrivateKey) keyFactory.generatePrivate(spec);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao carregar chave privada",
                    e);
        }
    }
}
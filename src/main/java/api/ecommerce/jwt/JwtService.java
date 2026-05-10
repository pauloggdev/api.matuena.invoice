package api.ecommerce.jwt;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import api.ecommerce.shared.signature.PemUtils;

@Service
public class JwtService {

    private final RSAPrivateKey privateKey;
    private final RSAPublicKey publicKey;

    public JwtService(PemUtils pemUtils) {
        this.privateKey = pemUtils.loadPrivateKey("keys/private_key.pem");
        this.publicKey = pemUtils.loadPublicKey("keys/public_key.pem");
    }

    public String generateToken(String email) {

        return JWT.create()
                .withSubject(email)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600000))
                .sign(Algorithm.RSA256(null, privateKey));
    }

    public DecodedJWT verify(String token) {

        return JWT.require(Algorithm.RSA256(publicKey, null))
                .build()
                .verify(token);
    }
}
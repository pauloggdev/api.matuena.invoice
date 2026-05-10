package api.ecommerce.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.ecommerce.dto.LoginRequest;
import api.ecommerce.jwt.JwtService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
        Map<String, Object> response = new HashMap<>();
        // simulação (normal seria validar BD)
                System.out.println("TOKEN: ");

        String token = jwtService.generateToken(request.getEmail());
        System.out.println("TOKEN: " + token);

        response.put("token", token);
        return ResponseEntity.ok(response);
    }
}
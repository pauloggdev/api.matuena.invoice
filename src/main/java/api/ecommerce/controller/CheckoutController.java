package api.ecommerce.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.ecommerce.application.CheckoutService;
import api.ecommerce.domain.entity.Checkout;
import api.ecommerce.dto.CheckoutRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/checkout")
@RequiredArgsConstructor
@Slf4j
public class CheckoutController {
    private final CheckoutService service;

    @PostMapping
    public Checkout checkout(@Valid @RequestBody CheckoutRequest req) {
        return service.process(req);
    }
}

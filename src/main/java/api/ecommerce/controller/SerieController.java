package api.ecommerce.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.ecommerce.application.SerieService;
import api.ecommerce.domain.entity.Serie;
import api.ecommerce.dto.SerieRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/series")
@RequiredArgsConstructor
public class SerieController {
    private final SerieService service;

    @PostMapping
    public Serie requestSerie(@Valid @RequestBody SerieRequest req) {
        return service.process(req);
    }
}
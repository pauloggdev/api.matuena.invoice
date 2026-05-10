package api.ecommerce.infrastructure.external.agt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import api.ecommerce.application.port.outbound.AgtSerieGateway;
import api.ecommerce.dto.SerieRequest;
import api.ecommerce.dto.SerieResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class AgtSerieHttpClient implements AgtSerieGateway {
    private final RestTemplate restTemplate;

    @Override
    public Object requestSerie(String requestJson) {

        String url = "https://sifphml.minfin.gov.ao/sigt/fe/v1/solicitarSerie";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        headers.setBasicAuth("ws.hml.kimagest", "mfn73542025");

        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);


        System.out.println(entity);

        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                Object.class).getBody();
    }

}

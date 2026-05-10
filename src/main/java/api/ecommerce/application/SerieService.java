package api.ecommerce.application;

import api.ecommerce.dto.AgtRequestEnricher;
import api.ecommerce.dto.SerieRequest;
import api.ecommerce.shared.signature.DigitalSignatureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tools.jackson.databind.ObjectMapper;
import api.ecommerce.application.port.outbound.AgtSerieGateway;
import api.ecommerce.application.validator.SerieValidatorACL;
import api.ecommerce.domain.entity.Serie;
import api.ecommerce.domain.repository.SerieRepository;

import java.util.Map;
import java.util.UUID;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SerieService {
    private final SerieValidatorACL validator;
    private final SerieRepository serieRepository;
    private final DigitalSignatureService digitalSignatureService;
    private final AgtSerieGateway agtSerieGateway;
    private final AgtRequestEnricher enricher;

    public Serie process(SerieRequest serieRequest) {
        Map<String, String> errors = validator.validate(serieRequest);
        if (!errors.isEmpty()) {
            throw new RuntimeException(errors.toString());
        }
        serieRequest.setTaxRegistrationNumber("5001637720");
        String jwsSignature = digitalSignatureService.sign(serieRequest, "keys/private_key.pem");
        serieRequest.setJwsSignature(jwsSignature);
        String submissionUUID = UUID.randomUUID().toString();
        SerieRequest finalRequest = enricher.enrich(serieRequest);
        ObjectMapper mapper = new ObjectMapper();
        String request = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(finalRequest);
        Object serieResponse = agtSerieGateway.requestSerie(request);

         log.info("SerieResponse: {}", serieResponse);

        Serie serie = Serie.builder()
                .schemaVersion("1")
                .submissionUUID(submissionUUID)
                .seriesYear(serieRequest.getSeriesYear())
                .documentType(serieRequest.getDocumentType())
                .establishmentNumber(serieRequest.getEstablishmentNumber())
                .seriesContingencyIndicator(serieRequest.getSeriesContingencyIndicator())
                .seriesCode("1223239743")
                .authorizedQuantity("99999999999")
                .firstDocumentNo("1")
                .lastDocumentNo("99999999999")
                .taxRegistrationNumber("5001637720")
                .build();

        return serieRepository.save(serie);
    }

}

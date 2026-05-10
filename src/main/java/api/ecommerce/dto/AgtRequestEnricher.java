package api.ecommerce.dto;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import org.springframework.stereotype.Component;

import api.ecommerce.domain.entity.BaseAgtRequest;
import api.ecommerce.domain.entity.SoftwareInfo;
import api.ecommerce.domain.entity.SoftwareInfoDetail;
import api.ecommerce.shared.signature.DigitalSignatureService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AgtRequestEnricher {

    private final DigitalSignatureService digitalSignatureService;

    public <T extends BaseAgtRequest> T enrich(T request) {

        request.setSchemaVersion("1.0");
        request.setSubmissionUUID(UUID.randomUUID().toString());
        request.setTaxRegistrationNumber("5001637720");
        request.setSubmissionTimeStamp(Instant.now()
        .truncatedTo(ChronoUnit.SECONDS)
        .toString());

        SoftwareInfoDetail detail = new SoftwareInfoDetail();
        detail.setProductId("KIMAGEST");
        detail.setProductVersion("1.1");
        detail.setSoftwareValidationNumber("FE/192/AGT/2025");

        SoftwareInfo softwareInfo = new SoftwareInfo();
        softwareInfo.setSoftwareInfoDetail(detail);

        softwareInfo.setJwsSoftwareSignature(digitalSignatureService.sign(detail, "keys/private_key_soft.pem"));

        request.setSoftwareInfo(softwareInfo);

        return request;
    }
}
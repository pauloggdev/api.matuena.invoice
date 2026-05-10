package api.ecommerce.application.validator;

import java.time.LocalDate;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import api.ecommerce.domain.enums.DocumentType;
import api.ecommerce.dto.SerieRequest;

@Component
public class SerieValidatorACL {

    public Map<String, String> validate(SerieRequest req) {

        Map<String, String> errors = new HashMap<>();

        // 1. seriesYear
        if (req.getSeriesYear() == null) {
            errors.put("seriesYear", "seriesYear is required");
        } else {
            int currentYear = Year.now().getValue();
            LocalDate today = LocalDate.now();

            boolean afterDec15 = today.isAfter(LocalDate.of(currentYear, 12, 15));

            if (afterDec15) {
                if (Integer.parseInt(req.getSeriesYear()) != currentYear &&
                        Integer.parseInt(req.getSeriesYear()) != currentYear + 1) {
                    errors.put("seriesYear",
                            "After Dec 15, only current year or next year allowed");
                }
            } else {
                if (Integer.parseInt(req.getSeriesYear()) != currentYear) {
                    errors.put("seriesYear",
                            "Before Dec 15, only current year allowed");
                }
            }
        }

        // 2. documentType
        if (req.getDocumentType() == null || req.getDocumentType().length() != 2) {
            errors.put("documentType", "Must have exactly 2 characters");
        } else if (!DocumentType.isValid(req.getDocumentType())) {
            errors.put("documentType", "Invalid document type");
        }

        // 3. establishmentNumber
        if (req.getEstablishmentNumber() == null ||
                req.getEstablishmentNumber().isBlank()) {

            errors.put("establishmentNumber", "Required");
        } else if (req.getEstablishmentNumber().length() > 200) {
            errors.put("establishmentNumber", "Max length is 200");
        }

        // 4. seriesContingencyIndicator
        if (req.getSeriesContingencyIndicator() == null ||
                req.getSeriesContingencyIndicator().length() != 1) {

            errors.put("seriesContingencyIndicator", "Must be 1 character");
        } else {
            String val = req.getSeriesContingencyIndicator();

            if (!val.equals("N") && !val.equals("C")) {
                errors.put("seriesContingencyIndicator",
                        "Only 'N' (normal) or 'C' (contingency) allowed");
            }
        }

        return errors;
    }
}

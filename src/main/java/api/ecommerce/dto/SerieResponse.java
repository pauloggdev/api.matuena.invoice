package api.ecommerce.dto;

import lombok.Data;

@Data
public class SerieResponse {

    private String seriesCode;
    private String authorizedQuantity;
    private String firstDocumentNo;
    private String lastDocumentNo;
}

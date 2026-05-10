package api.ecommerce.domain.entity;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({
    "softwareInfoDetail",
    "jwsSoftwareSignature"
})
public class SoftwareInfo{

    private SoftwareInfoDetail softwareInfoDetail;
    private Object jwsSoftwareSignature;

   

}

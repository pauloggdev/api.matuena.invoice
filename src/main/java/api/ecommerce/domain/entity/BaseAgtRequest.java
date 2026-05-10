package api.ecommerce.domain.entity;
import lombok.Data;

@Data
public class BaseAgtRequest {
    private String schemaVersion;
    private String submissionUUID;
    private String taxRegistrationNumber;
    private String submissionTimeStamp;
    private SoftwareInfo softwareInfo;
}

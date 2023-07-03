package api.dto;

import lombok.Data;

@Data
public class CreateTestRequest {
    private String SID;
    private String projectName;
    private String testName;
    private String methodName;
    private String env;
}
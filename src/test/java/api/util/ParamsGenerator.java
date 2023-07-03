package api.util;

import api.dto.CreateTestRequest;
import lombok.experimental.UtilityClass;
import util.RandomStringUtil;
import util.SystemUtil;

import java.time.LocalDateTime;
import java.util.Objects;

@UtilityClass
public class ParamsGenerator {
    private static String SID = null;

    public static String getSID() {
        if (Objects.isNull(SID)) {
            SID = LocalDateTime.now().toString();
        }
        return SID;
    }

    public static CreateTestRequest createTestRequest(String projectName, int lengthString) {
        CreateTestRequest testRequest = new CreateTestRequest();
        testRequest.setSID(getSID());
        testRequest.setProjectName(projectName);
        testRequest.setTestName(RandomStringUtil.getRandomString(lengthString));
        testRequest.setMethodName(RandomStringUtil.getRandomString(lengthString));
        testRequest.setEnv(SystemUtil.getHostName());
        return testRequest;
    }
}
package step;

import api.dto.CreateTestRequest;
import api.service.RestTestService;
import api.service.RestTokenService;
import hoard.FileReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.TestModel;
import org.testng.Assert;
import ui.util.BrowserUtil;
import util.FileEncoder;

import java.io.File;
import java.util.List;
import java.util.Objects;

import static constant.PathConstants.PATH_LOG;
import static org.apache.http.HttpStatus.SC_OK;

public class RestStep {
    private RestTestService restTestService = new RestTestService();
    private RestTokenService restTokenService = new RestTokenService();

    public String getToken(String varNumber) {
        Response response = restTokenService.getNewTokenResponse(varNumber);
        assertResponseStatusOK(response);
        String token = restTokenService.getNewToken(response);
        Assert.assertFalse(Objects.isNull(token), "Token is null");
        return token;
    }

    public List<TestModel> getTestList(String projectId) {
        Response response = restTestService.getTestListResponse(projectId);
        assertResponseStatusOK(response);
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()), String.format("Content type is not %s", ContentType.JSON));
        List<TestModel> testModelList = restTestService.getTestList(response);
        Assert.assertFalse(testModelList.isEmpty());
        return testModelList;
    }

    public String addTest(CreateTestRequest request) {
        File screenShot = BrowserUtil.takeScreenShot();
        String encodeScreenshot = FileEncoder.encodeFile(screenShot);
        Response response = restTestService.createTestResponse(request);
        assertResponseStatusOK(response);
        String testId = restTestService.createTestGetId(response);
        String logs = FileReader.readFile(PATH_LOG.getPath());
        response = restTestService.sendTestLogs(testId, logs);
        assertResponseStatusOK(response);
        response = restTestService.sendTestScreenshot(testId, encodeScreenshot);
        assertResponseStatusOK(response);
        return encodeScreenshot;
    }

    public void assertResponseStatusOK(Response response) {
        Assert.assertEquals(response.statusCode(), SC_OK, String.format("Status code is not %s", SC_OK));
    }
}
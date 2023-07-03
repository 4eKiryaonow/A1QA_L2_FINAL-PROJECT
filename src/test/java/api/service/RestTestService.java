package api.service;

import api.dto.CreateTestRequest;
import api.util.RestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import model.TestModel;
import org.openqa.selenium.json.JsonException;

import java.util.*;

import static api.constatnt.EndPoints.*;
import static api.constatnt.query.KeyParameter.*;
import static api.constatnt.query.ValueParameter.IMAGE_CONTENT_TYPE;
import static api.constatnt.query.ValueParameter.JSON;
import static api.constatnt.response.KeyResponse.*;

public class RestTestService {
    public Response getTestListResponse(String projectId) {
        Map<String, String> params = new HashMap<>();
        params.put(PROJECT_ID_KEY.getKeyParam(), projectId);
        return RestUtil.postWithParams(String.format(GET_PROJECT_TESTS, JSON.getValueParam()), params);
    }

    public List<TestModel> getTestList(Response response) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode;
        try {
            rootNode = objectMapper.readTree(response.getBody().asString());
        } catch (JsonProcessingException e) {
            throw new JsonException(e);
        }
        List<TestModel> testModels = new ArrayList<>();
        for (JsonNode testNode : rootNode) {
            TestModel testModel = new TestModel();
            JsonNode durationNode = testNode.get(DURATION.getKeyBody());
            Optional.ofNullable(durationNode).ifPresent(node -> testModel.setDuration(node.asText()));
            JsonNode methodNode = testNode.get(METHOD.getKeyBody());
            Optional.ofNullable(methodNode).ifPresent(node -> testModel.setMethod(node.asText()));
            JsonNode nameNode = testNode.get(TEST_NAME.getKeyBody());
            Optional.ofNullable(nameNode).ifPresent(node -> testModel.setName(node.asText()));
            JsonNode startTimeNode = testNode.get(START_TIME.getKeyBody());
            Optional.ofNullable(startTimeNode).ifPresent(node -> testModel.setStartTime(node.asText()));
            JsonNode endTimeNode = testNode.get(END_TIME.getKeyBody());
            Optional.ofNullable(endTimeNode).ifPresent(node -> testModel.setEndTime(node.asText()));
            JsonNode statusNode = testNode.get(STATUS.getKeyBody());
            Optional.ofNullable(statusNode).ifPresent(node -> testModel.setStatus(node.asText()));
            testModels.add(testModel);
        }
        return testModels;
    }

    public Response createTestResponse(CreateTestRequest request) {
        Map<String, String> params = new HashMap<>();
        params.put(SID_KEY.getKeyParam(), request.getSID());
        params.put(PROJECT_NAME_KEY.getKeyParam(), request.getProjectName());
        params.put(TEST_NAME_KEY.getKeyParam(), request.getTestName());
        params.put(METHOD_NAME_KEY.getKeyParam(), request.getMethodName());
        params.put(ENV_KEY.getKeyParam(), request.getEnv());
        return RestUtil.postWithParams(CREATE_TEST, params);
    }

    public String createTestGetId(Response response) {
        return response.getBody().asString();
    }

    public Response sendTestLogs(String testId, String logs) {
        Map<String, String> params = new HashMap<>();
        params.put(TEST_ID_KEY.getKeyParam(), testId);
        params.put(CONTENT_KEY.getKeyParam(), logs);
        return RestUtil.postWithFormParams(SEND_TEST_LOG, params);
    }

    public Response sendTestScreenshot(String testId, String byteArray) {
        Map<String, String> params = new HashMap<>();
        params.put(TEST_ID_KEY.getKeyParam(), testId);
        params.put(CONTENT_KEY.getKeyParam(), byteArray);
        params.put(CONTENT_TYPE_KEY.getKeyParam(), IMAGE_CONTENT_TYPE.getValueParam());
        return RestUtil.postWithFormParams(SEND_TEST_ATTACH, params);
    }
}
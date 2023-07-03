package api.constatnt;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EndPoints {
    public static final String GET_NEW_TOKEN = "token/get";
    public static final String GET_PROJECT_TESTS = "test/get/%s";
    public static final String CREATE_TEST = "test/put";
    public static final String SEND_TEST_LOG = "test/put/log";
    public static final String SEND_TEST_ATTACH = "test/put/attachment";
}
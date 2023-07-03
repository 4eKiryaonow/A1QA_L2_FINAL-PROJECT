package api.constatnt.query;

import lombok.Getter;

public enum KeyParameter {
    VARIANT_KEY("variant"),
    PROJECT_ID_KEY("projectId"),
    SID_KEY("SID"),
    PROJECT_NAME_KEY("projectName"),
    TEST_NAME_KEY("testName"),
    METHOD_NAME_KEY("methodName"),
    ENV_KEY("env"),
    TEST_ID_KEY("testId"),
    CONTENT_KEY("content"),
    CONTENT_TYPE_KEY("contentType");

    @Getter
    private final String keyParam;

    KeyParameter(String keyParam) {
        this.keyParam = keyParam;
    }
}
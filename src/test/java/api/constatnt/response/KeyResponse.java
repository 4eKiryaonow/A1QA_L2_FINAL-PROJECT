package api.constatnt.response;

import lombok.Getter;

public enum KeyResponse {
    DURATION("duration"),
    METHOD("method"),
    TEST_NAME("name"),
    START_TIME("startTime"),
    END_TIME("endTime"),
    STATUS("status");

    @Getter
    private final String keyBody;

    KeyResponse(String keyBody) {
        this.keyBody = keyBody;
    }
}
package constant;

import lombok.Getter;

public enum PathConstants {
    PATH_CONFIG("config.json"),
    PATH_TEST_DATA("testData.json"),
    PATH_LOG("./target/log/log.log");

    @Getter
    private final String path;

    PathConstants(String path) {
        this.path = path;
    }
}
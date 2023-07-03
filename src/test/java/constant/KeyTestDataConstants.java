package constant;

import lombok.Getter;

public enum KeyTestDataConstants {
    LENGTH_STRING_KEY("/stringLength"),
    USER_KEY("/user"),
    VARIANT_KEY("/variant"),
    PROJECT_NAME_KEY("/projectName");

    @Getter
    private final String keyData;

    KeyTestDataConstants(String keyData) {
        this.keyData = keyData;
    }
}
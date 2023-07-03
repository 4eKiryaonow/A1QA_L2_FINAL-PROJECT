package constant;

import lombok.Getter;

public enum KeyConfigConstants {
    URL_KEY("/urlUI"),
    BASE_URL_KEY("/urlAPI");

    @Getter
    private final String keyConfig;

    KeyConfigConstants(String keyConfig) {
        this.keyConfig = keyConfig;
    }
}
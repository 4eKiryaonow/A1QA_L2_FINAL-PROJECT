package ui.constant;

import lombok.Getter;

public enum KeyConstants {
    TOKEN_KEY("token");

    @Getter
    private final String keyConstant;

    KeyConstants(String keyConstant) {
        this.keyConstant = keyConstant;
    }
}
package constant;

import lombok.Getter;

public enum RegExpConstants {
    PROJECT_ID_REGEX("(?<=projectId=)\\d+"),
    IMAGE_CODE_REGEX("(?<=,).*");

    @Getter
    private final String regExp;

    RegExpConstants(String regExp) {
        this.regExp = regExp;
    }
}
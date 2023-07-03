package constant;

import lombok.Getter;

public enum TimePatternConstants {
    TIME_PATTERN("yyyy-MM-dd HH:mm:ss.S"),
    DURATION_PATTERN("HH:mm:ss.SSS");

    @Getter
    private final String time;

    TimePatternConstants(String time) {
        this.time = time;
    }
}
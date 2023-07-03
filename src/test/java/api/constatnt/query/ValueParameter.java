package api.constatnt.query;

import lombok.Getter;

public enum ValueParameter {
    IMAGE_CONTENT_TYPE("image/png"),
    JSON("json");

    @Getter
    private final String valueParam;

    ValueParameter(String valueParam) {
        this.valueParam = valueParam;
    }
}
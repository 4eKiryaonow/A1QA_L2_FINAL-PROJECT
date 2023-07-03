package ui.constant;

import lombok.Getter;

public enum PageConstants {
    LINK_ATTRIBUTE("href");

    @Getter
    private final String pageConstant;

    PageConstants(String pageConstant) {
        this.pageConstant = pageConstant;
    }
}

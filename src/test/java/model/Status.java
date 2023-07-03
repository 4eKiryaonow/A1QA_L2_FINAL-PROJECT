package model;

import lombok.Getter;

import java.util.Arrays;

public enum Status {
    PASSED("PASSED"),
    SKIPPED("SKIPPED"),
    IN_PROGRESS("IN PROGRESS"),
    FAILED("FAILED");

    @Getter
    private final String status;

    Status(String status) {
        this.status = status;
    }

    public static Status fromString(String statusString) {
        return Arrays.stream(Status.values())
                .filter(status -> status.getStatus().equalsIgnoreCase(statusString))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(statusString));
    }
}

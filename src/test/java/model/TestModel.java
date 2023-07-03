package model;

import lombok.*;
import util.TimeParser;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static constant.TimePatternConstants.DURATION_PATTERN;
import static constant.TimePatternConstants.TIME_PATTERN;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class TestModel {
    private LocalTime duration;
    private String method;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Status status;

    public void setStartTime(String startTime) {
        this.startTime = (LocalDateTime) TimeParser.parseDateTimeOrTime(startTime, TIME_PATTERN.getTime());
    }

    public void setEndTime(String endTime) {
        this.endTime = (LocalDateTime) TimeParser.parseDateTimeOrTime(endTime, TIME_PATTERN.getTime());
    }

    public void setDuration(String duration) {
        this.duration = (LocalTime) TimeParser.parseDateTimeOrTime(duration, DURATION_PATTERN.getTime());
    }

    public void setStatus(String status) {
        this.status = Status.fromString(status);
    }
}
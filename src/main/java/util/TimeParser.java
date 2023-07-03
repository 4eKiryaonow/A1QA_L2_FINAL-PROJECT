package util;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;

import static constant.TimePatternConstants.DURATION_PATTERN;
import static constant.TimePatternConstants.TIME_PATTERN;

@UtilityClass
public class TimeParser {
    public static Temporal parseDateTimeOrTime(String text, String pattern) {
        if (text == null || text.isEmpty()) {
            return null;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            TemporalAccessor temporalAccessor = formatter.parse(text);
            if (pattern.equals(TIME_PATTERN.getTime())) {
                return LocalDateTime.from(temporalAccessor);
            } else if (pattern.equals(DURATION_PATTERN.getTime())) {
                return LocalTime.from(temporalAccessor);
            } else return null;
        } catch (DateTimeParseException e) {
            LoggerManager.error(e.getMessage());
            return null;
        }
    }
}
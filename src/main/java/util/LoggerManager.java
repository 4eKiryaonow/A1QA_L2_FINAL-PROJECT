package util;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LoggerManager {
    private final static Logger logger = AqualityServices.getLogger();

    public static void info(String message) {
        logger.info(message);
    }

    public static void error(String message) {
        logger.error(message);
    }
}
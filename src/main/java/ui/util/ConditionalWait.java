package ui.util;

import aquality.selenium.browser.AqualityServices;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

@UtilityClass
public class ConditionalWait {
    private static Duration waitDuration = AqualityServices.getConfiguration().getTimeoutConfiguration().getCondition();

    public static void waitUntilClickable(By locator) {
        AqualityServices
                .getConditionalWait()
                .waitFor(ExpectedConditions.elementToBeClickable(locator), waitDuration);
    }

    public static void waitUntilPresented(By locator) {
        AqualityServices
                .getConditionalWait()
                .waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator), waitDuration);
    }
}
package ui.util;

import aquality.selenium.browser.AqualityServices;
import hoard.ConfigManager;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import ui.constant.KeyConstants;
import ui.constant.ScriptCommands;
import ui.model.User;

import java.io.File;

import static aquality.selenium.browser.AqualityServices.getBrowser;

@UtilityClass
public class BrowserUtil {
    public static void authorize(User user) {
        getBrowser()
                .goTo(String.format(ConfigManager.getUrlUI(), user.getLogin(), user.getPassword()));
    }

    public static void sendTokenViaCookie(String token) {
        getBrowser()
                .getDriver()
                .manage()
                .addCookie(new Cookie(KeyConstants.TOKEN_KEY.getKeyConstant(), token));
    }

    public static void closePopUp() {
        getBrowser().executeScript(ScriptCommands.CLOSE_WINDOW.getScript());
        getBrowser().tabs().switchToLastTab();
    }

    public static File takeScreenShot() {
        return AqualityServices.getBrowser().getDriver().getScreenshotAs(OutputType.FILE);
    }
}
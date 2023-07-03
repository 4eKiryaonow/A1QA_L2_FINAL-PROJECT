package hoard;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import lombok.experimental.UtilityClass;

import static constant.PathConstants.PATH_CONFIG;
import static constant.PathConstants.PATH_TEST_DATA;

@UtilityClass
public class FileManager {
    public static ISettingsFile getConfig() {
        return new JsonSettingsFile(PATH_CONFIG.getPath());
    }

    public static ISettingsFile getTestData() {
        return new JsonSettingsFile(PATH_TEST_DATA.getPath());
    }
}
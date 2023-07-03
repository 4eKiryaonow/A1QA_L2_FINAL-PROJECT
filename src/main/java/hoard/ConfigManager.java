package hoard;

import lombok.experimental.UtilityClass;

import static constant.KeyConfigConstants.BASE_URL_KEY;
import static constant.KeyConfigConstants.URL_KEY;

@UtilityClass
public class ConfigManager {
    public static String getUrlUI() {
        return FileManager.getConfig().getValue(URL_KEY.getKeyConfig()).toString();
    }

    public static String getUrlAPI() {
        return FileManager.getConfig().getValue(BASE_URL_KEY.getKeyConfig()).toString();
    }
}
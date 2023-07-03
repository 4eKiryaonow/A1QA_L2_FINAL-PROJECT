package api.constant;

import hoard.ConfigManager;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BaseEndPoints {
    public static final String BASE_URL = ConfigManager.getUrlAPI();
}
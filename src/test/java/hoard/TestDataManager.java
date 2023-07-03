package hoard;

import com.google.gson.Gson;
import lombok.experimental.UtilityClass;
import ui.model.User;

import static constant.KeyTestDataConstants.*;

@UtilityClass
public class TestDataManager {
    public static int getLengthRandomString() {
        return (Integer) FileManager.getTestData().getValue(LENGTH_STRING_KEY.getKeyData());
    }

    public static User getUser() {
        String userFromJson = FileManager.getTestData().getValue(USER_KEY.getKeyData()).toString();
        return new Gson().fromJson(userFromJson, User.class);
    }

    public static String getVariant() {
        return FileManager.getTestData().getValue(VARIANT_KEY.getKeyData()).toString();
    }

    public static String getProjectName() {
        return FileManager.getTestData().getValue(PROJECT_NAME_KEY.getKeyData()).toString();
    }
}
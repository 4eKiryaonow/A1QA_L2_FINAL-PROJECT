package util;

import lombok.experimental.UtilityClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Base64;

@UtilityClass
public class FileEncoder {
    public static String encodeFile(File file) {
        byte[] fileContent;
        try {
            fileContent = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            LoggerManager.error(e.getMessage());
            throw new UncheckedIOException(e);
        }
        return Base64.getEncoder().encodeToString(fileContent);
    }
}
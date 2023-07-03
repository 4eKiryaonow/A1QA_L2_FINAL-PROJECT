package hoard;

import lombok.experimental.UtilityClass;
import util.LoggerManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;

@UtilityClass
public class FileReader {
    public static String readFile(String path) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            LoggerManager.error(e.getMessage());
            throw new UncheckedIOException(e);
        }
        return content.toString();
    }
}
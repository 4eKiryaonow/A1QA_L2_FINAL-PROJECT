package util;

import lombok.experimental.UtilityClass;

import java.io.UncheckedIOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@UtilityClass
public class SystemUtil {
    public static String getHostName() {
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            LoggerManager.error(e.getMessage());
            throw new UncheckedIOException(e);
        }
        return ip.getHostName();
    }
}
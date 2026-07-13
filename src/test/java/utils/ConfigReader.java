package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static {
        try {
            FileInputStream fis = new FileInputStream(
                "src/test/resources/config.properties"
            );

            prop = new Properties();
            prop.load(fis);

        } catch (IOException e) {
            throw new RuntimeException("Unable to load config.properties file");
        }
    }

    public static String getUrl() {
        return prop.getProperty("url");
    }
    public static String getInventoryUrl() {
        return prop.getProperty("inventoryUrl");
    }

    public static String getUsername() {
        return prop.getProperty("username");
    }

    public static String getPassword() {
        return prop.getProperty("password");
    }

    public static String getBrowser() {
        return prop.getProperty("browser");
    }
    public static String getApi() {
        return prop.getProperty("api");
    }
}
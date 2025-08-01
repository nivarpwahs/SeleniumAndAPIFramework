package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static void loadProperties() {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            System.out.println("Could not read config.properties file.");
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        if (prop == null) {
            loadProperties(); // Lazy loading
        }
        return prop.getProperty(key);
    }
}

package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesLoader {

    private static Map<String, Properties> propertiesMap = new HashMap<>();

    private PropertiesLoader() {
    }

    public static Properties getProperties(String fileName) {
        if (propertiesMap.containsKey(fileName)) {
            return propertiesMap.get(fileName);
        }
        Properties props = new Properties();
        try (InputStream input = PropertiesLoader.class.getClassLoader()
                .getResourceAsStream(fileName + ".properties")) {
            props.load(input);
            propertiesMap.put(fileName, props);
            return props;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

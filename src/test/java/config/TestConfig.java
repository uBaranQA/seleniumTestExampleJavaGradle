package config;

public class TestConfig {
    public String getBaseUrl() {
        return PropertiesLoader.getProperties("testConfig").getProperty("base.url");
    }
}

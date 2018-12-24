package tests.common;

import config.TestConfig;
import config.webdriver.DriverType;
import config.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Base test page
 */
public abstract class TestBase {

    private WebDriver driver;
    private TestConfig testConfig;

    /**
     * In real life scenario this method would contain test data creation through API or database
     */
    @BeforeClass
    public void classSetup() {
        driver = WebDriverFactory.getDriver(
                DriverType.valueOf(System.getProperty("driver", "chrome").toUpperCase())
        );
    }

    @AfterClass(alwaysRun = true)
    public void classTearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected TestConfig getConfig() {
        if (testConfig == null) {
            testConfig = new TestConfig();
        }
        return testConfig;
    }
}

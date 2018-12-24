package config.webdriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Factory for different driver types
 * Driver type can be controlled via command line
 */
public class WebDriverFactory {

    private WebDriverFactory() {
    }

    public static WebDriver getDriver(DriverType browser) {
        WebDriver driver = null;
        switch (browser) {
            case CHROME:
                driver = getChromeDriver();
                break;
            case FIREFOX:
                driver = getFirefoxDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver getFirefoxDriver() {
        FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        return new FirefoxDriver();
    }

    private static WebDriver getChromeDriver() {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return new ChromeDriver();
    }
}

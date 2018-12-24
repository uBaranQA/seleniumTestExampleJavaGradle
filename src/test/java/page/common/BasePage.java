package page.common;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

/**
 * Abstract page representing any GetBase page
 */
@Getter
public abstract class BasePage extends Page {

    public BasePage(WebDriver driver) {
        this(driver, null);
    }

    public BasePage(WebDriver driver, String url) {
        super(driver, url);
    }
}

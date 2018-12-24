package page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import page.common.BasePage;

@Getter
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        this(driver, null);
    }

    public HomePage(WebDriver driver, String url) {
        super(driver, url);
    }

}

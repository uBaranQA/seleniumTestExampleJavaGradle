package page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.common.BasePage;

import java.util.List;

@Getter
public class JobDetailsPage extends BasePage {

    @FindBy(css = "ul.list li")
    List<WebElement> tagsList;

    public JobDetailsPage(WebDriver driver) {
        this(driver, null);
    }

    public JobDetailsPage(WebDriver driver, String url) {
        super(driver, url);
    }
}

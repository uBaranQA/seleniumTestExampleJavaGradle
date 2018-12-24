package page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.common.BasePage;

@Getter
public class SingleShotPage extends BasePage {


    @FindBy(className = "bucket-shot")
    private WebElement saveButton;

    public SingleShotPage(WebDriver driver) {
        this(driver, null);
    }

    public SingleShotPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public SaveToBucketComponent clickSaveShotToBucket() {
        saveButton.click();
        return new SaveToBucketComponent(driver);
    }
}

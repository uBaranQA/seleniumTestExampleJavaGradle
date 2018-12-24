package page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.common.BasePage;

import java.util.List;

@Getter
public class BucketsListPage extends BasePage {

    @FindBy(css = "div.bucket-name a")
    List<WebElement> savedBucketsNames;

    public BucketsListPage(WebDriver driver) {
        this(driver, null);
    }

    public BucketsListPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public BucketPage clickBucketName() {
        //savedBucketsNames = driver.findElements(by);
        savedBucketsNames.get(0).click();
        return new BucketPage(driver);
    }

}

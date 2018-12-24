package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.common.BasePage;

public class BucketPage extends BasePage {

    @FindBy(className = "delete")
    private WebElement deleteBucketBtn;

    public BucketPage(WebDriver driver) {
        this(driver, null);
    }

    public BucketPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public BucketsListPage deleteBucket() {
        deleteBucketBtn.click();
        driver.switchTo().alert().accept();
        return new BucketsListPage(driver);
    }
}

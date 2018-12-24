package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import page.common.BasePage;

public class ProfileInfoPage extends BasePage {

    @FindBy(className = "more")
    private WebElement moreInfoMenu;

    @FindBy(className = "buckets")
    private WebElement bucketsLink;

    public ProfileInfoPage(WebDriver driver) {
        this(driver, null);
    }

    public ProfileInfoPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public BucketsListPage goToBucketsList() {
        Actions actions = new Actions(driver);
        actions.moveToElement(moreInfoMenu)
                .moveToElement(bucketsLink)
                .click()
                .perform();
        bucketsLink.click();
        return new BucketsListPage(driver);
    }
}

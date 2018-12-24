package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.common.BasePage;

import java.util.List;

public class SaveToBucketComponent extends BasePage {

    @FindBy(id = "bucket_name")
    private WebElement bucketNameInput;

    @FindBy(id = "bucket_description")
    private WebElement bucketDescriptionInput;

    @FindBy(name = "commit")
    private WebElement createBucketBtn;

    @FindBy(id = "bucket-add")
    private WebElement addBucketOverlay;

    @FindBy(className = "section")
    private WebElement getAddBucketOverlayTitle;

    @FindBy(className = "buckets")
    private List<WebElement> bucketsList;

    @FindBy(css = "button")
    private WebElement doneBtn;

    public SaveToBucketComponent(WebDriver driver) {
        this(driver, null);
    }

    public SaveToBucketComponent(WebDriver driver, String url) {
        super(driver, url);
    }

    public SaveToBucketComponent createNewBucket(String name, String description) {
        bucketNameInput.sendKeys(name);
        bucketDescriptionInput.sendKeys(description);
        createBucketBtn.click();
        return this;
    }

    public SingleShotPage saveToBucket(String name) {
/*        new Actions(driver).moveToElement(addBucketOverlay).perform();
        addBucketOverlay.click();*/
        waitUntil(ExpectedConditions.elementToBeClickable(doneBtn));
        doneBtn.click();
        return new SingleShotPage(driver);
    }
}

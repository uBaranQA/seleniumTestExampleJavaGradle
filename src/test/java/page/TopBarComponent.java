package page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import page.common.BasePage;

import java.util.List;

@Getter
public class TopBarComponent extends BasePage {

    @FindBy(id = "t-jobs")
    private WebElement jobsLink;

    @FindBy(id = "t-signin")
    private WebElement signInLink;

    @FindBy(id = "t-profile")
    private WebElement profileInfoIcon;

    @FindBy(className = "your-profile-name")
    private WebElement profileLink;

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(className = "shot")
    List<WebElement> searchShotsResults;

    public TopBarComponent(WebDriver driver) {
        this(driver, null);
    }

    public TopBarComponent(WebDriver driver, String url) {
        super(driver, url);
    }

    public SignInPage clickSignInLink() {
        signInLink.click();
        return new SignInPage(driver);
    }

    public SingleShotPage searchShots(String searchedPhrase) {
        searchField.sendKeys(searchedPhrase);
        WebElement shotFound = searchShotsResults
                .stream()
                .filter(a -> a.getText()
                        .contains(searchedPhrase))
                .findFirst()
                .get();
        shotFound.click();
        return new SingleShotPage(driver);
    }

    public JobsPage clickJobsLink() {
        jobsLink.click();
        return new JobsPage(driver);
    }

    public ProfileInfoPage clickProfileInfoLink() {
        new Actions(driver).moveToElement(profileInfoIcon).perform();
        new Actions(driver).moveToElement(profileLink).perform();
        profileLink.click();
        return new ProfileInfoPage(driver);
    }
}

package page;

import lombok.Getter;
import model.Job;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import page.common.BasePage;

import java.util.List;

@Getter
public class JobsPage extends BasePage {

    Job job;

    @FindBy(className = "jobs-list")
    List<WebElement> jobsList;

    @FindBy(css = "div.null-message p")
    private WebElement noJobsMsg;

    @FindBy(className = "item-link")
    private WebElement jobLink;

    @FindBy(id = "category")
    private WebElement skillsSelect;

    @FindBy(id = "anywhere")
    private WebElement remoteJobInput;

    @FindBy(id = "location")
    private WebElement locationInput;

    @FindBy(className = "submit")
    private WebElement searchButton;

    public JobsPage(WebDriver driver) {
        this(driver, null);
    }

    public JobsPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public JobsPage searchForAJob(Job job) {
        if (job.getLocation().equalsIgnoreCase("Remote")) {
            remoteJobInput.click();
        } else {
            locationInput.sendKeys(job.getLocation());
        }
        Select skills = new Select(skillsSelect);
        skills.selectByVisibleText(job.getSkillSet());
        searchButton.click();
        return this;
    }

    /**
     * This method clicks first job details. Its a simplification just for the demo purposes.
     * @return
     */
    public JobDetailsPage viewJobDetails() {
        waitUntil(ExpectedConditions.elementToBeClickable(jobLink));
        jobLink.click();
        return new JobDetailsPage(driver);
    }
}

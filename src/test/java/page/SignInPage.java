package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.common.BasePage;

public class SignInPage extends BasePage {

    @FindBy(id = "login")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(className = "button")
    private WebElement signInButton;

    public SignInPage(WebDriver driver) {
        this(driver, null);
    }
    public SignInPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public SignInPage setLogin(String email) {
        waitUntil(ExpectedConditions.elementToBeClickable(loginInput));
        loginInput.sendKeys(email);
        return this;
    }

    public SignInPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public HomePage clickSignIn() {
        signInButton.click();
        return new HomePage(driver);
    }
}

package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.base.BasePage;

import java.time.Duration;
import java.util.Objects;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;


    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(username));
        return this.username.isDisplayed();
    }

    public void enterUserCreds(String userName, String pass){
        this.username.sendKeys(userName);
        this.password.sendKeys(pass);
    }

    public void login(){
        this.loginBtn.click();
    }

    public boolean isLoginSuccessful() {
        try {
            boolean urlChanged = wait
                    .withTimeout(Duration.ofSeconds(10))
                    .until(ExpectedConditions.urlContains("/inventory.html"));

            return urlChanged;
        } catch (Exception e) {
            System.out.println("Login not successful. URL did not match expected value.");
            System.out.println("Current URL: " + driver.getCurrentUrl());
            return false;
        }
    }


    public boolean isErrorDisplayed() {
        return errorMessage.isDisplayed();
    }

    public String getErrorMessageText() {
        return isErrorDisplayed() ? errorMessage.getText() : null;
    }
}

package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.dataproviders.LoginDataProvider;
import ui.listeners.TestListener;
import ui.pages.LoginPage;

@Listeners(TestListener.class)
public class LoginTest extends BaseUiTest{

    @Test(groups = {"UI"}, dataProvider = "positiveLoginData", dataProviderClass = LoginDataProvider.class)
    public void testValidLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isAt());
        loginPage.enterUserCreds(username, password);
        loginPage.login();
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login should succeed with valid credentials.");
    }


    @Test(dataProvider = "negativeLoginData", dataProviderClass = LoginDataProvider.class)
    public void testInvalidLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isAt());
        loginPage.enterUserCreds(username, password);
        loginPage.login();
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Login should fail and show error with invalid credentials.");
    }
}

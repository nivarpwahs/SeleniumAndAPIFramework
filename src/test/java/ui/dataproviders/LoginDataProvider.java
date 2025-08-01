package ui.dataproviders;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "positiveLoginData")
    public static Object[][] positiveLoginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"}
        };
    }

    @DataProvider(name = "negativeLoginData")
    public static Object[][] negativeLoginData() {
        return new Object[][]{
                {"invalid_user", "secret_sauce"}
        };
    }
}

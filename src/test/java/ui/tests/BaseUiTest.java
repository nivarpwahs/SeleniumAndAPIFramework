package ui.tests;

import common.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import ui.factory.WebDriverFactory;


public class BaseUiTest {

    private static final Logger logger = LogManager.getLogger(BaseUiTest.class);

    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void beforeSuite() {
        logger.info("Reading Config Properties");
        ConfigReader.loadProperties();
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional String browser, ITestContext context) {
        String selectedBrowser = browser != null ? browser : ConfigReader.get("browser");
        WebDriverFactory.createInstance(selectedBrowser);

        driver = WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("url"));
        context.setAttribute("driver", driver);
    }


    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}

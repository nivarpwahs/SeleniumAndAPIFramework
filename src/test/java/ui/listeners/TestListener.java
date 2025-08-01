package ui.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);


    public void onStart(ITestContext context){
        logger.info("----------Test Started-------------");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object driverObject = result.getTestContext().getAttribute("driver");

        if (driverObject instanceof TakesScreenshot) {
            TakesScreenshot driver = (TakesScreenshot) driverObject;
            String screenshot = driver.getScreenshotAs(OutputType.BASE64);
            String htmlImageFormat = "<img width=700px src='data:image/png;base64,%s'/>";
            String htmlImage = String.format(htmlImageFormat, screenshot);
            Reporter.log(htmlImage);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Object driverObject = result.getTestContext().getAttribute("driver");

        if (driverObject instanceof TakesScreenshot) {
            TakesScreenshot driver = (TakesScreenshot) driverObject;
            String screenshot = driver.getScreenshotAs(OutputType.BASE64);
            String htmlImageFormat = "<img width=700px src='data:image/png;base64,%s'/>";
            String htmlImage = String.format(htmlImageFormat, screenshot);
            Reporter.log(htmlImage);
        }
    }

    public void onFinish(ITestContext context){
        logger.info("----------Test Finished-------------");
    }
}

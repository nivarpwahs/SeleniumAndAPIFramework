package api.apilisteners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import ui.listeners.TestListener;

public class APiTestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(APiTestListener.class);


    public void onStart(ITestContext context){
        logger.info("----------API Test Started-------------");
    }

    public void onFinish(ITestContext context){
        logger.info("----------API Test Finished-------------");
    }
}

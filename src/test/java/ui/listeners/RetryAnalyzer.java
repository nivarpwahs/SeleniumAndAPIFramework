package ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int maxRetries = 2;
    int attempt =0;
    @Override
    public boolean retry(ITestResult iTestResult) {

        while (!iTestResult.isSuccess() && attempt<maxRetries){
            attempt++;
            return true;

        }

        return false;
    }
}

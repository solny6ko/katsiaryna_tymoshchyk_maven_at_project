package tests.TestNGTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestRailDemoListener implements ITestListener {

    public static final Logger LOGGER = LogManager.getLogger((TestRailDemoListener.class));

    @Override
    public void onTestSuccess(ITestResult result){
        LOGGER.info("Test description " + result.getMethod().getDescription());
        LOGGER.info("Printing on success " + result.getStatus());
        TestRailReporter.reportResult("2352", result.getMethod().getDescription(), new Result(1));
    }

    @Override
    public void onTestFailure(ITestResult result){
        LOGGER.info("Test description " + result.getMethod().getDescription());
        LOGGER.info("Printing on failure " + result.getStatus());
        TestRailReporter.reportResult("2352", result.getMethod().getDescription(), new Result(5));
    }
}

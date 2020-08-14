package librarytests.testutils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static client.CustomClientBuilder.logger;

public class TestListener implements ITestListener {

    private String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        logger.info("I am in onStart method " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logger.info("I am in onFinish method " + iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.error("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.warn("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        logger.error("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

}

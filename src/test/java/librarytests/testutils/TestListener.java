package librarytests.testutils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static logger.AllureLogger.*;

public class TestListener implements ITestListener {

    private String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        logToAllureInfo("I am in onStart method " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logToAllureInfo("I am in onFinish method " + iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logToAllureInfo("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logToAllureInfo("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logToAllureError("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logToAllureWarn("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        logToAllureError("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

}

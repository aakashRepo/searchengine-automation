package com.utils.listeners;import com.relevantcodes.extentreports.LogStatus;import com.utils.TakeScreenshotUtil;import com.utils.reports.ExtentManager;import com.utils.reports.ExtentTestManager;import lombok.extern.log4j.Log4j2;import org.testng.ITestContext;import org.testng.ITestListener;import org.testng.ITestResult;import java.util.Calendar;import java.util.Date;@Log4j2public class TestListener implements ITestListener {    private static String getTestMethodName(ITestResult iTestResult) {        return iTestResult.getMethod().getConstructorOrMethod().getName();    }    private static Date getTime(long millis) {        Calendar calendar = Calendar.getInstance();        calendar.setTimeInMillis(millis);        return calendar.getTime();    }    @Override    public void onStart(ITestContext iTestContext) {        TestListener.log.info("onStart method: " + iTestContext.getName());    }    @Override    public void onFinish(ITestContext iTestContext) {        TestListener.log.info("onFinish method: " + iTestContext.getName());        ExtentTestManager.endTest();        ExtentManager.getReporter().flush();    }    @Override    public void onTestStart(ITestResult iTestResult) {        TestListener.log.info("onTestStart method: " + TestListener.getTestMethodName(iTestResult) + " start");    }    @Override    public void onTestSuccess(ITestResult iTestResult) {        TestListener.log.info("onTestSuccess method: " + TestListener.getTestMethodName(iTestResult) + " Passed");        ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");        ExtentTestManager.getTest().setEndedTime(TestListener.getTime(iTestResult.getEndMillis()));        TakeScreenshotUtil.takeScreenShot("pass");    }    @Override    public void onTestFailure(ITestResult iTestResult) {        TestListener.log.info("onTestFailure method: " + TestListener.getTestMethodName(iTestResult) + " Failed");        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed");        ExtentTestManager.getTest().setEndedTime(TestListener.getTime(iTestResult.getEndMillis()));        ExtentTestManager.getTest().log(LogStatus.ERROR, iTestResult.getThrowable());        TakeScreenshotUtil.takeScreenShot("fail");    }    @Override    public void onTestSkipped(ITestResult iTestResult) {        TestListener.log.info("onTestSkipped method: " + TestListener.getTestMethodName(iTestResult) + " Skipped");        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");        ExtentTestManager.getTest().setEndedTime(TestListener.getTime(iTestResult.getEndMillis()));    }    @Override    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {        TestListener.log.info("Test failed but it is in defined success ratio " + TestListener.getTestMethodName(iTestResult));    }}
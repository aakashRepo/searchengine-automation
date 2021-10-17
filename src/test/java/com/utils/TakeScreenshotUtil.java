package com.utils;

import com.driver.DriverManager;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.reports.ExtentTestManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


@Log4j2
public class TakeScreenshotUtil {

    public static void takeScreenShot(String status) {
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) DriverManager.getDriver()).
                getScreenshotAs(OutputType.BASE64);
        if (status.equalsIgnoreCase("pass"))
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed", ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
        else if (status.equalsIgnoreCase("fail"))
            ExtentTestManager.getTest().log(LogStatus.ERROR, "Test Failed", ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }
}

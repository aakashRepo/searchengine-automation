package com.utils.reports;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentManager {

    private static ExtentReports extent;

    public static synchronized ExtentReports getReporter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy_HH_mm_ss");
        String date = LocalDateTime.now().format(formatter);
        if (ExtentManager.extent == null) {
            String workingDir = System.getProperty("user.dir");
            extent =
                    new ExtentReports(workingDir + "/extent-reports/search_automation_" + date + ".html", true);
            extent.addSystemInfo("user", "QA");
            extent.loadConfig(new File(workingDir + "/config/reportextent-config.xml"));
        }
        return extent;
    }
}

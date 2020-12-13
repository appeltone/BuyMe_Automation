package com.appel.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsSingleton {
    private static ExtentReports extent;

    public static ExtentReports getExtentReportsInstance() {
        if (extent == null) {
            String cwd = System.getProperty("user.dir");
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "/extent.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter); // bind extent object with ExtentSparkReporter object called htmlReporter
        }
        return extent;
    }

}

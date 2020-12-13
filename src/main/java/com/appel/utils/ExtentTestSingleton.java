package com.appel.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestSingleton {
    private static ExtentTest test;

    public static ExtentTest getExtentTestInstance(ExtentReports extent) {
        if (test == null) {
            test = extent.createTest(Constants.REPORT_TEST_NAME, Constants.REPORT_TEST_DESCRIPTION);
            extent.setSystemInfo("Environment", "Sanity");
            extent.setSystemInfo("Test suite version ", "1.0");
            extent.setSystemInfo("Current OS", System.getProperty("os.name"));
            extent.setSystemInfo("Tester", Constants.TESTER_NAME);
        }
        return test;

    }
}

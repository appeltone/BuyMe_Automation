package com.appel.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getWebDriverInstance(String browserType) {
        if (driver == null) {
            if (browserType.equals("Chrome")){
                System.setProperty(Constants.CHROME_DRIVER_KEY, Constants.CHROME_DRIVER_VALUE);
                driver = new ChromeDriver();
            }
            else if (browserType.equals("Firefox")){
                System.setProperty(Constants.CHROME_DRIVER_KEY, Constants.CHROME_DRIVER_VALUE);
                driver = new FirefoxDriver();
            }
        }
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}

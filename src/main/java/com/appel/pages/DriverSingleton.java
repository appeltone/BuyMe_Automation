package com.appel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getWebDriverInstance(){
        if (driver == null){
            System.setProperty(Constants.CHROME_DRIVER_KEY, Constants.CHROME_DRIVER_VALUE);
            driver = new ChromeDriver();
        }
        return driver;
    }
}

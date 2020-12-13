package com.appel.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitSingleton {
    private static WebDriverWait wait;

    public static WebDriverWait getWebDriverWaitInstance(WebDriver driver) {
        if (wait == null) {
            System.setProperty(Constants.CHROME_DRIVER_KEY, Constants.CHROME_DRIVER_VALUE);
            wait = new WebDriverWait(driver, Constants.WAIT_TIMEOUT_SEC);
        }
        return wait;
    }
}

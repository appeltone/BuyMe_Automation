package com.appel.tests;

import com.appel.pages.BasePage;
import com.appel.pages.Constants;
import com.appel.pages.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setUpEnv() {
        //System.setProperty(Constants.CHROME_DRIVER_KEY, Constants.CHROME_DRIVER_VALUE);
        //driver = DriverSingleton.getWebDriverInstance();
        driver.get(Constants.URL);
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().fullscreen();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

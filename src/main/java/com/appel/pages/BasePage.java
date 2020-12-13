package com.appel.pages;

import com.appel.utils.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/***
 * This class is a parent/base class that has all the basic actions possible for web elements
 * @author Eran Appel
 */
public class BasePage {
    private WebDriver driver;
    private WebElement element;
    private WebDriverWait wait;
    private ExtentTest test;
    private ExtentReports extent;

    /***
     * Fetching WebDriver instance from DriverSingleton and WebDriverWait instance from WaitSingleton
     * Fetching ExtextReports object in order to fetch ExtentTest object
     * Fetching ExtentTest object while sending ExtentReports for instantiating
     */
    public BasePage() {
        this.driver = DriverSingleton.getWebDriverInstance(XMLReader.getData("browserType"));
        this.wait = WaitSingleton.getWebDriverWaitInstance(driver);
        extent = ExtentReportsSingleton.getExtentReportsInstance();
        test = ExtentTestSingleton.getExtentTestInstance(extent);


    }

    /***
     * General method for clicking a desired web element based on the locator sent
     * @param locator is the desired locator sent by each of the child classes (web pages)
     */
    public void clickElement(By locator) {
        try {
            driver.findElement(locator).click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.fail("Failed to click (element not found) -->> " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(ScreenShotMaker.takeScreenShot(timeNow, driver)).build());
        }

    }

    /***
     * General method for clicking a desired web element based on the locator sent, will wait for the element to
     * be clickable first
     * @param locator is the desired locator sent by each of the child classes (web pages)
     */
    public void clickElementWithWait(By locator) {
        try {
            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (TimeoutException e) {
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.fail("Element was not clickable in time frame given: " + Constants.WAIT_TIMEOUT_SEC + " seconds -->> " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(ScreenShotMaker.takeScreenShot(timeNow, driver)).build());
        }
    }

    /***
     * This method waits and verifies that a desired text is present in a desired element based on locator given
     * @param locator is the desired locator sent by each of the child classes (web pages)
     * @param text text expected to be vissible on desired element
     * @return returns True if the desired text is present in element
     */
    public boolean waitForElementTextToAppear(By locator, String text) {
        boolean textAppear = false;
        try {
            textAppear = wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
            return textAppear;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Failed to find text (element not found) -->> " + e.getMessage());
        }
        return false;
    }

    /***
     * This method verifies/waits until given URL is presented in the driver's browser - based on time limit
     * specified in the wait object
     * @param url desired URL to wait for
     * @return returns True if URL is presented in time range
     */
    public boolean waitForURLToAppear(String url) {
        boolean urlExist = false;
        try {
            urlExist = wait.until(ExpectedConditions.urlToBe(url));
            return urlExist;
        } catch (TimeoutException e) {
            e.printStackTrace();
            test.log(Status.FAIL, "URL given : " + Constants.VERIFY_HOMESCREEN_SELECTION_URL + " was not found" + e.getMessage());
        }
        return false;
    }

    /***
     * This method will send text to a desired element based on a given locator
     * @param locator is the desired locator sent by each of the child classes (web pages)
     * @param text text to send to the desired element
     */
    public void sendKeysToElement(By locator, String text) {
        try {
            driver.findElement(locator).sendKeys(text);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.fail("Failed to send keys to element (element not found) -->> " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(ScreenShotMaker.takeScreenShot(timeNow, driver)).build());
        }
    }

    /***
     * Method for clicking ENTER on a desired element based on a given locator
     * @param locator is the desired locator sent by each of the child classes (web pages)
     */
    public void sendEnterToElement(By locator) {
        try {
            driver.findElement(locator).sendKeys(Keys.ENTER);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.fail("Failed to send ENTER to element (element not found) -->> " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(ScreenShotMaker.takeScreenShot(timeNow, driver)).build());
        }
    }

    /***
     * Will get the text from a desired element based on a given locator
     * @param locator is the desired locator sent by each of the child classes (web pages)
     * @return returns the text from the desired element
     */
    public String getTextFromElement(By locator) {
        try {
            return driver.findElement(locator).getText();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.fail("Failed to get text from element (element not found) -->> " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(ScreenShotMaker.takeScreenShot(timeNow, driver)).build());
        }
        return null;
    }

    /***
     * This method is used for getting the text presented in input boxes elements based on a given locator
     * @param locator is the desired locator sent by each of the child classes (web pages)
     * @return returns the attribute value (text from input box)
     */
    public String getValueFromElement(By locator) {
        try {
            return driver.findElement(locator).getAttribute("value");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.fail("Failed to get value from element (element not found) -->> " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(ScreenShotMaker.takeScreenShot(timeNow, driver)).build());
        }
        return null;
    }

    /***
     * Will clear the text from text area or input boxes elements based on a given locator
     * @param locator is the desired locator sent by each of the child classes (web pages)
     */
    public void clearTextAreaText(By locator) {
        driver.findElement(locator).clear();
    }


}

package com.appel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    /***
     * Fetching WebDriver instance from DriverSingleton and WebDriverWait instance from WaitSingleton
     */
    public BasePage() {
        this.driver = DriverSingleton.getWebDriverInstance();
        this.wait = WaitSingleton.getWebDriverWaitInstance(driver);
    }

    /***
     * General method for clicking a desired web element based on the locator sent
     * @param locator is the desired locator sent by each of the child classes (web pages)
     */
    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    /***
     * General method for clicking a desired web element based on the locator sent, will wait for the element to
     * be clickable first
     * @param locator is the desired locator sent by each of the child classes (web pages)
     */
    public void clickElementWithWait(By locator) {
        element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    /***
     * This method waits and verifies that a desired text is present in a desired element based on locator given
     * @param locator is the desired locator sent by each of the child classes (web pages)
     * @param text text expected to be vissible on desired element
     * @return returns True if the desired text is present in element
     */
    public boolean waitForElementTextToAppear(By locator, String text) {
        Boolean textAppear = wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        return textAppear;
    }

    /***
     * This method verifies/waits until given URL is presented in the driver's browser - based on time limit
     * specified in the wait object
     * @param url desired URL to wait for
     * @return returns True if URL is presented in time range
     */
    public boolean waitForURLToAppear(String url) {
        Boolean urlExist = wait.until(ExpectedConditions.urlToBe(url));
        return urlExist;
    }

    /***
     * This method will send text to a desired element based on a given locator
     * @param locator is the desired locator sent by each of the child classes (web pages)
     * @param text text to send to the desired element
     */
    public void sendKeysToElement(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    /***
     * Method for clicking ENTER on a desired element based on a given locator
     * @param locator is the desired locator sent by each of the child classes (web pages)
     */
    public void sendEnterToElement(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    /***
     * Will get the text from a desired element based on a given locator
     * @param locator is the desired locator sent by each of the child classes (web pages)
     * @return returns the text from the desired element
     */
    public String getTextFromElement(By locator) {
        return driver.findElement(locator).getText();
    }

    /***
     * This method is used for getting the text presented in input boxes elements based on a given locator
     * @param locator is the desired locator sent by each of the child classes (web pages)
     * @return returns the attribute value (text from input box)
     */
    public String getValueFromElement(By locator) {
        return driver.findElement(locator).getAttribute("value");
    }

    /***
     * Will clear the text from text area or input boxes elements based on a given locator
     * @param locator is the desired locator sent by each of the child classes (web pages)
     */
    public void clearTextAreaText(By locator) {
        driver.findElement(locator).clear();
    }


}

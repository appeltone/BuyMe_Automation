package com.appel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class BasePage {
    private WebDriver driver;
    private WebElement element;
    private WebDriverWait wait;


    public BasePage() {
        this.driver = DriverSingleton.getWebDriverInstance();
        this.wait = WaitSingleton.getWebDriverWaitInstance(driver);
    }

    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public void clickElementWithWait(By locator) {
        element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.click();
    }

    public boolean waitForElementTextToAppear(By locator, String text){
        Boolean textAppear = wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        return textAppear;
    }

    public boolean waitForURLToAppear(String url){
        Boolean urlExist = wait.until(ExpectedConditions.urlToBe(url));
        return urlExist;
    }



    public void sendKeysToElement(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    public void sendEnterToElement(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public String getTextFromElement(By locator){
        return driver.findElement(locator).getText();
    }

    public String getValueFromElement(By locator){
        return driver.findElement(locator).getAttribute("value");
    }

    public void clearTextAreaText(By locator){
        driver.findElement(locator).clear();
    }


}

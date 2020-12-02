package com.appel.tests;

import com.appel.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExtraTests {

    public WebDriver driver;
    public HomePage homePage;
    public LoginAndRegistrationPage introPage;
    public BusinessResultPage businessResultPage;
    public SenderReceiverInfoPage senderReceiverInfoPage;

    @BeforeClass
    public void setUpEnv() {
        driver = DriverSingleton.getWebDriverInstance();
        driver.get(Constants.URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homePage = new HomePage();
        introPage = new LoginAndRegistrationPage();
        businessResultPage = new BusinessResultPage();
        senderReceiverInfoPage = new SenderReceiverInfoPage();
    }

    @Test
    public void loadingScreenTest() {
        driver.navigate().refresh();
        WebDriverWait wait = WaitSingleton.getWebDriverWaitInstance(driver);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div/div/div[2]/div/div/div[3]")));
        WebElement dot = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[3]"));
        Dimension d = dot.getSize();
        System.out.println("Height: " + d.height);
        System.out.println("Width: " + d.width);
        System.out.println(dot.isDisplayed());
    }

    @Test
    public void negativeLoginTest(){
        homePage.clickRegistrationButton();
        introPage.clickLoginButton();

        Assert.assertEquals(introPage.getEmailEmptyErrorMessage(), Constants.EMAIL_EMPTY_ERROR);
        Assert.assertEquals(introPage.getPassEmptyErrorMessage(), Constants.PASS_EMPTY_ERROR);
    }

    @Test
    public void printTextColorOfStepNameTest(){

        //login
        driver.get("https://buyme.co.il/money/765832");
        WebElement whoToSend = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/ul/li[2]/div/div[2]/div[1]"));
        String color = whoToSend.getCssValue("color");
        System.out.println("Color of this text is: " + color);


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

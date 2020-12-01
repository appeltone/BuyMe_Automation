package com.appel.tests;

import com.appel.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IntroPageTest {
    public WebDriver driver;
    public HomePage homePage;
    public LoginAndRegistrationPage introPage;
    public BusinessResultPage businessResultPage;
    public SenderReceiverInfoPage senderReceiverInfoPage;

    @BeforeMethod
    public void setUpEnv() {
        driver = DriverSingleton.getWebDriverInstance();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(Constants.URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        homePage = new HomePage();
        introPage = new LoginAndRegistrationPage();
        businessResultPage = new BusinessResultPage();
        senderReceiverInfoPage = new SenderReceiverInfoPage();
    }


    @Test
    public void loginRegistrationTest() throws InterruptedException {

        homePage.clickRegistrationButton();
        introPage.enterSite(Constants.FIRST_NAME, Constants.EMAIL, Constants.PASSWORD, Constants.ACCOUNT_EXIST);

        //assert registration fields
        if (Constants.ACCOUNT_EXIST == false) {
            Assert.assertEquals(introPage.getFirstNameFieldText(), Constants.FIRST_NAME);
            Assert.assertEquals(introPage.getemailFieldText(), Constants.EMAIL);
            Assert.assertEquals(introPage.getpassFieldText(), Constants.PASSWORD);
            Assert.assertEquals(introPage.getpassVerifyFieldText(), Constants.PASSWORD);
        }

        introPage.submitRegData();

        //assert login passed
        if (homePage.verifyButtonTextExist()) {
            Assert.assertEquals(homePage.getAfterLoginRegButtonText(), Constants.VERIFY_LOGIN);
        }
    }

    @Test(dependsOnMethods = {"loginRegistrationTest"})
    public void HomeScreenSelectionsTest() throws InterruptedException {

        homePage.clickAmountDropDown();
        homePage.selectAmountFromDropDown();
        homePage.clickAreaDropDown();
        homePage.selectAreaFromDropDown();
        homePage.clickCategoryDropDown();
        homePage.selectCategoryFromDropDown();

        homePage.clickFindMeAGiftButton();

        if (homePage.waitForURLToAppear(Constants.VERIFY_HOMESCREEN_SELECTION_URL)) {
            Assert.assertEquals(driver.getCurrentUrl(), Constants.VERIFY_HOMESCREEN_SELECTION_URL);
        }
    }

    @Test(dependsOnMethods = {"HomeScreenSelectionsTest"})
    public void pickBusinessTest() throws InterruptedException {

//        if (driver.getCurrentUrl() != "https://buyme.co.il/supplier/352936") {
//            driver.navigate().back();
//        }
        businessResultPage.clickBusinessFromResults();
        businessResultPage.enterAmountForGiftCard();
        businessResultPage.clickGiftCardChooseButton();

//        if (driver.getCurrentUrl() != "hhttps://buyme.co.il/money/352936") {
//            driver.navigate().back();
//        }


    }

    //@Test(dependsOnMethods = {"pickBusinessTest"})
    public void senderReceiverInformationTest() {


        senderReceiverInfoPage.clickSomeoneElseRadioButton();
        senderReceiverInfoPage.typeInReceiverName();
        senderReceiverInfoPage.typeInSenderName();
        senderReceiverInfoPage.clickEventDropDown();
        senderReceiverInfoPage.selectFromDropDown();
        senderReceiverInfoPage.clearBlessingTextArea();
        senderReceiverInfoPage.typeInBlessing();
        senderReceiverInfoPage.clickSendNowRadioButton();
        senderReceiverInfoPage.chooseSendByEmail();
        senderReceiverInfoPage.typeInReceiverEmail();
        senderReceiverInfoPage.clickSaveEmailButton();


    }

    //@AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

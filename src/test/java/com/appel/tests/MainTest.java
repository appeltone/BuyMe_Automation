package com.appel.tests;

import com.appel.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MainTest {
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


    @Test(priority = 0)
    public void loginRegistrationTest() {

        homePage.clickRegistrationButton();
        introPage.enterSite(Constants.FIRST_NAME, Constants.EMAIL, Constants.PASSWORD, Constants.ACCOUNT_EXIST);

        //assert registration/login fields
        if (Constants.ACCOUNT_EXIST == false) {
            Assert.assertEquals(introPage.getFirstNameFieldText(), Constants.FIRST_NAME);
            Assert.assertEquals(introPage.getemailFieldText(), Constants.EMAIL);
            Assert.assertEquals(introPage.getpassFieldText(), Constants.PASSWORD);
            Assert.assertEquals(introPage.getpassVerifyFieldText(), Constants.PASSWORD);
            introPage.submitRegData();
        } else {
            Assert.assertEquals(introPage.getEmailExistField(), Constants.EMAIL);
            Assert.assertEquals(introPage.getPassExistField(), Constants.PASSWORD);
            introPage.clickLoginButton();
        }

        //assert login passed
        if (homePage.verifyButtonTextExist()) {
            Assert.assertEquals(homePage.getAfterLoginRegButtonText(), Constants.VERIFY_LOGIN);
        }
    }


    @Test(priority = 1)
    public void HomeScreenSelectionsTest() {

        homePage.clickAmountDropDown();
        homePage.selectAmountFromDropDown();

        homePage.clickAreaDropDown();
        homePage.selectAreaFromDropDown();

        homePage.clickCategoryDropDown();
        homePage.selectCategoryFromDropDown();

        homePage.clickFindMeAGiftButton();

    }

    @Test(priority = 2)
    public void pickBusinessTest() {

        Assert.assertEquals(homePage.waitForURLToAppear(Constants.VERIFY_HOMESCREEN_SELECTION_URL), true);

        businessResultPage.clickBusinessFromResults();
        businessResultPage.enterAmountForGiftCard();
        businessResultPage.clickGiftCardChooseButton();

    }

    @Test(priority = 3)
    public void senderReceiverInformationTest() throws InterruptedException {

        senderReceiverInfoPage.clickSomeoneElseRadioButton();
        senderReceiverInfoPage.typeInReceiverName();
        senderReceiverInfoPage.clearSenderNameField();
        senderReceiverInfoPage.typeInSenderName();
        senderReceiverInfoPage.clickEventDropDown();
        senderReceiverInfoPage.selectFromDropDown();
        senderReceiverInfoPage.clearBlessingTextArea();
        senderReceiverInfoPage.typeInBlessing();
        senderReceiverInfoPage.clickSendNowRadioButton();
        senderReceiverInfoPage.chooseSendByEmail();
        senderReceiverInfoPage.typeInReceiverEmail();
        senderReceiverInfoPage.clickSaveEmailButton();

        //assert Sender and Receiver names
        Assert.assertEquals(senderReceiverInfoPage.getReceiverNameText(), Constants.RECEIVER_NAME);
        Assert.assertEquals(senderReceiverInfoPage.getSenderNameText(), Constants.SENDER_NAME);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

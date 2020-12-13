package com.appel.tests;

import com.appel.pages.*;
import com.appel.utils.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class MainTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginAndRegistrationPage introPage;
    private BusinessResultPage businessResultPage;
    private SenderReceiverInfoPage senderReceiverInfoPage;
    private ExtentTest test;
    private ExtentReports extent;
    private String timeNow;

    @BeforeClass
    public void setUpEnv() {
        String browserType = XMLReader.getData("browserType");
        driver = DriverSingleton.getWebDriverInstance(browserType);
        driver.get(XMLReader.getData("testUrl"));
        driver.manage().window().maximize();
        homePage = new HomePage();
        introPage = new LoginAndRegistrationPage();
        businessResultPage = new BusinessResultPage();
        senderReceiverInfoPage = new SenderReceiverInfoPage();

        extent = ExtentReportsSingleton.getExtentReportsInstance();
        test = ExtentTestSingleton.getExtentTestInstance(extent);
        test.log(Status.INFO, "@Before class");
    }


    @Test(priority = 0)
    public void loginRegistrationTest() {

        test.log(Status.INFO,"@Test [Login / Registration Test] Starting");
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
            timeNow = String.valueOf(System.currentTimeMillis());
            test.log(Status.PASS,"@Test [Login / Registration Test] Passed successfully",
                    MediaEntityBuilder.createScreenCaptureFromPath(ScreenShotMaker.takeScreenShot(timeNow, driver)).build());
        }
    }


    @Test(priority = 1)
    public void homeScreenSelectionsTest() {
        test.log(Status.INFO,"@Test [Home Screen Selections Test] Starting");

        homePage.selectPresentToSearch();
        homePage.clickFindMeAGiftButton();

        Assert.assertEquals(homePage.waitForURLToAppear(Constants.VERIFY_HOMESCREEN_SELECTION_URL), true);
        test.log(Status.PASS,"@Test [Home Screen Selections Test] Passed successfully");
    }

    @Test(priority = 2)
    public void pickBusinessTest() {

        test.log(Status.INFO,"@Test [Pick Business Test] Starting");

        businessResultPage.clickBusinessFromResults();
        businessResultPage.enterAmountForGiftCard();
        businessResultPage.clickGiftCardChooseButton();

        test.log(Status.PASS,"@Test [Pick Business Test] Passed successfully");

    }

    @Test(priority = 3)
    public void senderReceiverInformationTest() throws InterruptedException {

        test.log(Status.INFO,"@Test [Sender Receiver Information Test] Starting");

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
        test.log(Status.PASS,"@Test [Sender Receiver Information Test] Passed successfully");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        extent.flush();
        test.log(Status.INFO, "@After class");
    }
}

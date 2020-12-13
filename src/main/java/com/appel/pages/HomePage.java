package com.appel.pages;

import com.appel.utils.Constants;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    By registrationButton = By.xpath("/html/body/div[2]/div/header/div[1]/div/ul[1]/li[3]/a/span[2]");
    By amountDropDown = By.xpath("/html/body/div[2]/div/header/div[3]/div/form/div[1]/a/span");
    By amountDropDownSelected = By.xpath("/html/body/div[2]/div/header/div[3]/div/form/div[1]/div/ul/li[5]");
    By areaDropDown = By.xpath("/html/body/div[2]/div/header/div[3]/div/form/div[2]/a/span");
    By areaDropDownSelected = By.xpath("/html/body/div[2]/div/header/div[3]/div/form/div[2]/div/ul/li[2]");
    By categoryDropDown = By.xpath("/html/body/div[2]/div/header/div[3]/div/form/div[3]/a/span");
    By categoryDropDownSelected = By.xpath("/html/body/div[2]/div/header/div[3]/div/form/div[3]/div/ul/li[2]");
    By findMeAGiftButton = By.xpath("/html/body/div[2]/div/header/div[3]/div/form/a");
    By afterLoginRegButton = By.xpath("/html/body/div[2]/div/header/div[1]/div/ul[1]/li[3]/a/span");


    public void selectPresentToSearch(){
        clickAmountDropDown();
        selectAmountFromDropDown();
        clickAreaDropDown();
        selectAreaFromDropDown();
        clickCategoryDropDown();
        selectCategoryFromDropDown();
    }

    public void clickRegistrationButton() {
        clickElementWithWait(registrationButton);
    }

    public void clickAmountDropDown() {
        clickElementWithWait(amountDropDown);
    }

    public void selectAmountFromDropDown() {
        clickElement(amountDropDownSelected);
    }

    public void clickAreaDropDown() {
        clickElementWithWait(areaDropDown);
    }

    public void selectAreaFromDropDown() {
        clickElement(areaDropDownSelected);
    }

    public void clickCategoryDropDown() {
        clickElementWithWait(categoryDropDown);
    }

    public void selectCategoryFromDropDown() {
        clickElement(categoryDropDownSelected);
    }

    public void clickFindMeAGiftButton() {
        clickElement(findMeAGiftButton);
    }

    public String getAfterLoginRegButtonText() {
        return getTextFromElement(afterLoginRegButton);
    }

    public boolean verifyButtonTextExist() {
        return waitForElementTextToAppear(afterLoginRegButton, Constants.VERIFY_LOGIN);
    }

}

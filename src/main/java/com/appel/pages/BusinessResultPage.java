package com.appel.pages;

import com.appel.utils.Constants;
import org.openqa.selenium.By;

public class BusinessResultPage extends BasePage {

    By randomBusinessToSelect = By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div[6]/a/div/div[2]/img");
    //By randomBusinessToSelect = By.xpath("fake");
    By giftCardAmountField = By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div/div/div[2]/form/div[1]/div[1]/div/div/div/input");
    By giftCardChooseButton = By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div/div/div[2]/form/div[2]/div/button");

    public void clickBusinessFromResults() {
        clickElementWithWait(randomBusinessToSelect);
    }

    public void enterAmountForGiftCard() {
        sendKeysToElement(giftCardAmountField, Constants.GIFT_CARD_AMOUNT);
    }

    public void clickGiftCardChooseButton() {
        clickElementWithWait(giftCardChooseButton);
    }

    public void clickEnterOnEAmountField() {
        sendEnterToElement(giftCardAmountField);
    }
}

package com.appel.pages;

import com.appel.utils.Constants;
import org.openqa.selenium.By;

public class SenderReceiverInfoPage extends BasePage {

    By someoneElseRadioButton = By.xpath("/html/body/div[2]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[1]/label[1]/span[1]");
    By receiverNameField = By.xpath("/html/body/div[2]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[2]/label[1]/input");
    By senderNameField = By.xpath("/html/body/div[2]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[2]/label[2]/input");
    By eventDropDown = By.xpath("/html/body/div[2]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[3]/label[1]/div/a/span");
    By eventDropDownSelection = By.xpath("/html/body/div[2]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[3]/label[1]/div/div/ul/li[5]");
    By blessingTextArea = By.xpath("/html/body/div[2]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[3]/label[2]/textarea");
    By sendNowRadioButton = By.xpath("/html/body/div[2]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div[1]/label[1]");
    By sendByEmail = By.xpath("/html/body/div[2]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[4]/div/div[1]/div[2]/div/button/span/span[2]");
    By receiverEmail = By.xpath("/html/body/div[2]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[4]/div/div[4]/div/div[1]/div/div/input");
    By saveEmailButton = By.xpath("/html/body/div[2]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[4]/div/div[4]/div/div[2]/button[2]");


    public void clickSomeoneElseRadioButton() {
        clickElement(someoneElseRadioButton);
    }

    public void typeInReceiverName() {
        sendKeysToElement(receiverNameField, Constants.RECEIVER_NAME);
    }

    public void clearSenderNameField(){
        clearTextAreaText(senderNameField);
    }
    public void typeInSenderName() {
        sendKeysToElement(senderNameField, Constants.SENDER_NAME);
    }

    public String getReceiverNameText() {
        return(getValueFromElement(receiverNameField));
    }

    public String getSenderNameText() {
        return(getValueFromElement(senderNameField));
    }

    public void clickEventDropDown() {
        clickElement(eventDropDown);
    }

    public void selectFromDropDown() {
        clickElement(eventDropDownSelection);
    }

    public void clearBlessingTextArea() {
        clearTextAreaText(blessingTextArea);
    }

    public void typeInBlessing() {
        sendKeysToElement(blessingTextArea, Constants.BLESSING_TO_SEND);
    }

    public void clickSendNowRadioButton() {
        clickElement(sendNowRadioButton);
    }

    public void chooseSendByEmail() {
        clickElement(sendByEmail);
    }

    public void typeInReceiverEmail() {
        sendKeysToElement(receiverEmail, Constants.RECEIVER_EMAIL);
    }

    public void clickSaveEmailButton() {
        clickElement(saveEmailButton);
    }

}

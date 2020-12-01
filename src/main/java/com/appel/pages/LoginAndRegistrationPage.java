package com.appel.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginAndRegistrationPage extends BasePage {

    //set locators for elements we use one this page
    private By registrationLink = By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/p[1]/span");
    private By firstNameField = By.id("ember1235");
    private By emailExistField = By.xpath("//*[@placeholder='מייל']");
    private By emailField = By.id("ember1237");
    private By passField = By.id("valPass");
    private By passExistField = By.xpath("//*[@placeholder='סיסמה']");
    private By passVerifyField = By.id("ember1241");
    private By regSubmitButton = By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/div/div[3]/form/button");
    private By loginSubmitButton = By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/div/div[3]/form/button");



    //page actions
    public void enterSite(String firstName, String email, String pass, Boolean accountExist){
        if (accountExist) {
            loginToSite(email, pass);
        }
        else {
            registerToSite(firstName, email, pass);
        }
    }

    private void loginToSite(String email, String pass){
        sendKeysToElement(emailExistField, email);
        sendKeysToElement(passExistField, pass);
        clickElement(loginSubmitButton);
    }

    private void registerToSite(String firstName, String email, String pass){
        clickElement(registrationLink);
        sendKeysToElement(firstNameField, firstName);
        sendKeysToElement(emailField, email);
        sendKeysToElement(passField, pass);
        sendKeysToElement(passVerifyField, pass);
    }

    public String getFirstNameFieldText(){
        return getValueFromElement(firstNameField);
    }

    public String getemailFieldText(){
        return getValueFromElement(emailField);
    }

    public String getpassFieldText(){
        return getValueFromElement(passField);
    }

    public String getpassVerifyFieldText(){
        return getValueFromElement(passVerifyField);
    }

    public void submitRegData(){
        clickElement(regSubmitButton);
    }

}

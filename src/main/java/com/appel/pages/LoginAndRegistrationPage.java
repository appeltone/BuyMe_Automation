package com.appel.pages;

import org.openqa.selenium.By;


public class LoginAndRegistrationPage extends BasePage {

    private By registrationLink = By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/p[1]/span");
    private By firstNameField = By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/div/div[3]/form/div[1]/label/input");
    private By emailExistField = By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/div/div[3]/form/div[1]/label/input");
    private By emailField = By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/div/div[3]/form/div[2]/label/input");
    private By passField = By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/div/div[3]/form/div[3]/label/input");
    private By passExistField = By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/div/div[3]/form/div[2]/label/input");
    private By passVerifyField = By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/div/div[3]/form/div[4]/label/input");
    private By regSubmitButton = By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/div/div[3]/form/button");
    private By loginSubmitButton = By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/div/div[3]/form/button");
    private By emailEmptyErrorMessage = By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/div/div[3]/form/div[1]/label/ul/li");
    private By passEmptyErrorMessage = By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/div/div[3]/form/div[2]/label/ul/li");



    public void enterSite(String firstName, String email, String pass, Boolean accountExist) {
        if (accountExist) {
            loginToSite(email, pass);
        } else {
            registerToSite(firstName, email, pass);
        }
    }

    private void loginToSite(String email, String pass) {
        sendKeysToElement(emailExistField, email);
        sendKeysToElement(passExistField, pass);
    }

    private void registerToSite(String firstName, String email, String pass) {
        clickElement(registrationLink);
        sendKeysToElement(firstNameField, firstName);
        sendKeysToElement(emailField, email);
        sendKeysToElement(passField, pass);
        sendKeysToElement(passVerifyField, pass);
    }

    public String getFirstNameFieldText() {
        return getValueFromElement(firstNameField);
    }

    public String getemailFieldText() {
        return getValueFromElement(emailField);
    }

    public String getpassFieldText() {
        return getValueFromElement(passField);
    }

    public String getpassVerifyFieldText() {
        return getValueFromElement(passVerifyField);
    }

    public String getEmailExistField(){
        return getValueFromElement(emailExistField);
    }

    public String getPassExistField(){
        return getValueFromElement(passExistField);
    }

    public void submitRegData() {
        clickElementWithWait(regSubmitButton);
    }

    public void clickLoginButton(){
        clickElement(loginSubmitButton);
    }

    public String getEmailEmptyErrorMessage(){
        return getTextFromElement(emailEmptyErrorMessage);
    }

    public String getPassEmptyErrorMessage(){
        return getTextFromElement(passEmptyErrorMessage);
    }
}

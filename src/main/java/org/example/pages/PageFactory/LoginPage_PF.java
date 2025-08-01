package org.example.pages.PageFactory;

import org.example.base.CommonToAllPage;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF  extends CommonToAllPage {

    // Param  C
    public LoginPage_PF(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    //  Page Locators
    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    @FindBy(css = "#js-notification-box-msg")
    private WebElement error_message;


    // Page Actions
    public String loginToVWOInvalidCreds() {

       // enterInput(username, PropertiesReader.readkey("invalid_username"));
       // enterInput(password,PropertiesReader.readkey("invalid_password"));
        clickElement(signButton);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return error_message.getText();

    }
}

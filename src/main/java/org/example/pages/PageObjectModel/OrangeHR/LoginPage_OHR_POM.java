package org.example.pages.PageObjectModel.OrangeHR;

import org.example.base.CommonToAllPage;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_OHR_POM extends CommonToAllPage {

    WebDriver driver;

    public LoginPage_OHR_POM(WebDriver driver) {
        this.driver = driver;
    }

    //Page Locators

    private By username = By.xpath("//input[@placeholder='Username']");
    private By password =  By.xpath("//input[@placeholder='Password']");
    private By login_button = By.xpath("//button[normalize-space()='Login']");
   // private By ohr_expected_username = By.

    // Page Actions

    public void loginToOrangeHRValidCreds(String user, String pwd)
    {
        driver.get(PropertiesReader.readkey("orange_hr_url"));
        visibilityOfElement(username);
//        enterInput(username, user);
//        enterInput(password, pwd);
//        clickElement(login_button);
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(login_button).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}

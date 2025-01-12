package org.example.pages.PageObjectModel.VWO;

import org.example.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.example.base.CommonToAllPage;
import org.example.utils.PropertiesReader;
import org.example.utils.UtilsExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginPage_POM_Selenoid extends CommonToAllPage{


        WebDriver driver;//Instance of Webdriver

        public LoginPage_POM_Selenoid(WebDriver driver) { //Parameterized Constractor
            this.driver = driver;
        }

        // Page Locators
        private By username = By.id("login-username");
        private By Password = By.id("login-password");
        private By signButton = By.id("js-login-btn");
        private By error_message = By.id("js-notification-box-msg");


        // Page Actions

        public String loginToVWOLoginInvalidCreds(String email, String password) {

            //driver.get(PropertiesReader.readkey("url"));
            driver.get("https://app.vwo.com");
            driver.findElement(username).sendKeys(email);
            driver.findElement(Password).sendKeys(password);
            driver.findElement(signButton).click();

//            enterInput(username,user);
//            enterInput(password,pwd);
//            clickElement(signButton);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            String error_message_text = driver.findElement(error_message).getText();
            return error_message_text;

        }

        public void loginToVWOLoginValidCreds(String email, String password) throws InterruptedException {

            // driver.get(PropertiesReader.readkey("url"));
            driver.get("https://app.vwo.com");
            driver.findElement(username).sendKeys(email);
            driver.findElement(Password).sendKeys(password);
            driver.findElement(signButton).click();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }


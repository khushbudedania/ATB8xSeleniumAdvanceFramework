package org.example.tests.VWOLogin.PageObjectModel_TestCase;

import org.example.base.CommonToAllTest;
import org.example.base.DriverFactory_BaseTest;
import org.example.driver.DriverFactory;
import org.example.driver.DriverManager;
import org.example.driver.DriverManagerTL_ThreadLocal;
import org.example.pages.PageObjectModel.VWO.DashboardPage_POM;
import org.example.pages.PageObjectModel.VWO.LoginPage_POM;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.utils.PropertiesReader;
import org.example.utils.UtilsExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import static org.example.driver.DriverManager.driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.Duration;


public class TestVWOLogin_POM extends DriverFactory_BaseTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_POM.class);


    //@BeforeMethod
    @Description("Verify that invalid creds give you error message")
    @Test(testName = "chrome")
    public void testLoginNegativeVWO() throws InterruptedException {

        logger.info("Starting The Negative testCases of the POM");

        LoginPage_POM loginPagePom = new LoginPage_POM(DriverFactory.getDriver());
        String error_msg = loginPagePom.loginToVWOLoginInvalidCreds(PropertiesReader.readkey("invalid_username"), PropertiesReader.readkey("invalid_password"));

        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg, PropertiesReader.readkey("error_message"));

    }

    @Description("Verify that valid Creds Suceesfully login")
    @Test(testName = "firefox")
    public void testPositive() throws InterruptedException, IOException {

        logger.info("Starting The Positive testCases of the POM");

        LoginPage_POM loginPagePom = new LoginPage_POM(DriverFactory.getDriver());
        loginPagePom.loginToVWOLoginValidCreds(PropertiesReader.readkey("username"), PropertiesReader.readkey("password"));

        Thread.sleep(3000);

        DashboardPage_POM dashboardPagePom = new DashboardPage_POM(DriverFactory.getDriver());
        String loggedInUserName = dashboardPagePom.loggedInUserName();

        assertThat(loggedInUserName).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedInUserName,PropertiesReader.readkey("expected_username"));


    }
}
// if you have use before method then two browser window open for two tc.
//if you have use before test then one browser window open for two tc.
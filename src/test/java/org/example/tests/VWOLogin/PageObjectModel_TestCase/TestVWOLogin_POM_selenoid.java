package org.example.tests.VWOLogin.PageObjectModel_TestCase;

import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.CommonToAllTest;
//import org.example.driver.DriverManager;
import org.example.base.CommonToAllTest_Selenoid;
import org.example.driver.DriverManagerSelenoid;
import org.example.pages.PageObjectModel.VWO.DashboardPage_POM;
import org.example.pages.PageObjectModel.VWO.LoginPage_POM;
import org.example.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;


public class TestVWOLogin_POM_selenoid extends CommonToAllTest_Selenoid {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_POM_selenoid.class);


    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO() throws InterruptedException {

        logger.info("Starting The testCases of the POM");

        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManagerSelenoid.getDriver());
        String error_msg = loginPagePom.loginToVWOLoginInvalidCreds(PropertiesReader.readkey("invalid_username"), PropertiesReader.readkey("invalid_password"));

        Thread.sleep(3000);

        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg, PropertiesReader.readkey("error_message"));

        logger.info("Ending The testCases of the POM");

    }


    @Description("Verify that valid Creds Suceesfully login")
    @Test
    public void testPositive() throws InterruptedException, IOException {

        logger.info("Starting The testCases of the POM");

        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManagerSelenoid.getDriver());
        loginPagePom.loginToVWOLoginValidCreds(PropertiesReader.readkey("username"), PropertiesReader.readkey("password"));

        Thread.sleep(3000);

        DashboardPage_POM dashboardPagePom = new DashboardPage_POM(DriverManagerSelenoid.getDriver());
        String loggedInUserName = dashboardPagePom.loggedInUserName();

        Thread.sleep(3000);

        assertThat(loggedInUserName).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedInUserName, PropertiesReader.readkey("expected_username"));

        logger.info("Ending The testCases of the POM");
    }
}
// if you have use before method then two browser window open for two tc.
//if you have use before test then one browser window open for two tc.
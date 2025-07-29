package org.example.tests.VWOLogin.PageObjectModel_TestCase;

import org.example.base.Parallel_BaseTest;
import org.example.driver.Parallel_Driver_Manager;
import org.example.pages.PageObjectModel.VWO.DashboardPage_POM;
import org.example.pages.PageObjectModel.VWO.LoginPage_POM;
import io.qameta.allure.Description;
import org.example.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class TestVWOLogin_POM extends Parallel_BaseTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_POM.class);


    //@BeforeMethod
    @Description("Verify that invalid creds give you error message")
    @Test(testName = "test1")
    public void testLoginNegativeVWO() throws InterruptedException {

        logger.info("Starting The Negative testCases of the POM");

        LoginPage_POM loginPagePom = new LoginPage_POM(Parallel_Driver_Manager.getDriver());
        String error_msg = loginPagePom.loginToVWOLoginInvalidCreds(PropertiesReader.readkey("invalid_username"), PropertiesReader.readkey("invalid_password"));

        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg, PropertiesReader.readkey("error_message"));

    }

    @Description("Verify that valid Creds Suceesfully login")
    @Test(testName = "test2")
    public void testPositive() throws InterruptedException, IOException {

        logger.info("Starting The Positive testCases of the POM");

        LoginPage_POM loginPagePom = new LoginPage_POM(Parallel_Driver_Manager.getDriver());
        loginPagePom.loginToVWOLoginValidCreds(PropertiesReader.readkey("username"), PropertiesReader.readkey("password"));

        Thread.sleep(3000);

        DashboardPage_POM dashboardPagePom = new DashboardPage_POM(Parallel_Driver_Manager.getDriver());
        String loggedInUserName = dashboardPagePom.loggedInUserName();
        System.out.println(loggedInUserName);

        Thread.sleep(3000);
        assertThat(loggedInUserName).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedInUserName,PropertiesReader.readkey("expected_username"));

    }
}
// if you have use before method then two browser window open for two tc.
//if you have use before test then one browser window open for two tc.

// mvn clean test  '-Dsurefire.suiteXmlFiles=testngTestVWOLoginPOMparrallel.xml'
//these above command is used to run testcase in terminal.


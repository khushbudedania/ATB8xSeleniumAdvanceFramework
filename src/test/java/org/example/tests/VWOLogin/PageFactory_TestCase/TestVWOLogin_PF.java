package org.example.tests.VWOLogin.PageFactory_TestCase;

import org.example.base.CommonToAllTest;
import org.example.driver.DriverManager;
import org.example.pages.PageFactory.LoginPage_PF;
import org.example.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Test(retryAnalyzer = IRetryAnalyzer.class)//Retry Listener
public class TestVWOLogin_PF extends CommonToAllTest{

        private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF.class);//log4j

        @Test
        public void testLoginNegativeVWO_PF() {

            logger.info("Starting the Testcases Page Factory");


            WebDriver driver = DriverManager.getDriver();
            driver.get(PropertiesReader.readkey("url"));
            LoginPage_PF loginPage_PF = new LoginPage_PF(driver);
            String error_msg = loginPage_PF.loginToVWOInvalidCreds();

            logger.info("End of the Testcase!!");

            Assert.assertEquals(error_msg, PropertiesReader.readkey("error_message"));

        }

    }
//if you change in code then retry listner work.



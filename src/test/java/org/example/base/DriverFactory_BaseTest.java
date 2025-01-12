package org.example.base;

import org.example.driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class DriverFactory_BaseTest {

        @Parameters("browser")
        @BeforeMethod
        public void setUp(String browser) {
            DriverFactory.setDriver(browser);
            DriverFactory.getDriver().manage().window().maximize();
        }

        @AfterMethod
        public void tearDown() {
            DriverFactory.quitDriver();
        }
    }


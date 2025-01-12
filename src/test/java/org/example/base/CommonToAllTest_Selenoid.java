package org.example.base;

import org.example.driver.DriverManagerSelenoid;
import org.testng.annotations.BeforeTest;
import org.example.driver.DriverManager;
import org.example.driver.DriverManagerSelenoid;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CommonToAllTest_Selenoid {

        @BeforeTest
        public static void setup()
        {
            DriverManagerSelenoid.init();
        }

        public static void tearDown()
        {

            DriverManagerSelenoid.down();
        }
    }



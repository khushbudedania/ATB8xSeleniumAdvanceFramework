package org.example.base;

import org.example.driver.DriverManagerTL_ThreadLocal;
import org.example.driver.Parallel_Driver_Manager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Parallel_BaseTest {

        @Parameters("browser")
        @BeforeMethod
        public void setUp(String browser) {
            Parallel_Driver_Manager.setDriver(browser);
            Parallel_Driver_Manager.getDriver().manage().window().maximize();
        }

        @Parameters("browser")
        @AfterMethod
        public void tearDown() {
            Parallel_Driver_Manager.quitDriver();
        }
        }

//    @Parameters("browser")
//    @BeforeMethod
//    public static void init()
//    {
//        Parallel_Driver_Manager.init();
//
//    }
//
//    @Parameters("browser")
//    @AfterMethod
//    public static void down()
//    {
//        Parallel_Driver_Manager.down();
//
//    }
//    }


package org.example.base;

import org.example.driver.DriverManager;
import org.example.driver.DriverManagerSelenoid;
import org.example.driver.DriverManagerTL_ThreadLocal;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CommonToAllTest {


     @BeforeTest
     public static void setup()
     {
         DriverManagerTL_ThreadLocal.init();

     }

     public static void tearDown()
     {
         DriverManagerTL_ThreadLocal.down();

     }
}

package org.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {


        private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

        public static WebDriver getDriver() {
            return tlDriver.get();
        }

        public static void setDriver(String browser) {
            WebDriver driver = null;

            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();  // Add ChromeOptions as needed
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();  // Add FirefoxOptions as needed
            }

            tlDriver.set(driver);
        }

        public static void quitDriver() {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }


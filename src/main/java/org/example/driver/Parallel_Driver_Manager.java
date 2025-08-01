package org.example.driver;

import org.example.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Parallel_Driver_Manager {

        private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

        public static WebDriver getDriver() {
            System.out.println("DriverManager.getDriver(): " + threadLocal.get());
            return threadLocal.get();

        }

        public static void setDriver(String browser) {
            WebDriver driver = null;

            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();  // Add ChromeOptions as needed
            } else if (browser.equalsIgnoreCase("Edge")) {
                driver = new EdgeDriver();  // Add FirefoxOptions as needed
            }

            threadLocal.set(driver);
        }

        public static void quitDriver() {
            threadLocal.get().quit();
            threadLocal.remove();
        }

//    public static WebDriver driver;
//
//
//    public static WebDriver getDriver() {
//        return driver;
//
//    }

//    public static void setDriver(WebDriver driver) {
//        DriverManagerTL_ThreadLocal.driver = driver;
//    }
//
//    // When we want to start the browser
//    public static void init() {
//
//        String browser = PropertiesReader.readkey("browser");
//        browser = browser.toLowerCase();
//        if (driver == null) {
//            switch (browser) {
//                case "edge":
//                    EdgeOptions edgeOptions = new EdgeOptions();
//                    edgeOptions.addArguments("--start-maximized");
//                    edgeOptions.addArguments("--guest");
//                    driver = new EdgeDriver(edgeOptions);
//                    break;
//                case "chrome":
//                    ChromeOptions chromeOptions = new ChromeOptions();
//                    chromeOptions.addArguments("--start-maximized");
//                    driver = new ChromeDriver(chromeOptions);
//                    break;
//                case "firefox":
//                    FirefoxOptions firefoxOptions = new FirefoxOptions();
//                    firefoxOptions.addArguments("--start-maximized");
//                    driver = new FirefoxDriver(firefoxOptions);
//                    break;
//                default:
//                    System.out.println("Not browser Found!!");
//            }
//        }
//    }
//
//
//    // When we want to close the browser
//    public static void down() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//
//   }
}



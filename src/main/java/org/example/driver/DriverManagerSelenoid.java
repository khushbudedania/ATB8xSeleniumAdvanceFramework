package org.example.driver;

import org.example.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


public class DriverManagerSelenoid {
    //upgraded version to support the Multiple parallel testing.
    //In the cloud Grids - browserstack, lambdatest, docker containers local.


        public static WebDriver driver;

        public static WebDriver getDriver() {
            return driver;
        }

        public static void setDriver(WebDriver driver) {
            DriverManagerSelenoid.driver = driver;
        }

        // When we want to start the browser
        public static void init() {

            if (driver == null)
            {
                driver = new ChromeDriver();
                driver.get("https://app.vwo.com");
                ChromeOptions options = new ChromeOptions();

                options.setCapability("selenoid:options", new HashMap<String, Object>() {{
                    /* How to add test badge */
                    put("name", "Test badge...");

                    /* How to set session timeout */
                    put("sessionTimeout", "15m");

                    /* How to set timezone */
                    put("env", new ArrayList<String>() {{
                        add("TZ=UTC");
                    }});

                    /* How to add "trash" button */
                    put("labels", new HashMap<String, Object>() {{
                        put("automation", "true");
                    }});

                    /* How to enable video recording */
                    put("enableVideo", true);
                }});
                try {
                    RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), options);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // When we want to close the browser
        public static void down(){
            if (driver != null) {
                driver.quit();
                driver = null;
            }

        }
}

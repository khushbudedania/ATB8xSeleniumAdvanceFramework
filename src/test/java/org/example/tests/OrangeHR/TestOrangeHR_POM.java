package org.example.tests.OrangeHR;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.base.CommonToAllTest;
import org.example.driver.DriverManager;
import org.example.pages.PageObjectModel.OrangeHR.DashboardPageOHR_POM;
import org.example.pages.PageObjectModel.OrangeHR.LoginPage_OHR_POM;
import org.example.pages.PageObjectModel.VWO.DashboardPage_POM;
import org.example.utils.PropertiesReader;
import org.testng.annotations.Test;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.driver.DriverManager.driver;

public class TestOrangeHR_POM extends CommonToAllTest {


    @Owner("PRAMOD")
    @Description("Verify that the login to the OrangeHR")
    @Test
    public void testLoginPositive()
    {
        LoginPage_OHR_POM loginPage_ohr_pom = new LoginPage_OHR_POM(DriverManager.getDriver());
        loginPage_ohr_pom.loginToOrangeHRValidCreds(PropertiesReader.readkey("ohr_username"),PropertiesReader.readkey("ohr_password"));

        DashboardPageOHR_POM dashboardPageOHR_pom = new DashboardPageOHR_POM(DriverManager.getDriver());
        String loggedInUserName = dashboardPageOHR_pom.loggedInUserName();

        assertThat(loggedInUserName).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedInUserName,PropertiesReader.readkey("ohr_expected_username"));

        driver.quit();
    }
}

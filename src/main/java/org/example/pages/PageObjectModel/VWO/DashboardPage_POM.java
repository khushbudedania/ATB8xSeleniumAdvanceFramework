package org.example.pages.PageObjectModel.VWO;

import org.example.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage_POM extends CommonToAllPage {


    WebDriver driver;

    public DashboardPage_POM(WebDriver driver) {
        this.driver = driver;
    }

    //page Locators
    By usernameonDashboard = By.xpath("//span[text()= \"khushbu zalavadiya\"]");

    //page Action
    public String loggedInUserName()
    {
        //presenceOfElement(usernameonDashboard);
        return driver.findElement(usernameonDashboard).getText();
    }


}

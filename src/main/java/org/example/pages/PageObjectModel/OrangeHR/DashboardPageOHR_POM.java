package org.example.pages.PageObjectModel.OrangeHR;

import org.example.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPageOHR_POM extends CommonToAllPage {

    WebDriver driver;

    public DashboardPageOHR_POM(WebDriver driver) {
        this.driver = driver;
    }

    //page Locators
    By  userNameOnDashboard = By.xpath("//h6[normalize-space()='PIM']");

    //page Action
    public String loggedInUserName()
    {
        presenceOfElement(userNameOnDashboard);
        return getElement(userNameOnDashboard).getText();
    }
}

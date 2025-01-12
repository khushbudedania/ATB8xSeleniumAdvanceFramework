Selenium Automation Framework(with Java)


Java, Selenium, TestNG

Maven, AssertJ, POM

Thread Local Support → Thread Safety

Allure Report

Excel Sheet for Test Data → Data Provider, Apache POI

Read the username and password from Properties-

TestNG, @Test, Before and After Method.

Cloud Grids - BrowserStack, LambdaTest

SonarLint, Java > 22

Run Local and on Selenoid Integration.


*********************

Web Automation Framework |. Selenium  Framework
1. Test Script -> Divided them into the folder Structure.

    1. **main** - dev

        1. base - commonToAll Pages -> This is class which will have all the common pages functionalities
        2. driver -> drivermanager - which will give you the driver
        3. pages
            1. page object model
                1.  pages - loginPage, dashBoardPage, supportPage, freeTrialPages....
            2.Page Factory (Only use non SPA application)  -> 20%
               
        4. Utils
            1. PropertiesReader -> read from the data.properties file and give the values based in the key mentioned
                1. Purpose -> no hard code value in the code.
                2. reusability, maintenance, scalability.
            2. ExcelReader -> which can read from the excel file if we want to to data driven
                1. apache POI for this.
        5. resources Folder
            1. data.properties
            2. log4j.xml
            3. TestData.xlsx

    2. **tests** - test related code
   
        1. base
            1. Common to All Test Code
                1. BeforeMethods, AfterMethod -> setUp and tearDown
        2. tests
            1. Projectswise
                1. vwo
                    1. TestVWOLogin(extends from the CommonToAllTest, We will call the POM Calls and Assertions(TestNG & AssertJ))
                2. orangeHR
           2.pom.xml ->
                1. Dependencies
                2. build config
           3.TestNG xmls
               1. to run the code in QA, Preprod env and Prod.
            4. Readme.MD -> FILE
            5. Upload the framework in the (https://github.com/) 


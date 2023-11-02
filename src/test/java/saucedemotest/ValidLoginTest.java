package saucedemotest;
import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelReader;
import utility.Utility;

import java.io.File;


public class ValidLoginTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(ValidLoginTest.class.getName());
    String username = prop.getProperty("username");
    String password = prop.getProperty("password");
    ExcelReader excelReader = new ExcelReader(Utility.path+ File.separator+"data"+File.separator+"data.xlsx", "Data");

    @Test
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // Enter a valid username and password
        loginPage.typeUsername(username);
        loginPage.typePassword(password);

        // Click the login button
        loginPage.clickOnLoginBtn();

        //Check if the login is successful
        String expectedHeader = excelReader.getCellValueForGivenKey("Home Page Header");
        String actualHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHeader, actualHeader);
        LOG.info("login to saucedemo app success");
    }
}

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

public class InvalidLoginTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(InvalidLoginTest.class.getName());
    String username = prop.getProperty("username");
    String password = prop.getProperty("password");
    ExcelReader excelReader = new ExcelReader(Utility.path+ File.separator+"data"+File.separator+"data.xlsx", "Data");

    @Test
    public void loginWithValidUsernameAndInvalidPassword(){
        LoginPage loginPage = new LoginPage(getDriver());

        String expectedTitle = excelReader.getCellValueForGivenKey("Login Page Title");
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        LOG.info("navigate to saucedemo app success");

        // Enter a valid username and password
        loginPage.typeUsername(username);
        loginPage.typePassword("");

        // Click the login button
        loginPage.clickOnLoginBtn();

        // Check if the login is successful (verify that we are on the inventory page)
        String expectedError = excelReader.getCellValueForGivenKey("Missing Password Error");
        String actualError =  loginPage.getErrorMessage();
        Assert.assertEquals(expectedError, actualError);
        LOG.info("validate error message success");
    }
    @Test
    public void loginWithInvalidUsernameAndValidPassword(){
        LoginPage loginPage = new LoginPage(getDriver());

        String expectedTitle = "Swag Labs";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        LOG.info("navigate to saucedemo app success");

        // Enter a valid username and password
        loginPage.typeUsername("");
        loginPage.typePassword(password);

        // Click the login button
        loginPage.clickOnLoginBtn();

        // Check if the login is successful (verify that we are on the inventory page)
        String expectedError = excelReader.getCellValueForGivenKey("Missing Username Error");
        String actualError =  loginPage.getErrorMessage();
        Assert.assertEquals(expectedError, actualError);
        LOG.info("validate error message success");
    }
}
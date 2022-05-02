package tests;

import io.qameta.allure.Description;
import models.LoginModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pompages.LogInPage;
import testdata.GetLoginModel;
import utilities.PropertiesManager;
import utilities.RetryTests;

public class LogInTest extends BaseTest{
    private static final Logger LOGGER = LogManager.getLogger(LogInTest.class.getName());

    @Test(retryAnalyzer = RetryTests.class)
    @Description("Checking logIn of registered user")
    public void logInOldUserTest(){
        LOGGER.info("logInOldUserTest started" );
        PropertiesManager propertiesManager = new PropertiesManager();
        String username = propertiesManager.get("USERNAME");
        LOGGER.info("username " + propertiesManager.get("USERNAME"));
        String password = propertiesManager.get("PASSWORD");
        LOGGER.info("password " + propertiesManager.get("PASSWORD"));
        LogInPage logInPage = new LogInPage(driver);
        logInPage.loginOldUser(username,password);
        LOGGER.info("User log in to the system");
        Assert.assertEquals(logInPage.profileText(),"Vladislav","Uncorrected profile");
    }
    @Test(retryAnalyzer = RetryTests.class)
    @Description("Checking logIn of user if he hasn't registered yet")
    public void loginWithUnexpectedCredentialsTest(){
        LogInPage logInPage = new LogInPage(driver);
        LOGGER.info("logInOldUserTest started" );
        LoginModel getLoginModel = GetLoginModel.getLoginWithAllFields();
        logInPage.loginAnyUser(getLoginModel);
        LOGGER.info(" User log in with credentials " + getLoginModel );
        Assert.assertEquals(logInPage.ErrorMessage(),"Invalid login credentials. Please try again.","Unexpected message");
    }
}

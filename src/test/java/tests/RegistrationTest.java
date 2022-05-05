package tests;

import io.qameta.allure.Description;
import models.RegistrationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pompages.RegistrationPage;
import testdata.GetRegistrationModel;
import utilities.RetryTests;

public class RegistrationTest extends BaseTest{
    private static final Logger LOGGER = LogManager.getLogger(RegistrationTest.class.getName());
    @Test(retryAnalyzer = RetryTests.class, priority = 1,description = "Test checks that user created and login")
    @Description("Checking registration user in the system")
    public void registrationNewUserTest(){
        LOGGER.info("registrationNewUserTest started" );
        RegistrationPage registrationPage = new RegistrationPage(driver);
        RegistrationModel getFields = GetRegistrationModel.registrationModelWithAllFields();
        String name = getFields.getFirstname();
        registrationPage.createNewUser(getFields);
        LOGGER.info("User registrated and log to rhe system " + getFields);
        Assert.assertEquals(name,registrationPage.profileText(),"No such user");
    }
}

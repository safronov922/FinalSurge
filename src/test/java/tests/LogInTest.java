package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pompages.LogInPage;

public class LogInTest extends BaseTest{
    private static final  String EMAIL ="safronov92@mail.com";
    private static final String PASSWORD= "Safronov21";
    @Test
    public void logInOldUserTest(){
        LogInPage logInPage = new LogInPage(driver);
        logInPage.loginOldUser(EMAIL,PASSWORD);
        Assert.assertEquals(logInPage.profileText(),"Vladislav","Uncorrected profile");
    }
    @Test
    public void loginWithUnexpectedCredentialsTest(){
        LogInPage logInPage = new LogInPage(driver);
        logInPage.loginOldUser("test@test.com","qwerty123");
        Assert.assertEquals(logInPage.ErrorMessage(),"Invalid login credentials. Please try again.","Unexpected message");
    }
}

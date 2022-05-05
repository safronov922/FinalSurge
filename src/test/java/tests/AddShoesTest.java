package tests;

import io.qameta.allure.Description;
import models.ShoeModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pompages.LogInPage;
import pompages.ShoePage;
import testdata.GetShoesModel;
import utilities.PropertiesManager;
import utilities.RetryTests;

public class AddShoesTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(LogInTest.class.getName());

    @Test(retryAnalyzer = RetryTests.class)
    @Description("Adding new shoe at the tracker")
    public void addDailyVitalsTest() {
        LOGGER.info("addDailyVitalsTest started");
        PropertiesManager propertiesManager = new PropertiesManager();
        String username = propertiesManager.get("USERNAME");
        LOGGER.info("username " + propertiesManager.get("USERNAME"));
        String password = propertiesManager.get("PASSWORD");
        LOGGER.info("password " + propertiesManager.get("PASSWORD"));
        LogInPage logInPage = new LogInPage(driver);
        logInPage.loginOldUser(username, password);
        LOGGER.info("User log in to the system");
        ShoePage shoePage = new ShoePage(driver);
        ShoeModel fields = GetShoesModel.addShoesData();
        shoePage.addFields(fields);
        LOGGER.info("Shoe of user add to the tracker");
        Assert.assertEquals(shoePage.textOfAddShoe(),fields.getShoeName(),"Shoe don't edit");
        shoePage.deleteShoe();
        LOGGER.info("Shoe delete from the tracker");
    }
}

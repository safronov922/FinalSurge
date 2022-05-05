package tests;

import io.qameta.allure.Description;
import models.VitalsModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pompages.DailyVitals;
import pompages.LogInPage;
import testdata.GetVitalModel;
import utilities.PropertiesManager;
import utilities.RetryTests;

public class AddVitalsTest extends BaseTest{
    private static final Logger LOGGER = LogManager.getLogger(LogInTest.class.getName());
    @Test(retryAnalyzer = RetryTests.class)
    @Description("Adding new vitals at the system")
    public void addDailyVitalsTest(){
        LOGGER.info("addDailyVitalsTest started" );
        PropertiesManager propertiesManager = new PropertiesManager();
        String username = propertiesManager.get("USERNAME");
        LOGGER.info("username " + propertiesManager.get("USERNAME"));
        String password = propertiesManager.get("PASSWORD");
        LOGGER.info("password " + propertiesManager.get("PASSWORD"));
        LogInPage logInPage = new LogInPage(driver);
        logInPage.loginOldUser(username,password);
        LOGGER.info("User log in to the system");
        DailyVitals dailyVitals= new DailyVitals(driver);
        VitalsModel model = GetVitalModel.addVitalsFields();
        dailyVitals.addDailyVitals(model);
        LOGGER.info("DailyVitals add to the tracker: " + model);
        int steps = model.getSteps();
        Assert.assertEquals(dailyVitals.getStepsText(),steps,"Steps don't find");
    }
}

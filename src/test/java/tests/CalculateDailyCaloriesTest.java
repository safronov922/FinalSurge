package tests;

import io.qameta.allure.Description;
import models.VitalsModel;
import models.WorkoutModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pompages.DailyCaloriesCalculator;
import pompages.LogInPage;
import pompages.WorkoutCalculatorPage;
import testdata.GetWorkoutModel;
import utilities.FakerGenerator;
import utilities.PropertiesManager;
import utilities.RetryTests;

public class CalculateDailyCaloriesTest extends BaseTest{
    private static final Logger LOGGER = LogManager.getLogger(CalculateDailyCaloriesTest.class.getName());

    @Test(retryAnalyzer = RetryTests.class, priority = 1,description = "Test checks that daily calories calculated")
    @Description("Checking calculator of daily calories")
    public void addDailyCaloriesTest() {
        LOGGER.info("addDailyCaloriesTest");
        PropertiesManager propertiesManager = new PropertiesManager();
        String username = propertiesManager.get("USERNAME");
        LOGGER.info("username " + propertiesManager.get("USERNAME"));
        String password = propertiesManager.get("PASSWORD");
        LOGGER.info("password " + propertiesManager.get("PASSWORD"));
        LogInPage logInPage = new LogInPage(driver);
        logInPage.loginOldUser(username, password);
        LOGGER.info("User log in to the system");
        DailyCaloriesCalculator dailyCaloriesCalculator = new DailyCaloriesCalculator(driver);
        WorkoutModel model = GetWorkoutModel.allFieldsInputs();
        dailyCaloriesCalculator.addCaloriesValues(model);
        LOGGER.info("Calculation of user values");
        Assert.assertTrue(dailyCaloriesCalculator.getCaloriesResult(), "Pace don't displayed");
    }
}

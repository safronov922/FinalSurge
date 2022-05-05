package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pompages.LogInPage;
import pompages.WorkoutCalculatorPage;
import utilities.FakerGenerator;
import utilities.PropertiesManager;
import utilities.RetryTests;

public class CalculatePacesTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(LogInTest.class.getName());

    @Test(retryAnalyzer = RetryTests.class)
    @Description("Checking calculation of paces needs")
    public void calculatePacesTest() {
        LOGGER.info("calculatePacesTest started");
        PropertiesManager propertiesManager = new PropertiesManager();
        String username = propertiesManager.get("USERNAME");
        LOGGER.info("username " + propertiesManager.get("USERNAME"));
        String password = propertiesManager.get("PASSWORD");
        LOGGER.info("password " + propertiesManager.get("PASSWORD"));
        LogInPage logInPage = new LogInPage(driver);
        logInPage.loginOldUser(username, password);
        LOGGER.info("User log in to the system");
        WorkoutCalculatorPage workoutCalculatorPage = new WorkoutCalculatorPage(driver);
        workoutCalculatorPage.addWorkoutIntensity(FakerGenerator.getTime(), FakerGenerator.getTime());
        LOGGER.info("Calculation of added parameters");
        Assert.assertTrue(workoutCalculatorPage.getWorkoutPace(), "Page don't displayed");
    }
}

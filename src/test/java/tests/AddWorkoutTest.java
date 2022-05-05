package tests;

import io.qameta.allure.Description;
import models.WorkoutModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pompages.LogInPage;
import pompages.MainPage;
import pompages.WorkoutPage;
import testdata.GetWorkoutModel;
import utilities.PropertiesManager;
import utilities.RetryTests;

public class AddWorkoutTest extends BaseTest{
    private static final Logger LOGGER = LogManager.getLogger(AddWorkoutTest.class.getName());

    @Test(retryAnalyzer = RetryTests.class, priority = 1,description = "Test checks that workout was added")
    @Description("Adding new workout at the system")
    public void addWorkoutTest(){
        LOGGER.info("addWorkoutTest started" );
        PropertiesManager propertiesManager = new PropertiesManager();
        String username = propertiesManager.get("USERNAME");
        LOGGER.info("username " + propertiesManager.get("USERNAME"));
        String password = propertiesManager.get("PASSWORD");
        LOGGER.info("password " + propertiesManager.get("PASSWORD"));
        LogInPage logInPage = new LogInPage(driver);
        logInPage.loginOldUser(username,password);
        LOGGER.info("User log in to the system");
        MainPage mainPage = new MainPage(driver);
        LOGGER.info("Open workout Tab");
        mainPage.openWorkoutTab();
        WorkoutPage workoutPage = new WorkoutPage(driver);
        WorkoutModel workout = GetWorkoutModel.allFieldsInputs();
        workoutPage.addNewWorkout(workout);
        LOGGER.info("Add new workout with parameters: " + workout);
        Assert.assertTrue(workoutPage.displayedWindow(),"New workout don't created");
    }

}

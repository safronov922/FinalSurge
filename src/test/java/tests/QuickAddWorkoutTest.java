package tests;

import io.qameta.allure.Description;
import models.WorkoutModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pompages.CalendarPage;
import pompages.LogInPage;
import pompages.MainPage;
import testdata.GetWorkoutModel;
import utilities.PropertiesManager;
import utilities.RetryTests;

public class QuickAddWorkoutTest extends BaseTest{
    private static final Logger LOGGER = LogManager.getLogger(QuickAddWorkoutTest.class.getName());

    @Test(retryAnalyzer = RetryTests.class, priority = 1,description = "Test checks that workout added")
    @Description("Adding new workout to calendar with quick function")
    public void addQuickWorkoutTest(){
        LOGGER.info("addQuickWorkoutTest started" );
        PropertiesManager propertiesManager = new PropertiesManager();
        String username = propertiesManager.get("USERNAME");
        LOGGER.info("username " + propertiesManager.get("USERNAME"));
        String password = propertiesManager.get("PASSWORD");
        LOGGER.info("password " + propertiesManager.get("PASSWORD"));
        LogInPage logInPage = new LogInPage(driver);
        logInPage.loginOldUser(username,password);
        LOGGER.info("User log in to the system");
        MainPage mainPage = new MainPage(driver);
        LOGGER.info("Open calendar Tab");
        mainPage.openCalendarTab();
        CalendarPage calendarPage = new CalendarPage(driver);
        WorkoutModel workoutModel= GetWorkoutModel.allFieldsInputs();
        calendarPage.addAllFields(workoutModel);
        LOGGER.info("Add new workout with parameters: " + workoutModel);
        Assert.assertEquals(calendarPage.getText(),"Run - Recovery Run: Principal Paradigm Architect", "Activity don't add");
    }
}

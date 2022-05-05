package pompages;

import elements.WorkoutInputs;
import io.qameta.allure.Step;
import models.WorkoutModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarPage extends BasePage{
    private By ADD_BUTTON = By.id("QuickAddToggle");
    private By PACE_DROPDOWN =By.id("PaceType");
    private By WORKOUT_NAME= By.id("Name");
    private By WORKOUT_DESCRIPTION = By.id("Desc");
    private By ACTIVITY_TYPE = By.id("ActivityType");
    private By MOOD = By.xpath("//select[@id='HowFeel']//option[3]");
    private By EFFORT = By.xpath("//select[@id='PerEffort']//option[6]");
    private By SAVE_BUTTON = By.id("saveButton");
    private By CALENDAR_TEXT = By.xpath("//div[contains(text(),'Recovery')][last()]");


    public CalendarPage(WebDriver driver) {
        super(driver);
    }
    @Step("Add all fields to calculator and convert result")
    public void addAllFields(WorkoutModel workoutModel){
        driver.findElement(ADD_BUTTON).click();
        Select select = new Select(driver.findElement(ACTIVITY_TYPE));
        select.selectByIndex(7);
        driver.findElement(WORKOUT_NAME).sendKeys(workoutModel.getWorkoutName());
        driver.findElement(WORKOUT_DESCRIPTION).sendKeys(workoutModel.getWorkoutDescription());
        new WorkoutInputs(driver,"Distance").inputNumbers(workoutModel.getDistance());
        new WorkoutInputs(driver,"Duration").inputText(workoutModel.getDuration());
        Select select2 = new Select(driver.findElement(PACE_DROPDOWN));
        select2.selectByIndex(3);
        new WorkoutInputs(driver,"Pace").inputNumbers(workoutModel.getPace());
        driver.findElement(MOOD).click();
        driver.findElement(EFFORT).click();
        driver.findElement(SAVE_BUTTON).click();
    }
    public String getText(){
        return driver.findElement(CALENDAR_TEXT).getText();
}
}

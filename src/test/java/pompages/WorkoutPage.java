package pompages;

import elements.WorkoutInputs;
import io.qameta.allure.Step;
import models.WorkoutModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class WorkoutPage extends BasePage{
    private By RUN_BUTTON = By.xpath("//div[@class='accordion-heading']//a");
    private By TYPE_OF_RUN_TAB = By.xpath("//div[@class='accordion-inner']//a[contains(text(),'Hills')]");
    private By ADD_WORKOUT_BUTTON = By.id("saveButton");
    private By HEALS_TYPE = By.id("hf_great");
    private By PERCEIVED_EFFORT= By.xpath("//select[@name='PerEffort']//option[contains(., '9 (Very Hard)')]");
    private By WORKOUT_NAME= By.id("Name");
    private By WORKOUT_DESCRIPTION = By.id("Desc");
    private By NEW_WORKOUT_WINDOW = By.xpath("//h4[contains(text(),'Workout Details')]");
    private By PACE_DROPDOWN =By.id("PaceType");


    public WorkoutPage(WebDriver driver) {
        super(driver);
    }
    @Step("Add Workout in calendar")
    public void addNewWorkout(WorkoutModel workoutModel){
        driver.findElement(RUN_BUTTON).click();
        driver.findElement(TYPE_OF_RUN_TAB).click();
        driver.findElement(WORKOUT_NAME).sendKeys(workoutModel.getWorkoutName());
        driver.findElement(WORKOUT_DESCRIPTION).sendKeys(workoutModel.getWorkoutDescription());
        new WorkoutInputs(driver,"Distance").inputNumbers(workoutModel.getDistance());
        new WorkoutInputs(driver,"Duration").inputText(workoutModel.getDuration());
        Select select = new Select(driver.findElement(PACE_DROPDOWN));
        select.selectByIndex(3);
        new WorkoutInputs(driver,"Pace").inputNumbers(workoutModel.getPace());
        new WorkoutInputs(driver,"MinHR").inputNumbers(workoutModel.getMinHr());
        new WorkoutInputs(driver,"AvgHR").inputNumbers(workoutModel.getAvgHr());
        new WorkoutInputs(driver,"MaxHR").inputNumbers(workoutModel.getMaxHr());
        new WorkoutInputs(driver,"kCal").inputNumbers(workoutModel.getCalories());
        driver.findElement(HEALS_TYPE).click();
        driver.findElement(PERCEIVED_EFFORT).click();
        driver.findElement(ADD_WORKOUT_BUTTON).click();
    }
    public boolean displayedWindow(){
       return driver.findElement(NEW_WORKOUT_WINDOW).isDisplayed();
    }
}

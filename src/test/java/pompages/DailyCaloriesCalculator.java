package pompages;

import io.qameta.allure.Step;
import models.VitalsModel;
import models.WorkoutModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DailyCaloriesCalculator extends BasePage{
    private By CALCULATE_BUTTON = By.id("saveButtonSettings");
    private By GENDER= By.id("optionsRadios5");
    private By WEIGHT = By.id("Weight");
    private By HEIGHT = By.id("HeightInchCent");
    private By AGE = By.id("Age");
    private By DISTANCE = By.id("RunDist");
    private By WORKOUT_PACES = By.xpath("//h4[contains(text(),'Today')]");
    private By IFRAME = By.id("OtherCalciFrame");

    public DailyCaloriesCalculator(WebDriver driver) {
        super(driver);
    }
    @Step("Add all fields to  calories calculator and convert result")
    public void addCaloriesValues(WorkoutModel workoutModel){
        MainPage mainPage = new MainPage(driver);
        mainPage.openCaloriesCalculatorTab();
        driver.switchTo().frame(driver.findElement(IFRAME));
        driver.findElement(HEIGHT).sendKeys(workoutModel.getHeight());
        driver.findElement(WEIGHT).sendKeys(workoutModel.getWeight());
        driver.findElement(AGE).sendKeys(workoutModel.getAge());
        driver.findElement(DISTANCE).sendKeys(workoutModel.getRunDistance());
        driver.findElement(GENDER).click();
        driver.findElement(CALCULATE_BUTTON).click();
    }
    public boolean getCaloriesResult(){
        return driver.findElement(WORKOUT_PACES).isDisplayed();
    }
}

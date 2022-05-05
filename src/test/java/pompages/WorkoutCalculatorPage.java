package pompages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class WorkoutCalculatorPage extends BasePage{
    private By CALCULATE_BUTTON = By.id("saveButtonSettings");
    private By EVENT= By.xpath("//input[@value='MILE']");
    private By MINUTES = By.id("TimeMM");
    private By SECONDS = By.id("TimeSS");
    private By WORKOUT_PACES = By.xpath("//h4[contains(text(),'Your Workout Paces')]");
    private By IFRAME = By.id("IntensityCalciFrame");
    public WorkoutCalculatorPage(WebDriver driver) {
        super(driver);
    }
    @Step("Add all fields of Workout Intensity and calculate result")
    public void addWorkoutIntensity(String minutes,String seconds){
        MainPage mainPage = new MainPage(driver);
        mainPage.openWorkoutCalculatorTab();
        driver.switchTo().frame(driver.findElement(IFRAME));
        driver.findElement(MINUTES).sendKeys(minutes);
        driver.findElement(SECONDS).sendKeys(seconds);
        driver.findElement(EVENT).click();
        driver.findElement(CALCULATE_BUTTON).click();
    }
    public boolean getWorkoutPace(){
        return driver.findElement(WORKOUT_PACES).isDisplayed();
    }
}

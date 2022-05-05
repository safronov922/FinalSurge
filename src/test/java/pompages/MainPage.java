package pompages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends BasePage{

    private By ADD_VITALS_TAB = By.xpath("//a[contains (text(),'View & Add Vitals')]");
    private By DAILY_VITALS_TAB = By.xpath("//a[contains (text(),'Daily Vitals')]");
    private By WORKOUT_TAB = By.xpath("//a[contains (text(),'Workouts')]");
    private By ADD_WORKOUT_TAB = By.xpath("//a[contains (text(),'Add Workout')]");
    private By GEAR_TAB = By.xpath("//a[contains (text(),'Gear & Routes')]");
    private By SHOES_TAB = By.xpath("//a[contains (text(),'Shoes')]");
    private By CALENDAR_TAB = By.xpath("(//nav[@class='nav-icons'])//li[2]//a");
    private By WORKOUT_CALCULATOR_TAB = By.xpath("(//nav[@class='nav-icons'])//li[3]//a");
    private By CALORIES_CALCULATOR_TAB = By.xpath("(//nav[@class='nav-icons'])//li[4]//a");



    public MainPage(WebDriver driver) {
        super(driver);
    }
    @Step("Open workout Tab")
    public void openWorkoutTab(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(WORKOUT_TAB)).perform();
        driver.findElement(ADD_WORKOUT_TAB).click();
    }
    @Step("Open DailyVitals Tab")
    public void openDailyVitalsTab(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(DAILY_VITALS_TAB)).perform();
        driver.findElement(ADD_VITALS_TAB).click();
    }
    @Step("Open Shoe Tab")
    public void openShoeTab(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(GEAR_TAB)).perform();
        driver.findElement(SHOES_TAB).click();
    }
    @Step("Open Calendar Tab")
    public void openCalendarTab(){
        driver.findElement(CALENDAR_TAB).click();
    }
    @Step("Open Workout Calculator Tab")
    public void openWorkoutCalculatorTab(){
        driver.findElement(WORKOUT_CALCULATOR_TAB).click();
    }
    @Step("Open Calories Calculator Tab")
    public void openCaloriesCalculatorTab(){
        driver.findElement(CALORIES_CALCULATOR_TAB).click();
    }
}

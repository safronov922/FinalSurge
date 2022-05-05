package pompages;

import elements.VitalElements;
import io.qameta.allure.Step;
import lombok.EqualsAndHashCode;
import models.VitalsModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

@EqualsAndHashCode
public class DailyVitals extends BasePage{
    private By ADD_VITALS_BUTTON = By.xpath("//button[@title='Add Vitals']");
    private By SAVE_BUTTON = By.id("saveButton");
    private By HEALTH_NOTES = By.id("HealthNotes");
    private By SLEEP_AMOUNT_DROPDOWN= By.id("SleepAmount");
    private By SLEEP_QUALITY_DROPDOWN= By.id("SleepQuality");
    private By STRESS_AMOUNT_DROPDOWN= By.id("Stress");
    private By CANCEL_BUTTON = By.xpath("//button[@title='Cancel Add']");
    private By STEPS = By.xpath("(//tr//a[contains(text(),'5/4/2022')]//ancestor::tr//td)[2]");

    public DailyVitals(WebDriver driver) {
        super(driver);
    }
    @Step("Add all fields to Daily Vitals and add result to calendar")
    public void addDailyVitals(VitalsModel vitalsModel){
        MainPage mainPage = new MainPage(driver);
        mainPage.openDailyVitalsTab();
        driver.findElement(ADD_VITALS_BUTTON).click();
        new VitalElements(driver,"VitalsDate").inputText(vitalsModel.getDate());
        new VitalElements(driver,"Steps").inputNumbers(vitalsModel.getSteps());
        new VitalElements(driver,"Calories").inputNumbers(vitalsModel.getCaloriesConsumed());
        new VitalElements(driver,"Weight").inputNumbers(vitalsModel.getWeight());
        new VitalElements(driver,"BodyFat").inputNumbers(vitalsModel.getBodyFat());
        new VitalElements(driver,"MuscleMass").inputNumbers(vitalsModel.getMuscleMass());
        new VitalElements(driver,"WaterPercent").inputNumbers(vitalsModel.getWater());
        new VitalElements(driver,"RestHR").inputNumbers(vitalsModel.getRestingHr());
        new VitalElements(driver,"HRVar").inputNumbers(vitalsModel.getHrVariability());
        new VitalElements(driver,"SleepHours").inputNumbers(vitalsModel.getSleepHours());
        new VitalElements(driver,"AwakeTime").inputNumbers(vitalsModel.getTotalTimeAwake());
        new VitalElements(driver,"Systolic").inputNumbers(vitalsModel.getBloodPressure());
        driver.findElement(HEALTH_NOTES).sendKeys(vitalsModel.getHealthNotes());
        Select select = new Select(driver.findElement(SLEEP_AMOUNT_DROPDOWN));
        select.selectByIndex(3);
        Select select2 = new Select(driver.findElement(SLEEP_QUALITY_DROPDOWN));
        select2.selectByIndex(2);
        Select select3 = new Select(driver.findElement(STRESS_AMOUNT_DROPDOWN));
        select3.selectByIndex(2);
        driver.findElement(SAVE_BUTTON).click();
        driver.findElement(CANCEL_BUTTON).click();
    }
    public int getStepsText(){
        return Integer.parseInt(driver.findElement(STEPS).getText());
    }
}

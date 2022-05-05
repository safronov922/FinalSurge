package pompages;

import io.qameta.allure.Step;
import models.ShoeModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.GetShoesModel;

public class ShoePage extends BasePage{
    private By ADD_BUTTON= By.id("saveButton");
    public By SELECTOR = By.xpath("//span[contains(text(),'Select Brand...')]//parent::a");
    private By BRAND = By.xpath("//div[contains(text(),'Avia')]");
    public By SIZE = By.xpath("//option[contains(text(),'17.5')]");
    private By SHOE_NAME= By.id("ShoeName");
    private By MODEL = By.id("ShoeModel");
    private By COST = By.id("ShoeCost");
    private By DATE = By.id("ShoeDate");
    private By NOTES = By.id("ShoeNotes");
    private By SHOE_TEXT = By.xpath("//div//tr//strong//a");
    private By EDIT_BUTTON = By.xpath("//div//a[@title='Edit']");
    private By DELETE_SHOE = By.id("del-shoe2");
    private By OK_BUTTON = By.xpath("//a[contains(text(),'OK')]");
    public ShoePage(WebDriver driver) {
        super(driver);
    }
    @Step("Add new Shoe to tracker")
    public void addFields(ShoeModel shoeModel){
        MainPage mainPage = new MainPage(driver);
        mainPage.openShoeTab();
        driver.findElement(SHOE_NAME).sendKeys(shoeModel.getShoeName());
        driver.findElement(MODEL).sendKeys(shoeModel.getModel());
        driver.findElement(COST).sendKeys(shoeModel.getCost());
        driver.findElement(DATE).sendKeys(shoeModel.getData());
        driver.findElement(NOTES).sendKeys(shoeModel.getNotes());
        driver.findElement(SELECTOR).click();
        driver.findElement(SHOE_NAME).click();
        driver.findElement(SIZE).click();
        driver.findElement(ADD_BUTTON).click();
    }
    public String textOfAddShoe(){
        return driver.findElement(SHOE_TEXT).getText();
    }
    public void deleteShoe(){
        driver.findElement(EDIT_BUTTON).click();
        driver.findElement(DELETE_SHOE).click();
        driver.findElement(OK_BUTTON).click();
    }
}

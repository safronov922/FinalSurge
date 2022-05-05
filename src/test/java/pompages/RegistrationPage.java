package pompages;

import io.qameta.allure.Step;
import models.RegistrationModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.WebUrls;

public class RegistrationPage extends BasePage{
    private By FIRST_NAME_INPUT = By.id("create_first");
    private By LAST_NAME_INPUT = By.id("create_last");
    private By EMAIL_INPUT = By.id("create_email");
    private By PASSWORD_INPUT = By.id("password_meter");
    private By CONFIRM_PASSWORD_INPUT= By.id("create_passwordmatch");
    private By CREATE_BUTTON = By.xpath("//div//button");
    private By USER_INFO = By.xpath("//div[@class='user-info']//strong");


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    @Step("Registration new user in the system")
    public void createNewUser(RegistrationModel registrationModel){
        driver.get(WebUrls.LOG_IN_URL);
        LogInPage logInPage = new LogInPage(driver);
        logInPage.openRegistrationPage();
        driver.findElement(FIRST_NAME_INPUT).sendKeys(registrationModel.getFirstname());
        driver.findElement(LAST_NAME_INPUT).sendKeys(registrationModel.getLastname());
        driver.findElement(EMAIL_INPUT).sendKeys(registrationModel.getEmail());
        driver.findElement(PASSWORD_INPUT).sendKeys(registrationModel.getPassword());
        driver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(registrationModel.getConfirmPassword());
        driver.findElement(CREATE_BUTTON).click();
    }
    public String profileText(){
        return driver.findElement(USER_INFO).getText();
    }
}

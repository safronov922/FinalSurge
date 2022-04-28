package pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.WebUrls;

public class LogInPage extends BasePage{
    private By LOGIN_INPUT = By.id("login_name");
    private By PASSWORD_INPUT = By.id("login_password");
    private By LOGIN_BUTTON = By.xpath("//div[@class='submit_sect']//button");
    private By REGISTRATION_BUTTON = By.xpath("//div[@class='signup']//a");
    private By USER_INFO = By.xpath("//div[@class='user-info']//strong");
    private By INVALID_CREDENTIALS = By.xpath("//div[@class='alert alert-error']//strong");

    public LogInPage(WebDriver driver) {
        super(driver);
    }
    public void loginOldUser(String email, String password){
        driver.get(WebUrls.LOG_IN_URL);
        driver.findElement(LOGIN_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }
    public String profileText(){
       return driver.findElement(USER_INFO).getText();
    }
    public String ErrorMessage(){
        return driver.findElement(INVALID_CREDENTIALS).getText();
    }

}

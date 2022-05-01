package tests;

import factotydriver.DriverFactory;
import factotydriver.DriverManager;
import factotydriver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.TestListeners;

@Listeners(TestListeners.class)
public class BaseTest {
    WebDriver driver;
    DriverManager driverManager;
    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser){
        DriverFactory driverFactory = new DriverFactory();
        DriverType driverType = null;
        if(browser.equals("chrome")){
            driverType = driverType.CHROME;
        } else if (browser.equals("edge")){
            driverType = driverType.EDGE;
        } else if (browser.equals("firefox")){
            driverType = driverType.FIREFOX;
        }
        driverManager = driverFactory.getManager(driverType);
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driverManager.setTimeout();
        driverManager.maximize();
    }
    public WebDriver getDriver(){
        return driver;
    }
    @AfterMethod
    public void tearDown(){
        driverManager.quitDriver();
    }
}

package tests;

import factotydriver.DriverFactory;
import factotydriver.DriverManager;
import factotydriver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
    DriverManager driverManager;
    @BeforeMethod
    public void setUp(){
        DriverFactory driverFactory = new DriverFactory();
        driverManager = driverFactory.getManager(DriverType.CHROME);
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driverManager.setTimeout();
        driverManager.maximize();
    }
    @AfterMethod
    public void tearDown(){
        driverManager.quitDriver();
    }
}

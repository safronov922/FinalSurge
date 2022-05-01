package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test " + iTestResult.getName() + " started");

    }


    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object currentClass =iTestResult.getInstance();
        WebDriver driver =((BaseTest)currentClass).getDriver();
        AllureService allureService = new AllureService();
        allureService.takeScreenshot(driver);
    }
}

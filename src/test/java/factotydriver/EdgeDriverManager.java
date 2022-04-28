package factotydriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EdgeDriverManager extends DriverManager{
    @Override
    public void createDriver() {
        WebDriverManager.edgedriver().setup();
        driver = new FirefoxDriver();

    }
}

package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkoutInputs {
    WebDriver driver;
    String label;
    String input = "//input[@name='%s']";

    public WorkoutInputs(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }
    public String inputText (String text){
        input = String.format(input,label);
        driver.findElement(By.xpath(input)).sendKeys(text);
        return text;
    }

    public void inputNumbers(Integer number){
        input = String.format(input,label);
        driver.findElement(By.xpath(input)).sendKeys(String.valueOf(number));
    }
}

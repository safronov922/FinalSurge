package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VitalElements {
    WebDriver driver;
    String label;
    String input = "//input[@name='%s']";

    public VitalElements(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void inputText (String text){
        input = String.format(input,label);
        driver.findElement(By.xpath(input)).sendKeys(text);
    }

    public void inputNumbers(Integer number){
        input = String.format(input,label);
        driver.findElement(By.xpath(input)).sendKeys(String.valueOf(number));

    }
}
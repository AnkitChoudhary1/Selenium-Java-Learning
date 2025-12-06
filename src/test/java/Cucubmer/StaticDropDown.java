package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class StaticDropDown {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        // 2. Identify the dropdown element (Look for <select> tag)
        WebElement dropDown =driver.findElement(By.xpath("//*[@class=\"valid\"]"));
        // 3. Wrap the WebElement inside the Select class
        Select drop = new Select(dropDown);





    }
}

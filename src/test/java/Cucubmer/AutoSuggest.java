package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggest {
    public static void main(String[] arg) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        // 1. Locate the box and type "Ind"
       // driver.findElement(By.xpath("//*[@placeholder='Type to Select']")).click();
        driver.findElement(By.xpath("//*[@placeholder='Type to Select']")).sendKeys("ind");

        Thread.sleep(3000);
        // 3. Grab all options using findElements (Plural!)
        // The CSS selector usually targets the generic list items 'li' or 'a' tags
        List<WebElement> options = driver.findElements(By.xpath("//*[@class='ui-menu-item']"));

        for(WebElement option : options){
            if(option.getText().equalsIgnoreCase("india")){
                option.click();
            }
        }
        System.out.println("The click was a success ");
        String value = driver.findElement(By.xpath("//*[@id='autosuggest']")).getDomProperty("value");
        System.out.println("The value is = "+value);




    }
}

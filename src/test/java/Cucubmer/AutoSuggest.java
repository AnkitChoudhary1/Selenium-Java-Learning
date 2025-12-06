package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggest {
    public static void main(String[] arg) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        // 1. Locate the box and type "Ind"
       // driver.findElement(By.xpath("//*[@placeholder='Type to Select']")).click();
        driver.findElement(By.xpath("//*[@placeholder='Type to Select']")).sendKeys("ind");

        Thread.sleep(2000);

    }
}

package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String name ="Ankit";
        driver.findElement(By.xpath("//*[@placeholder='Enter Your Name']")).sendKeys("Ankit");
        driver.findElement(By.xpath("//*[@value='Alert']")).click();
    }
}

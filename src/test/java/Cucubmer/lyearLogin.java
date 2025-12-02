package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class lyearLogin {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://meet-qa.lyearn.com/");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[text()='Continue with Email']")).click();
        driver.findElement(By.xpath("//*[@placeholder='Enter your email']")).sendKeys("dev@lyearn.com");
        driver.findElement(By.xpath("//*[@placeholder='Enter your password']")).sendKeys("play@1234");
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
        Thread.sleep(4000);
        driver.quit();
    }
}

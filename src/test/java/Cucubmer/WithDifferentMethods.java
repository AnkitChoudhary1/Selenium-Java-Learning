package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WithDifferentMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        login(driver,"standard_user", "secret_sauce");
        if(driver.getCurrentUrl().contains("inventory"))
        {
            System.out.println("This login is successful :Tick✅");
        }
        else{
            System.out.println("Not correct");
        }
        //Was this added or not in the repo
        driver.quit();

    }

    public static void login(WebDriver driver,String userName, String password) throws InterruptedException {
        driver.findElement(By.cssSelector("input[name='user-name']")).sendKeys(userName);
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(2000);


    }
}

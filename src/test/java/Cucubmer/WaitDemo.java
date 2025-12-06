package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitDemo {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. IMPLICIT WAIT (Global Wait)
        // Defines a max timeout for finding elements. If found earlier, it proceeds.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        driver.findElement(By.xpath("//*[text()=\"Cucumber - 1 Kg\"]//parent::div//*[text()=\"ADD TO CART\"]")).click();
        driver.findElement(By.xpath("//*[@alt='Cart']")).click();
        driver.findElement(By.xpath("//*[text()='PROCEED TO CHECKOUT']")).click();

        driver.findElement(By.xpath("//*[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//*[@class='promoBtn']")).click();

        // 2. EXPLICIT WAIT (Targeted Wait)
        // We need to wait specifically for the "Code Applied" text or loading icon
        // -----------------------------------------------------

        // Define the waiter
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Wait until the "Promo Info" element is VISIBLE
      //  w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

        driver.quit();



    }
}

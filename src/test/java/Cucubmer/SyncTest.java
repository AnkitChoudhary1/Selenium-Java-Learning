package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SyncTest {
    public static void main(String[] args ){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        // 1. Add 'Cucumber' to cart
        // We use xpath text search here for simplicity
        driver.findElement(By.xpath("//h4[contains(text(),'Cucumber')]/parent::div//button")).click();

        // 2. Click on Cart icon and Proceed to Checkout
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        // 3. Enter Promo Code
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        // 4. Verify Promo Info
        // Without the implicit wait defined at the top, this line would fail immediately
        // because the text takes a few seconds to generate.
        String promoInfo = driver.findElement(By.cssSelector("span.promoInfo")).getText();
        System.out.println(promoInfo);

        driver.quit(); // Use quit() to close all associated windows
    }
}

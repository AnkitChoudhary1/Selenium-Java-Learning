package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitTest {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        // 1. Add item and go to checkout (Quick steps)
        driver.findElement(By.xpath("//h4[contains(text(),'Cucumber')]/parent::div//button")).click();
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        // 2. Define the Explicit Wait Object (Target specific)
        // We are creating a "waiter" that watches for up to 5 seconds
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='promoCode']")));

        driver.findElement(By.xpath("//*[@class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        // 3. THE EXPLICIT WAIT
        // Wait UNTIL the promo info is VISIBLE.
        // If it's in the DOM but hidden, Implicit wait passes but this fails (which is good for validation).
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

        driver.quit();
    }
}

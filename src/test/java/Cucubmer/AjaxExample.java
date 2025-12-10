package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AjaxExample {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        driver.findElement(By.xpath("(//*[text()='ADD TO CART'])[2]")).click();
        driver.findElement(By.xpath("//*[@alt='Cart']")).click();
        driver.findElement(By.xpath("//*[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.xpath("//*[@class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//*[@class='promoBtn']")).click();

        // 4. THE SOLUTION: Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Wait until the "promoInfo" text is visibly displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        // 5. Verification
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

        driver.quit();

    }
}

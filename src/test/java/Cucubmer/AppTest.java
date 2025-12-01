package Cucubmer;  // This must match your folder name exactly

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest { // This must match your filename (AppTest)
    public static void main(String[] args) throws InterruptedException {

        // 1. Launch Chrome
        WebDriver driver = new ChromeDriver();

        // 2. Go to SauceDemo
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // 3. Find Username using CSS SELECTOR
        driver.findElement(By.cssSelector("input[data-test='username']")).sendKeys("standard_user");

        // 4. Find Password using XPATH
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("secret_sauce");

        // 5. Click Login using XPATH TEXT SEARCH
        driver.findElement(By.xpath("//input[contains(@id,'login')]")).click();

        // 6. Verification
        Thread.sleep(2000);

        if(driver.getCurrentUrl().contains("inventory")) {
            System.out.println("✅ SUCCESS: Login Passed!");
        } else {
            System.out.println("❌ FAILED: Login Failed");
        }

        // 7. Close Browser
        driver.quit();
    }
}
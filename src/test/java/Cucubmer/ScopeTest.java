package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeTest {

        public static void main(String[] args) {

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");

            // 1. Get count of links on the ENTIRE page
            // The tag for links is always "a" (anchor)
            System.out.println("Total links on page: " + driver.findElements(By.tagName("a")).size());

            // 2. LIMIT SCOPE to the Footer
            // Identify the footer section first
            WebElement footerDriver = driver.findElement(By.id("gf-BIG"));

            // 3. Get count of links ONLY in the Footer
            // Notice we use 'footerDriver.findElements', NOT 'driver.findElements'
            System.out.println("Links in footer: " + footerDriver.findElements(By.tagName("a")).size());

            // 4. LIMIT SCOPE to the First Column of the Footer
            // We search inside 'footerDriver' to find the first column
            WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

            System.out.println("Links in first column: " + columnDriver.findElements(By.tagName("a")).size());

            driver.quit();
        }

}

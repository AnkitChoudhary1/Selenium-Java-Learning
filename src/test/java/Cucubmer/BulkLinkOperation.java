package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class BulkLinkOperation {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // 1. LIMIT SCOPE: Focus only on the footer section
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));

        // 2. LIMIT SCOPE FURTHER: Focus on just the first column of the footer
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

        // Count how many links are in this specific column
        int linkCount = columnDriver.findElements(By.tagName("a")).size();

        // 3. LOOP: Click on each link using Ctrl + Enter to open in new tab
        for (int i = 1; i < linkCount; i++) {

            // Create the keyboard shortcut string
            String clickOnLinkTab = Keys.chord(Keys.COMMAND, Keys.ENTER);

            // Send the shortcut to the specific link
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);

            // Sleep slightly to ensure browser registers the clicks (optional but helpful in bulk actions)
            Thread.sleep(1000L);
        }

        // 4. SWITCH WINDOWS: Go to each open tab and get the title
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        for(String tab : windows){
            driver.switchTo().window(tab);
            System.out.println("page title :"+driver.getTitle());
        }


        driver.quit();
    }

}

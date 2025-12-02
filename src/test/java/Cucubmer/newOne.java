package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class newOne {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        // 1. Scroll down to find the table (Just for visibility)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        // 2. Identify the Table Rows
        // TRICK: We use 'findElements' (Plural) to get a LIST of items, not just one.
        // XPath: Find the table -> Go to body -> Find all rows (tr)
        List<WebElement> rows = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr"));

        System.out.println("Total Rows found: " + rows.size());

        // 3. The JAVA LOOP (The Interview Part)
        // We start at i=1 because i=0 is usually the Header row
        for (int i = 1; i < rows.size(); i++) {

            // Get the specific columns for the current row
            // Column 2 = Course Name, Column 3 = Price
            // Note: We build the XPath DYNAMICALLY using the loop variable 'i'
            String priceText = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[" + (i+1) + "]/td[3]")).getText();
            String courseName = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[" + (i+1) + "]/td[2]")).getText();

            // 4. Java Logic: Print only cheap courses
            int price = Integer.parseInt(priceText); // Convert String "25" to Int 25

            if(price < 30) {
                System.out.println("✅ Cheap Course Found: " + courseName + " -> $" + price);
            }
        }

        driver.quit();
    }

}

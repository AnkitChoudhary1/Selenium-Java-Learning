package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();


        //Login code
        driver.findElement(By.cssSelector("input[name='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        //Need to store the xpath of the the drop down into web element to pass it as parameter in select class
        WebElement dropDown = driver.findElement(By.xpath("//*[@data-test='product-sort-container']"));

        //Not writing the select class
        Select filter = new Select(dropDown);

        //selecting the option to get dropdown
        filter.selectByVisibleText("Price (low to high)");

        System.out.println("✅ Dropdown selected successfully!");

        Thread.sleep(6000);
        driver.quit();

        /*

        You will be asked: "How do you handle dropdowns?" Answer:
        "I use the Select class in Selenium. First, I identify the WebElement,
        pass it into the Select constructor,
        and then use methods like selectByVisibleText() or selectByIndex()."
         */

    }
}

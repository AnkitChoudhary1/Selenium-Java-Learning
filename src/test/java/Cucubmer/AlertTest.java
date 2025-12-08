package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String name ="Ankit";
        driver.findElement(By.xpath("//*[@placeholder='Enter Your Name']")).sendKeys("Ankit");
        driver.findElement(By.xpath("//*[@value='Alert']")).click();

        // 2. Switch context to the Alert
        // Note: We are not creating a WebElement here, we are switching the driver focus
        System.out.println(driver.switchTo().alert().getText());

        //Click on Ok accept
        driver.switchTo().alert().accept();

        // 4. Test the Confirm button (which has OK and Cancel)
        driver.findElement(By.xpath("//*[@onclick='displayConfirm()']")).click();
        System.out.println(driver.switchTo().alert().getText());
        //click on dismiss button
        driver.switchTo().alert().dismiss();

        driver.quit();
    }
}

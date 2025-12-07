package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxText {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        // 1. Locate the Senior Citizen Checkbox
        // ID found via Inspect Element: ctl00_mainContent_chk_SeniorCitizenDiscount

        // 2. Check state BEFORE clicking (Should be false)
        System.out.println("The selection of checkbox is " + driver.findElement(By.xpath("//*[@name='ctl00$mainContent$chk_SeniorCitizenDiscount']")).isSelected());
        // 3. Click the checkbox
        driver.findElement(By.xpath("//*[@name='ctl00$mainContent$chk_SeniorCitizenDiscount']")).click();
        // 4. Check state AFTER clicking (Should be true)
        System.out.println("The selection of checkbox is " + driver.findElement(By.xpath("//*[@name='ctl00$mainContent$chk_SeniorCitizenDiscount']")).isSelected());
// Count the number of checkboxes on the page
        System.out.println("Total check box present the web page is " + driver.findElements(By.xpath("//*[@type='checkbox']")).size());
        driver.quit();


    }
}

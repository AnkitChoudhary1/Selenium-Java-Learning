package Cucubmer;


import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FixHeaderAssignment {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //to scroll defining js executor
        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("window.scrollBy(0,500)");

        //locating the table which we need to scroll
        WebElement table = driver.findElement(By.xpath("//*[@class='tableFixHead']"));
        js.executeScript("arguments[0].scrollTop = 5000", table);

        List<WebElement> list = driver.findElements(By.xpath("//*[@class='tableFixHead']//td[4]"));
        int sum =0;
        for(WebElement l : list){
            String p =l.getText();
            int price = Integer.parseInt(p);
            sum+=price;
        }
        System.out.println("Total sum is ="+sum);

        String actualAmount =driver.findElement(By.xpath("//*[@class='totalAmount']")).getText();
        String[] a = actualAmount.split(": ");
        int actualPrice= Integer.parseInt(a[1]);
        System.out.println("Actaul sum is ="+actualPrice);
        Assert.assertEquals(actualPrice, sum);

        driver.quit();


    }
}

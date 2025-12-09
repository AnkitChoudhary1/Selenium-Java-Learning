package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTableAssignment {

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //Scroll down using java script executor
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,500)");
        //Now we need to skip the first row as they are header
        //and first two column as we wat price only
        int sum =0;
        List<WebElement> list = driver.findElements(By.xpath("//*[@class='table-display']//td[3]"));
        for(WebElement l : list){
            String price = l.getText();
            int rate = Integer.parseInt(price);
            sum+=rate;
        }
        System.out.println("Total sum of price is ="+sum);
        driver.quit();
    }
}

package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Practise1 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        List<WebElement> list = driver.findElements(By.xpath("//*[@class='product-name']"));
String vegetable ="Cucumber";
        for(WebElement l : list){
            String[] veg =l.getText().split(" -");
            if(vegetable.equals(veg[0])){
                driver.findElement(By.xpath("//*[contains(text(), '"+veg[0]+"')]/parent::*[@class='product']//button")).click();
                System.out.println(veg[0]);
                break;
            }
            System.out.println(veg[0]);
        }

    }
}

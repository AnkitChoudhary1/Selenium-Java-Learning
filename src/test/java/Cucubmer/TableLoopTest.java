package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TableLoopTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        //Thread.sleep(4000);

        //Scroll down to find the actual table
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");

        //Now to access the entire row or the list of entire book
        List<WebElement> ls =driver.findElements(By.xpath("//table[@name='courses']/tbody/tr"));
        for(int i=1; i<ls.size(); i++) {

            String priceName = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[" + (i + 1) + "]/td[3]")).getText();
            String courseName = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr["+ (i+1) +"]/td[2]")).getText();

            int price = Integer.parseInt(priceName);
            if(price<30){
                System.out.println("Cheap course found "+courseName+" the price is "+priceName);
            }
        }

        driver.quit();
    }
}

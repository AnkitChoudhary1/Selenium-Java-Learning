package Cucubmer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AnnotationDemo {

    //Declaring webDriver globally to make sure
    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @Test(priority =1)
    public void googleTest(){
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
    }

    @Test(priority =2)
    public void amazonTest(){
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
    }


    @AfterMethod
    public void closeBrowser(){
        System.out.println("Closing the browser");
        driver.quit();
    }



}

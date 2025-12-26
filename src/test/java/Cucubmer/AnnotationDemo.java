package Cucubmer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class AnnotationDemo {

    //Declaring webDriver globally to make sure
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    //WebDriver driver;

    @BeforeMethod(alwaysRun =true)
    public void openBrowser(){
        WebDriver localDriver = new ChromeDriver();
        localDriver.manage().window().maximize();
        localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.set(localDriver);
    }

    @Test(priority =1, groups ="Smoke")
    public void googleTest(){
        driver.get().get("https://www.google.com/");
        //System.out.println(driver.getTitle());
        System.out.println("Google Thread ID: " + Thread.currentThread().getId());
    }

    @Test(priority =2, groups ="Regression")
    public void amazonTest(){
        driver.get().get("https://www.amazon.com/");
       // System.out.println(driver.getTitle());
        System.out.println("Amazon Thread ID: " + Thread.currentThread().getId());
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        System.out.println("Closing the browser");
        //driver.quit();
    }



}

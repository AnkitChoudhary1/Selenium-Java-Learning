package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandels {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.xpath("//*[@class='blinkingText']")).click();

        //the above click opens a new tab now we need to store all the id's
        Set<String> windows = driver.getWindowHandles();
        //Declared list here so we do not use iterator
        List<String> listWindow= new ArrayList<>(windows);

        String firstWindow = listWindow.get(0);
        String lastWindow = listWindow.get(1);

        driver.switchTo().window(lastWindow);

        //driver.switchTo().window(childId);

        System.out.println("Child Title: " + driver.getTitle());

        // Verify we are in the child window by grabbing text specifically there
        String text = driver.findElement(By.cssSelector(".im-para.red")).getText();
        System.out.println("Text from child tab: " + text);

        // 5. Switch back to Parent Window
        driver.switchTo().window(firstWindow);

        System.out.println("Parent Title: " + driver.getTitle());
        driver.quit();

    }
}

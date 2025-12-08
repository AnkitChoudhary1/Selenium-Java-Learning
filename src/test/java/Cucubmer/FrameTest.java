package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.xpath;

public class FrameTest {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(xpath("//*[@class='demo-frame']")));
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        //drag and drop using action class
        Actions a = new Actions(driver);
        a.dragAndDrop(source, target).build().perform();

        //switching back to normal frame
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("Accept")).click();
        driver.quit();

    }
}

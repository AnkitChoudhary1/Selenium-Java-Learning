package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        Actions a = new Actions(driver);
//        WebElement start = driver.findElement(By.xpath("//*[@alt='Continue shopping']"));
//        //Move cursor to the element start then click on it
//        a.moveToElement(start).build().perform();
//        a.click();

        //Hover to the sign in location
        WebElement move = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        a.moveToElement(move).build().perform();

        //capital letters
        WebElement search = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        a.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("toys").doubleClick().build().perform();
        System.out.println("Execution done");
        driver.quit();


//

    }
}

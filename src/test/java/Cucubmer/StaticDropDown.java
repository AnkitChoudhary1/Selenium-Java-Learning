package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class StaticDropDown {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        // 2. Identify the dropdown element (Look for <select> tag)
        WebElement dropDown =driver.findElement(By.xpath("//*[@name='ctl00$mainContent$DropDownListCurrency']"));
        // 3. Wrap the WebElement inside the Select class
        Select drop = new Select(dropDown);

        // Method A: Select by Index (Good for fixed lists like Months)
        drop.selectByIndex(3);
        System.out.println("Selected by index 3: "+ drop.getFirstSelectedOption().getText());

        // Method B: Select by Visible Text (Best for readability
        drop.selectByVisibleText("USD");
        System.out.println("Selected by visible text :"+drop.getFirstSelectedOption().getText());

        // Method C: Select by Value (Uses the HTML 'value' attribute)
        drop.selectByValue("INR");
        System.out.println("Selected by value :"+ drop.getFirstSelectedOption().getText());


        // 1. Click the "Passengers" dropdown to open the options
        driver.findElement(By.id("divpaxinfo")).click();

        // 2. Wait a moment for it to open (using Thread.sleep for simplicity right now)
        try{
            Thread.sleep(2000L);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        for(int i=0; i<5; i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        driver.findElement(By.xpath("//*[@class='buttonN' and @value='Done']")).click();
        System.out.println("Passenger count "+driver.findElement(By.id("divpaxinfo")).getText());

        //Click on from drop down
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//*[@text='Bengaluru (BLR)']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //click on from drop down
       //driver.findElement(By.xpath("(//*[@text='Chennai (MAA)'])[2]")).click();

        driver.findElement(By.xpath("//*[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//*[@text='Chennai (MAA)']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Route selected: BLR to MAA");
        driver.quit();

// Ankit






    }
}

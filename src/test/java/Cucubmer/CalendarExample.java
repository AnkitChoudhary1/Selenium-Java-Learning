package Cucubmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CalendarExample {

    public static void main(String[] args)  {
        ChromeOptions options = new ChromeOptions();

        // Add incognito argument
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.skyscanner.co.in/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Please select your departure date']")));
        //Thread.sleep(6000);
        //clicking on calendar
        driver.findElement(By.xpath("//*[@aria-label='Please select your departure date']")).click();
        String expectedMonth="November";
        String expecteDate="30";
        while(true){
            String secondMonth =driver.findElement(By.xpath("(//*[@class='BpkText_bpk-text__M2E2N BpkText_bpk-text--heading-4__ZWMwM CustomCalendar_MonthName__NjQwY'])[2]")).getText();
            if(secondMonth.equals(expectedMonth)){
                break;
            }
            else{
                driver.findElement(By.xpath("//*[contains(@aria-label, 'Next month')]")).click();
            }
        }
        List<WebElement> dates = driver.findElements(By.xpath("(//*[@class=\"CustomCalendar_WeekContainer__MDhmZ\"])[2]//*[@class='CustomCalendar_DayContainer__ODhlM' and @aria-hidden='false']//button"));

        for(WebElement date : dates){
            if(date.getText().equals(expecteDate)){
                date.click();
                break;
            }
        }

    }
}

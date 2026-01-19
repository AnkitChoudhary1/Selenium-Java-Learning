package testComponents;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    //public so that child classed can see
    public WebDriver driver;
    public Properties prop; //variable to hold data such as url id and password

    @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException {

        prop = new Properties();
        // System.getProperty("user.dir") gives the path to your project folder dynamically
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/data.properties");
        prop.load(fis);
        //Getting the browser name
        String browserName = prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else{
            driver = new SafariDriver();
        }


       // driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        //driver.get("https://www.saucedemo.com/");
        driver.get(prop.getProperty("url"));
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        // 1. Convert driver object to Screenshot object
        TakesScreenshot ts = (TakesScreenshot) driver;

        // 2. Take the picture (source file)
        File source = ts.getScreenshotAs(OutputType.FILE);

        // 3. Define where to save it (reports folder)
        File file = new File(System.getProperty("user.dir") + "/reports/" + testCaseName + ".png");

        // 4. Save the file
        FileHandler.copy(source, file);

        // 5. Return the path so the Report knows where to find it
        return System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        driver.quit();
    }
}

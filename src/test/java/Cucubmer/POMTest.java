package Cucubmer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

import java.time.Duration;

public class POMTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");

    }

    @Test
    public void login(){
        LoginPage login = new LoginPage(driver);
        login.enterUserName("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLoginButton();

        //Validation
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("inventory"), "Login failed!");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.selectBackpack();
        String itemsInCart = inventoryPage.getCartCount();
        System.out.println("Items in cart: " + itemsInCart);
        Assert.assertEquals(itemsInCart, "1");

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

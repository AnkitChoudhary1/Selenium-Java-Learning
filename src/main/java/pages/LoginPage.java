package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // 1. Constructor: Captures the driver from the test case
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // 2. Locators: Identified by 'By'
    // Notice: We are NOT finding elements yet, just storing the locator strategy
    By userName = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");

    // 3. Action Methods: The actual interaction
    public void enterUserName(String username){
        driver.findElement(userName).sendKeys(username);
    }

    public void enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

}

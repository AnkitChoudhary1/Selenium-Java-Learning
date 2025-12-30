package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    WebDriver driver;

    public InventoryPage(WebDriver driver){
        this.driver = driver;

    }
    //to click on add to cart for back pack
    By addToCart = By.xpath("//*[text()='Sauce Labs Backpack']/ancestor::div[2]//*[text()='Add to cart']");

    //to get the cart count
    By cartCount = By.className("shopping_cart_badge") ;

    public void selectBackpack(){
        driver.findElement(addToCart).click();
    }

    public String getCartCount(){
        return driver.findElement(cartCount).getText();
    }
}

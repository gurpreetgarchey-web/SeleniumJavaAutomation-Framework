package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.SmartWait;

public class InventoryPage {
	
	WebDriver driver;
    SmartWait smartWait;
    
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        smartWait = new SmartWait(driver);
    }
    
    public void addProductToCart(String productName) {

        List<WebElement> products =
                driver.findElements(By.className("inventory-item"));

        for (WebElement product : products) {

            String name =
                    product.findElement(By.className("inventory-item-name")).getText();

            if (name.equalsIgnoreCase(productName)) {

                product.findElement(By.tagName("button")).click();
                break;
            }
        }
    }
    
    
}
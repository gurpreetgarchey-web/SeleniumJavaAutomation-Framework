package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SmartWait;


public class HomePage {

    WebDriver driver;
    SmartWait smartWait;
  
    public HomePage(WebDriver driver) {
        this.driver = driver;
        smartWait = new SmartWait(driver);
    }

    By loginLink = By.linkText("Login");

    public void clickLoginLink() {
    	smartWait.click(loginLink);
  	
    	try {
    		//This was used because "SmartWait" was too quick. Thread.sleep is not suggested 
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

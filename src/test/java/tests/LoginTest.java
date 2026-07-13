package tests;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterMethod; //commented for now
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.HomePage;
import pages.InventoryPage;
import pages.LoginPage;
//import pages.ValidationPage;
import utils.ApiHtmlGenerator;
import utils.ConfigReader;
import api.UserAPI;

@Listeners(listeners.TestListener.class)

public class LoginTest extends BaseClass{

    @BeforeMethod
    public void setUp() {
        initializeDriver();
    }
    
    @Test
    public void validLoginTest() throws Exception {
    	System.out.println("Print1");
    	// Home Page Login link
        HomePage home = new HomePage(driver);
        home.clickLoginLink();
        
        System.out.println("Print2");
        //System.out.println(driver);
    	//System.out.println(((RemoteWebDriver) driver).getSessionId());
        
        // Login Page
        LoginPage login = new LoginPage(driver);
        login.login(ConfigReader.getUsername(), ConfigReader.getPassword());
        System.out.println("Print3");
        
        // Inventory Page
        InventoryPage inventory = new InventoryPage(driver);
        
        //Add product to +cart
        inventory.addProductToCart("Backpack"); 
        
       // 1. Page title (basic sanity check). After Login confirms correct page load.
        Assert.assertEquals(driver.getTitle(), "Inventory");
        
        //2. URL validation (very important). Confirms navigation happened after login
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
        
        //3. Login success element. (Best Practice). inventory page shows a product or logo
        Assert.assertTrue(driver.findElement(By.id("container")).isDisplayed());
        
        System.out.println("Print4");
        
     // API Validation

        int status =
                UserAPI.verifyAPI(ConfigReader.getApi());
        System.out.println("STATUS CODE = " + status);
        Assert.assertEquals(status, 200);
     
        System.out.println("API Passed");
        
        String html = ApiHtmlGenerator.createHtml();

        driver.get(new File(html).toURI().toString());

        Assert.assertTrue(driver.findElement(By.tagName("table")).isDisplayed());

        List<WebElement> rows = driver.findElements(By.tagName("tr"));

        Assert.assertEquals(rows.size(), 2);

        System.out.println("API HTML verified successfully.");
        
    }
      
    //Commented for now//

    @AfterMethod
    public void closeBrowser() {
        tearDown();
    }
   
   
}
package base;

//import java.time.Duration;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;

public class BaseClass {

    public static WebDriver driver;

    @BeforeMethod
    public void initializeDriver() {

        String browser = ConfigReader.getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.getUrl());
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    
}


/*
public class BaseClass {

   // public WebDriver driver;
    public static WebDriver driver;
    //protected WebDriverWait wait;

    public void initializeDriver() {
    	System.out.println("Setup started");


        String browser = ConfigReader.getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } 
        else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } 
        else {
            throw new RuntimeException("Browser not supported");
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.getUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
       
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
*/
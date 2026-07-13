package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ConfigReader;
import utils.SmartWait;

public class LoginPage {

    WebDriver driver;
    private String loggedInUser;
    SmartWait smartWait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        smartWait = new SmartWait(driver);
    }
    
    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.id("loginBtn");

    public void login(String user, String pass) {

        smartWait.type(username, user);
        smartWait.type(password, pass);
        smartWait.click(loginBtn);

        driver.get(ConfigReader.getInventoryUrl());
        loggedInUser = user;
    }
    
    
    public String getLoggedInUser() {
        return loggedInUser;
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValidationPage {

    WebDriver driver;

    public ValidationPage(WebDriver driver) {
        this.driver = driver;
    }

    By logintext = By.id("loginBtn");

    public String getHomeLinkText() {
        return driver.findElement(logintext).getText();
    }
}
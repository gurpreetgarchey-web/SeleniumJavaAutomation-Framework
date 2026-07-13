package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String fileName) {

        // Create screenshots folder if it doesn't exist. Good practice
    	// to have screenshots folder under reports as per chatgpt.com
        File folder = new File("reports/screenshots");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Capture screenshot
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Save as PNG
        File destination = new File(folder, fileName + ".png");

        try {
            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot saved: " + destination.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
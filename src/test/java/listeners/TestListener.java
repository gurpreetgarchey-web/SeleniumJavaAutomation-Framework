package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseClass;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

    //	WebDriver driver = null;

        // Test method name
        String fileName = result.getName();

        ScreenshotUtil.captureScreenshot(BaseClass.driver, result.getName());
        System.out.println("Screenshot saved::: " + fileName + ".png");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " PASSED");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " STARTED");
    }
}
package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import org.openqa.selenium.WebDriver;

import utils.DriverFactory;
import utils.ScreenshortUtils;

public class TestListener implements ITestListener {

    // Runs when test starts
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("STARTED: " + result.getMethod().getMethodName());
    }

    // Runs when test passes
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASSED: " + result.getMethod().getMethodName());
    }

    // Runs when test fails
    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("FAILED: " + result.getMethod().getMethodName());

        // Get driver from DriverFactory (ThreadLocal)
        WebDriver driver = DriverFactory.getDriver();

        // Capture screenshot using test name
        String screenshotPath = ScreenshortUtils.captureScreenshot(
                driver,
                result.getMethod().getMethodName()
        );

        // Print screenshot path (useful for debugging)
        System.out.println("Screenshot saved at: " + screenshotPath);
    }

    // Runs when test is skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIPPED: " + result.getMethod().getMethodName());
    }
}
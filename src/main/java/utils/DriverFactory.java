package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    // ThreadLocal ensures separate driver for each test (important for parallel execution)
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Initialize browser based on config
    public static WebDriver initDriver(String browser) {

        // Check which browser to launch
        if (browser.equalsIgnoreCase("chrome")) {

            // Create new ChromeDriver and store in ThreadLocal
            driver.set(new ChromeDriver());
        }

        // Return driver for current thread
        return getDriver();
    }

    // Get driver for current thread
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Quit browser and remove from memory
    public static void quitDriver() {

        if (driver.get() != null) {
            driver.get().quit();  // close browser
            driver.remove();      // remove reference
        }
    }
}
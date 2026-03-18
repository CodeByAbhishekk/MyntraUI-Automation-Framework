package base;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    // Runs once before entire suite
    @BeforeSuite
    public void setupFolders() {
        new File("reports").mkdirs();
        new File("screenshots").mkdirs();
    }

    //  Runs before each test method
    @BeforeMethod
    public void setUp() {

        // Read config values
        String browser = ConfigReader.getProperty("browser");
        String url = ConfigReader.getProperty("url");

        // Initialize driver
        driver = DriverFactory.initDriver(browser);

        // Maximize window
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Launch URL
        driver.get(url);
    }

    //  Runs after each test method
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
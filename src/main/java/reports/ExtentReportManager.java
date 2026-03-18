package reports;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.FrameworkConstants;

public class ExtentReportManager {

    // Single instance of ExtentReports (shared across tests)
    private static ExtentReports extent;

    // Method to get ExtentReports object
    public static ExtentReports getReporter() throws IOException {

        if (extent == null) {

            // Create report file (HTML)
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.REPORT_PATH);

            // Load custom config (theme, title, etc.)
            spark.loadXMLConfig(FrameworkConstants.EXTENT_CONFIG_PATH);

            // Create ExtentReports object
            extent = new ExtentReports();

            // Attach reporter
            extent.attachReporter(spark);

            // Add system/environment info
            extent.setSystemInfo("Project", "Myntra Automation");
            extent.setSystemInfo("Tester", "Your Name");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}
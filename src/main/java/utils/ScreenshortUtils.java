package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.commons.io.FileUtils;

public class ScreenshortUtils {

    // Method to capture screenshot
    public static String captureScreenshot(WebDriver driver, String testName) {

        // Take screenshot and store temporarily
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define final path with timestamp (to avoid overwrite)
        String path = "screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";

        // Destination file
        File dest = new File(path);

        try {
            // Copy screenshot from temp location to destination
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return path (useful for reports)
        return path;
    }
}
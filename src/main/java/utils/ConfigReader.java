package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	//This object will store key-value pair from config file
    private static Properties prop;

    // Static block run/loads once When class loads
    static {
        try {
        	// It will load config.properties file
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            
            // Create Properties object
            prop = new Properties();
            
         // Load data from file into Properties object
            prop.load(fis);
            
        } catch (IOException e) {
        	// Stop execution if config file not found
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    // Method to get value using key (like browser, url)
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
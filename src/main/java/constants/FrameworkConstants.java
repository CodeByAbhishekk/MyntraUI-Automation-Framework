package constants;

public class FrameworkConstants {

    // Private constructor to prevent object creation
    private FrameworkConstants() {}

    
    // TIMEOUTS
    

    // Implicit wait time (seconds)
    public static final int IMPLICIT_WAIT = 10;
    
    // Explicit wait time (seconds)
    public static final int EXPLICIT_WAIT = 15;

    // Page load timeout (seconds)
    public static final int PAGE_LOAD_TIMEOUT = 20;

   
  
    // FILE PATHS
    

    // Config file path
    public static final String CONFIG_FILE_PATH = "src/test/resources/config.properties";

    // Extent report config path
    public static final String EXTENT_CONFIG_PATH = "src/test/resources/extent-config.xml";

    // Report folder
    public static final String REPORT_PATH = "reports/index.html";

    // Screenshot folder
    public static final String SCREENSHOT_PATH = "screenshots/";


  
    // BROWSER VALUES

    public static final String CHROME = "chrome";
    


    // Default URL (fallback if config fails)
    public static final String DEFAULT_URL = "https://www.myntra.com";
}
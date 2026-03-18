package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import utils.WaitUtils;

public class HomePage {

    private WebDriver driver;

    // Constructor → initialize driver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    
    // Men menu
    private By menMenu = By.xpath("//a[@data-group='men']");

    // T-Shirts option under Men
    private By tshirtsOption = By.xpath("//a[text()='T-Shirts']");


    // =============================
    // Actions
    // =============================

    // Hover on Men menu
    public void hoverOnMenMenu() {

        // Wait until menu is visible
        WaitUtils.waitForElementVisible(driver, menMenu);

        // Perform mouse hover
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(menMenu)).perform();
    }

    // Click on T-Shirts under Men
    public void clickOnTshirts() {

        // Hover first (important for dropdown)
        hoverOnMenMenu();

        // Wait for T-Shirts to be clickable
        WaitUtils.waitForElementClickable(driver, tshirtsOption);

        // Click on T-Shirts
        driver.findElement(tshirtsOption).click();
    }

	public void navigateToMenTshirts() {
		clickOnTshirts();
		
		
	}


    
}
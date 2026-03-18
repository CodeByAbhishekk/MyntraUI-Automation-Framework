package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class CartPage {

    private WebDriver driver;

    // Constructor → initialize driver
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // =============================
    // Locators
    // =============================

    // Product name in cart
    private By productName = By.xpath("//div[contains(@class,'itemContainer')]//a");

    // Product price
    private By productPrice = By.xpath("//span[contains(@class,'item-price')]");

    // Total price (bag total)
    private By totalPrice = By.xpath("//div[contains(text(),'Total')]/following-sibling::div");

    // Remove button
    private By removeButton = By.xpath("//button[contains(text(),'REMOVE')]");

    // Confirm remove
    private By confirmRemove = By.xpath("//button[contains(text(),'REMOVE ITEM')]");


    // =============================
    // Actions
    // =============================

    // Check if product is displayed in cart
    public boolean isProductDisplayed() {
        return WaitUtils.waitForElementVisible(driver, productName).isDisplayed();
    }

    // Get product name
    public String getProductName() {
        return WaitUtils.waitForElementVisible(driver, productName).getText();
    }

    // Get product price (converted to int)
    public int getProductPrice() {

        String priceText = WaitUtils.waitForElementVisible(driver, productPrice).getText();
                
        		// removes Rs, ₹, commas, spaces
                String cleanedText  = priceText.replaceAll("[^0-9]", "").trim();
                 
                

        return Integer.parseInt(cleanedText);
    }

    // Get total cart price
    public int getTotalPrice() {

        String totalText = WaitUtils. waitForElementVisible(driver, totalPrice).getText();
        String cleanedText  = totalText.replaceAll("[^0-9]", "").trim();      
        return Integer.parseInt(totalText);
    }

    // Remove product from cart
    public void removeProduct() {

        WaitUtils.waitForElementClickable(driver, removeButton).click();
        WaitUtils.waitForElementClickable(driver, confirmRemove).click();
    }
}
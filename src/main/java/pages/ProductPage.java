package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class ProductPage {

    private WebDriver driver;

    // Constructor → initialize driver
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // =============================
    // Locators
    // =============================

    // First product from listing page
    private By firstProduct = By.xpath("(//li[contains(@class,'product-base')])[1]");

    // Size selection (example: first available size)
    private By sizeOption = By.xpath("//div[@class='size-buttons-size-buttons']//button[1]");

    // Add to Bag button
    private By addToBagButton = By.xpath("//div[contains(text(),'ADD TO BAG')]");

    // Go to Bag button
    private By goToBagButton = By.xpath("//span[contains(text(),'GO TO BAG')]");


    // =============================
    // Actions
    // =============================

    // Click on first product from category page
    public void clickFirstProduct() {

        WaitUtils.waitForElementClickable(driver, firstProduct).click();

        // Switch to new tab (important for Myntra)
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
        }
    }

    // Select size (if required)
    public void selectSize() {
        WaitUtils.waitForElementClickable(driver, sizeOption).click();
    }

    // Click Add to Bag
    public void clickAddToBag() {
        WaitUtils.waitForElementClickable(driver, addToBagButton).click();
    }

    // Click Go to Bag
    public void clickGoToBag() {
        WaitUtils.waitForElementClickable(driver, goToBagButton).click();
    }


    // =============================
    // Combined Action (Best Practice)
    // =============================

    // Full flow → open product → select size → add to bag → go to cart
    public void addProductToCart() {

        clickFirstProduct();   // open product
        selectSize();          // select size
        clickAddToBag();       // add item
        clickGoToBag();        // go to cart
    }
}
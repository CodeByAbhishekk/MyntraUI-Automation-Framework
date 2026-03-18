package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitUtils;

public class CategoryPage {

    private WebDriver driver;

    // Constructor → initialize driver
    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }



    // Sort dropdown
    private By sortDropdown = By.xpath("//div[contains(@class,'sort-sortBy')]");

    // Sorting options
    private By lowToHighOption =  By.xpath("//label[contains(text(),'Low to High')]");
    private By highToLowOption = By.xpath("//label[contains(text(),'High to Low')]");

    // Product prices
    private By productPrices = By.xpath("//li[contains(@class,'product-base')]//span[contains(@class,'price')]");


    
    // Click on sort dropdown
    private void openSortDropdown() {
        WaitUtils.waitForElementClickable(driver, sortDropdown).click();
    }

    // Select Low → High sorting
    public void sortByLowToHigh() {
        openSortDropdown();
        WaitUtils.waitForElementClickable(driver, lowToHighOption).click();
        WaitUtils.waitForPageLoad(driver); // wait for sorting to apply
        
    }

    // Select High → Low sorting
    public void sortByHighToLow() {
        openSortDropdown();
        WaitUtils.waitForElementClickable(driver, highToLowOption).click();
        WaitUtils.waitForPageLoad(driver);
      
    }  

    // Get all product prices as Integer list
    public List<Integer> getProductPrices() {

        List<Integer> prices = new ArrayList<>();

        // Re-fetch elements every time (avoid stale)
        List<WebElement> elements = driver.findElements(productPrices);

        for (int i = 0; i < elements.size(); i++) {

            try {
                // Re-locate element again (IMPORTANT)
                String text = driver.findElements(productPrices)
                        .get(i)
                        .getText()
                        .replaceAll("[^0-9]", "")
                        .trim();

                if (!text.isEmpty()) {
                    prices.add(Integer.parseInt(text));
                }

            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                i--; // retry same index
            }
        }

        return prices;
    }
    
 // Scroll page to load more products (for lazy loading)
    public void scrollToLoadProducts() {

        for (int i = 0; i < 3; i++) {

            // Scroll down by 1000 pixels
            ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("window.scrollBy(0,1000)");

            // Wait for new products to load
            try {
                Thread.sleep(2000);
            } catch (Exception e) {}
        }
    }


    // Validation Methods
   

    // Check if list is sorted in ascending order
    public boolean isSortedAscending(List<Integer> prices) {

        List<Integer> sortedList = new ArrayList<>(prices);
        Collections.sort(sortedList);

        return prices.equals(sortedList);
    }

    // Check if list is sorted in descending order
    public boolean isSortedDescending(List<Integer> prices) {

        List<Integer> sortedList = new ArrayList<>(prices);
        sortedList.sort(Collections.reverseOrder());

        return prices.equals(sortedList);
    }
}
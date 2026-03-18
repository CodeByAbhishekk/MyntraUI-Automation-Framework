package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.CategoryPage;

public class SortByPriceTest extends BaseTest {

    
    // Test Case: Low → High Sorting
    
    @Test
    public void TC_POS_02_verifyLowToHighSorting() {

        HomePage homePage = new HomePage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);

        // Step 1: Navigate to Men's T-Shirts
        homePage.navigateToMenTshirts();

        // Step 2: Apply sorting (Low → High)
        categoryPage.sortByLowToHigh();
        
     // IMPORTANT: load more products
        categoryPage.scrollToLoadProducts();

        // Step 3: Get product prices
        List<Integer> prices = categoryPage.getProductPrices();
        System.out.println("Prices:"+prices);

        // Step 4: Validate sorting
        Assert.assertTrue(categoryPage.isSortedAscending(prices),"Prices are NOT sorted in ascending order!");
               
              
       
    }


    
    // Test Case: High → Low Sorting
    
    @Test
    public void TC_POS_03_verifyHighToLowSorting() {

        HomePage homePage = new HomePage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);

        // Step 1: Navigate to Men's T-Shirts
        homePage.navigateToMenTshirts();

        // Step 2: Apply sorting (High → Low)
        categoryPage.sortByHighToLow();
        
        // IMPORTANT: load more products
        categoryPage.scrollToLoadProducts();

        // Step 3: Get product prices
        List<Integer> prices = categoryPage.getProductPrices();
        System.out.println("Prices:"+prices);

        // Step 4: Validate sorting
        Assert.assertTrue(categoryPage.isSortedDescending(prices),  "Prices are NOT sorted in descending order!");
                
      
    }
}
package com.flash.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.flash.actiondriver.Action;
import com.flash.base.BaseClass;

public class DesktopsPage extends BaseClass{
	
	Action action =new Action();
	
	
	public DesktopsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@Test
    public void testSortAddToCartAndValidateTotalPrice() {
		 WebElement sortDropdown = driver.findElement(By.id("products-orderby"));
		 String[] sortOptions = {
		            "Name: A to Z",
		            "Name: Z to A",
		            "Price: Low to High",
		            "Price: High to Low"
		        };
		 for (String option : sortOptions) {
			 sortDropdown.click();
			 WebElement sortOption = driver.findElement(By.xpath("//select[@id='products-orderby']/option[text()='" + option + "']"));
	            sortOption.click();
	            List<WebElement> items = driver.findElements(By.cssSelector(".item-box"));
	            double totalExpectedPrice = 0.0;
	            for (WebElement item : items) {
	                // Extract the price
	                WebElement priceElement = item.findElement(By.cssSelector(".price"));
	                String priceText = priceElement.getText().replace("$", "").trim();
	                double itemPrice = Double.parseDouble(priceText);
	                totalExpectedPrice += itemPrice;
	                
	                WebElement addToCartButton = item.findElement(By.cssSelector(".button-2.add-to-cart-button"));
	                addToCartButton.click();
	            
	                WebElement closeNotificationButton = driver.findElement(By.cssSelector(".bar-notification .close"));
	                closeNotificationButton.click();
	                WebElement cartLink = driver.findElement(By.className("button-1 add-to-cart-button"));
	                cartLink.click();
	                WebElement totalPriceElement = driver.findElement(By.cssSelector(".cart-total .product-subtotal"));
	                String totalPriceText = totalPriceElement.getText().replace("$", "").trim();
	                double totalActualPrice = Double.parseDouble(totalPriceText);
	            }
	            
	            public void removeItemfromCart()
	            
	            {
	            	WebElement cartLink = driver.findElement(By.className("cart-label"));
	                cartLink.click();
	                WebElement totalPriceElement = driver.findElement(By.cssSelector(".cart-total .product-subtotal"));
	                String totalPriceText = totalPriceElement.getText().replace("$", "").trim();
	                double totalActualPrice = Double.parseDouble(totalPriceText);
	                WebElement removeButton = driver.findElement(By.cssSelector(".remove-from-cart"));
	                removeButton.click();
	                double itemToRemovePrice = getItemPrice(items.get(0));
	                double newExpectedTotalPrice = totalExpectedPrice - itemToRemovePrice;
	                double itemToRemovePrice1 = getItemPrice(items.get(0));
	                double newExpectedTotalPrice1 = totalExpectedPrice - itemToRemovePrice1;
	                
	                private double getItemPrice(WebElement item) {
	                    // Helper method to get the price of an item
	                    WebElement priceElement = item.findElement(By.cssSelector(".price"));
	                    String priceText = priceElement.getText().replace("$", "").trim();
	                    return Double.parseDouble(priceText);
	                }


	            }

		 }

	}

	}
}

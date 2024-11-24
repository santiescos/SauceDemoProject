package PageObjects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Tests.BaseTest;
import Tests.Helpers.ElementUtils;

public class InventoryItemsPage {

	// By locators
	private final By inventoryItems = By.cssSelector("div[class='inventory_item']");
	private final By itemImage = By.cssSelector("div[class='inventory_item_img']");
    private final By itemTitle = By.cssSelector(".inventory_item_name");
    private final By itemDescription = By.cssSelector(".inventory_item_desc");
    private final By itemPrice = By.cssSelector(".inventory_item_price");
    private final By itemButton = By.cssSelector(".btn");
    
    // List to hold item names
	private List <String> itemsName = getAllItemsNames();
	
	// Instance variables
	WebDriver driver;
	ElementUtils elementUtils;
	
	public InventoryItemsPage(WebDriver driver) {
		this.driver = driver;
	}

	public List <WebElement> getAllItems() {
		return driver.findElements(inventoryItems);
	}
	
	public boolean correctNumberOfItems() {
		return (getAllItems().size() == 6);
	}

	public List <String> getAllItemsNames() {
		List <WebElement> items = getAllItems();
		List <String> itemsName = new ArrayList<>();
		for (WebElement item : items) {
			itemsName.add(item.getText());
		}
		return itemsName;
	}
	
	public void addItemToCart(String article) {
		driver.findElement(By.cssSelector(""));
	}

	/*public List<WebElement> sortByByPrice(List<WebElement> elements, String value) {
	    Comparator<WebElement> comparator = Comparator.comparingDouble(element -> {
	        String priceText = element.findElement(itemPrice).getText();
	        return extractPriceAsDouble(priceText);
	    });

	    // Reverse the comparator if descending order is requested
	    if (value.equals("hilo")) {
	        comparator = comparator.reversed();
	    }

	    // Return a new sorted list without modifying the original list
	    return elements.stream()
	                   .sorted(comparator)
	                   .collect(Collectors.toList());
	}*/

	private double extractPriceAsDouble(String priceText) {
	    priceText = priceText.replace("$", "").replace(",", "").trim();
	    return Double.parseDouble(priceText); // Convert to double
	}
	
	public boolean isHiLoSorted(List<WebElement> elements, String value) {
		//Make an iterator to get the every WebElement and verify if product is > than the next
		for (int i = 0; i < (elements.size()) - 1; i++) {
			double currentPrice = extractPriceAsDouble(elements.get(i).findElement(itemPrice).getText());
			double nextPrice = extractPriceAsDouble(elements.get(+1).findElement(itemPrice).getText());
			switch(value){
				case "hilo":
					if(currentPrice < nextPrice) {
						return false;
					} else {
						return true;
					}
				case "lohi":
					if(currentPrice > nextPrice) {
						return false;
					} else {
						return true;
					}
			}		
		}
		return false;
	}
}

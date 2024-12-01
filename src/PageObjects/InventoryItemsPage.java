package PageObjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Tests.Helpers.ElementUtils;

public class InventoryItemsPage {

	// By locators
	private final By inventoryItems = By.cssSelector("div[class='inventory_item']");
	private final By itemImage = By.cssSelector("div[class='inventory_item_img']");
    private final By itemTitle = By.cssSelector(".inventory_item_name");
    private final By itemDescription = By.cssSelector(".inventory_item_desc");
    private final By itemPrice = By.cssSelector(".inventory_item_price");
    private final By itemButton = By.cssSelector(".btn");
	
	// Instance variables
	private WebDriver driver;
	ElementUtils elementUtils;
	
	public InventoryItemsPage(WebDriver driver) {
		this.driver = driver;
	}

	private List<String> itemsName;

	public List<String> getItemsName() {
	    if (itemsName == null) {
	        itemsName = getAllItemsNames();
	    }
	    return itemsName;
	}
	
	public List <WebElement> getAllItems() {
		return driver.findElements(inventoryItems);
	}
	
	public boolean correctNumberOfItems() {
		return (getAllItems().size() == 6);
	}

	public List <String> getAllItemsNames() {
		List <WebElement> items = getAllItems();
		List <String> names = new ArrayList<>();
		for (WebElement item : items) {
			names.add(item.getText());
		}
		return names;
	}
	
	public void addItemToCart(String article) {
		driver.findElement(By.cssSelector(""));
	}

	private double extractPriceAsDouble(String priceText) {
	    priceText = priceText.replace("$", "").replace(",", "").trim();
	    return Double.parseDouble(priceText);
	}
	
	public boolean isHiLoSorted(List<WebElement> elements, String value) {
		for (int i = 0; i < (elements.size()) - 1; i++) {
			double currentPrice = extractPriceAsDouble(elements.get(i).findElement(itemPrice).getText());
			double nextPrice = extractPriceAsDouble(elements.get(i+1).findElement(itemPrice).getText());
			switch (value) {
				case "hilo":
					if (currentPrice < nextPrice) {
						return false;
					}
					break;
				case "lohi":
					if (currentPrice > nextPrice) {
						return false;
					}
					break;
				default:
					return false;
			}		
		}
		return true;
	}
}

package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Tests.BaseTest;
import Tests.Helpers.ElementUtils;

public class InventoryItemsPage extends BaseTest {

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
	
}

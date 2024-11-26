package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Tests.Helpers.ElementUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryPage {

	// By locators
	private final By filterContainer = By.cssSelector("span[class='select_container']");
	private final By filterContainerByDefault = By.className("active_option");
	private final String filterContainerByDefaultString = "Name (A to Z)";
	private final By inventoryContainer = By.id("inventory_container");
	private final By inventoryList = By.cssSelector("div[class='inventory_list']");
	private final By productsTitle = By.className("title");
	private final String productsTitleString = "Products";
	private final By filterDropdownBy = By.className("product_sort_container");
	
	//Instance variables
	private  WebDriver driver;
	ElementUtils elementUtils;
	InventoryItemsPage inventoryItemsPage;
	
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
		this.inventoryItemsPage = new InventoryItemsPage(driver);
	}


	public boolean isFilterContainerVisible() {return elementUtils.isElementVisible(filterContainer);}	
	public boolean isInventoryContainerVisible() {return elementUtils.isElementVisible(inventoryContainer);}
	public boolean isInventoryListVisible() {return elementUtils.isElementVisible(inventoryList);}
	public boolean isProductsStringCorrect() {return driver.findElement(productsTitle).getText().equalsIgnoreCase(productsTitleString);}
	public boolean isFilterCorrectByDefault() {return driver.findElement(filterContainerByDefault).getText().equalsIgnoreCase(filterContainerByDefaultString);}
	
	public boolean filteringInventory(String value) {
		WebElement filterDropdownElement = driver.findElement(filterDropdownBy);
		Select filter = new Select(filterDropdownElement);
		filter.selectByValue(value);
		List <String> itemsDefault = inventoryItemsPage.getAllItemsNames();
		switch(value) {
		case "az":
			List <String> itemsAz = inventoryItemsPage.getAllItemsNames();
			itemsAz.sort(null);
			itemsDefault.sort(null);
			return itemsAz.equals(itemsDefault);
		case "za":
			List <String> itemsZa = new ArrayList<>(inventoryItemsPage.getAllItemsNames());
			itemsDefault.sort(Collections.reverseOrder());
			return itemsZa.equals(itemsDefault);
		case "lohi":
			List <WebElement> itemsLoHi = inventoryItemsPage.getAllItems();
			return inventoryItemsPage.isHiLoSorted(itemsLoHi, value);
		case "hilo":
			List<WebElement> itemsHiLo = inventoryItemsPage.getAllItems();
			return inventoryItemsPage.isHiLoSorted(itemsHiLo, value);
		default:
			return false;
			}
	}
	
	
}

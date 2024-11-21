package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Tests.Helpers.ElementUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class InventoryPage {

	// By locators
	private final By filterContainer = By.cssSelector("span[class='select_container']");
	private final By filterContainerByDefault = By.className("active_option");
	private final String filterContainerByDefaultString = "Name (A to Z)";
	private final By inventoryContainer = By.id("inventory_container");
	private final By inventoryList = By.cssSelector("div[class='inventory_list']");
	private final By productsTitle = By.className("title");
	private final String productsTitleString = "Products";
	
	//Instance variables
	WebDriver driver;
	ElementUtils elementUtils;
	InventoryItemsPage inventoryItemsPage = new InventoryItemsPage(driver);
	
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}


	public boolean isFilterContainerVisible() {return elementUtils.isElementVisible(filterContainer);}	
	public boolean isInventoryContainerVisible() {return elementUtils.isElementVisible(inventoryContainer);}
	public boolean isInventoryListVisible() {return elementUtils.isElementVisible(inventoryList);}
	public boolean isProductsStringCorrect() {return driver.findElement(productsTitle).getText().equalsIgnoreCase(productsTitleString);}
	public boolean isFilterCorrectByDefault() {return driver.findElement(filterContainerByDefault).getText().equalsIgnoreCase(filterContainerByDefaultString);}
	
	public boolean filterNameZtoA(String value) {
		WebElement filterDropdown = driver.findElement(filterContainer);
		Select filter = new Select(filterDropdown);
		filter.selectByValue("za");
		List <String> items = inventoryItemsPage.getAllItemsNames();
		List <String> reverseSortedItemsList = new ArrayList<>(items);
		reverseSortedItemsList.sort(Collections.reverseOrder());
		return reverseSortedItemsList.equals(items);
	}
	
	public boolean filterNameAtoZ() {
		
	}
	
	
}

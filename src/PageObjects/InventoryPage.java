package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Tests.Helpers.ElementUtils;

public class InventoryPage {

	// By locators
	private final By filterContainer = By.cssSelector("span[class='select_container']");
	private final By inventoryContainer = By.id("inventory_container");
	private final By inventoryList = By.cssSelector("div[class='inventory_list']");
	
	//Instance variables
	WebDriver driver;
	ElementUtils elementUtils;
	
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}


	public boolean isFilterContainerVisible() {return elementUtils.isElementVisible(filterContainer);}	
	public boolean isInventoryContainerVisible() {return elementUtils.isElementVisible(inventoryContainer);}
	public boolean isInventoryListVisible() {return elementUtils.isElementVisible(inventoryList);}			
}

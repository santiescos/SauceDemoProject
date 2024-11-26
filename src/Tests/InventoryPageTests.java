package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryPageTests extends BaseTest {

	@Test(description = "Verify all items are present with standard user")
	public void verifyAllItemsPresent() {
		logInPage.accessStandardUser();
		Assert.assertTrue(inventoryItemsPage.correctNumberOfItems());
	}
	
	@Test(description = "Verify inventory is sorted a-z")
	public void sortAZ() {
		logInPage.accessStandardUser();
		Assert.assertTrue(inventoryPage.filteringInventory("az"), "Filtering a-z not working as expected");
	}
	
	@Test(description = "Verify inventory is sorted a-z")
	public void sortZA() {
		logInPage.accessStandardUser();
		Assert.assertTrue(inventoryPage.filteringInventory("za"), "Filtering z-a not working as expected");
	}
	
	@Test(description = "Verify inventory is sorted High to Low")
	public void sortHighToLow() {
		logInPage.accessStandardUser();
		Assert.assertTrue(inventoryPage.filteringInventory("hilo"), "Filtering high to low is not working as expected");
	}
	
	@Test(description = "Verify inventory is sorted Low to high")
	public void sortLowToHigh() {
		logInPage.accessStandardUser();
		Assert.assertTrue(inventoryPage.filteringInventory("lohi"), "Filtering low to high is not working as expected");
	}
}

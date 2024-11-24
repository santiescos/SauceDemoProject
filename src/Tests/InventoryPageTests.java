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
		Assert.assertTrue(inventoryPage.filteringInventory("az"));
	}
	
	@Test(description = "Verify inventory is sorted a-z")
	public void sortZA() {
		logInPage.accessStandardUser();
		Assert.assertTrue(inventoryPage.filteringInventory("za"));
	}
	
	@Test(description = "Verify inventory is sorted a-z")
	public void sortHighToLow() {
		logInPage.accessStandardUser();
		Assert.assertTrue(inventoryPage.filteringInventory("hilo"));
	}
	
	@Test(description = "Verify inventory is sorted a-z")
	public void sortLowToHigh() {
		logInPage.accessStandardUser();
		Assert.assertTrue(inventoryPage.filteringInventory("lohi"));
	}
	
}

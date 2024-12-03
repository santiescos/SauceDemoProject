package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class InventoryPageTests extends BaseTest {
	
	@Test(description = "Verify Ivnentory Page is correctly displayed")
	public void verifyInventoryPageLoads() {
		SoftAssert softAssert = new SoftAssert();
		logInPage.accessStandardUser();
		softAssert.assertTrue(inventoryPage.isFilterContainerVisible(), "Filter Container is not visible");
		softAssert.assertTrue(inventoryPage.isInventoryContainerVisible(), "Inventory Container is not visible");
		softAssert.assertTrue(inventoryPage.isInventoryListVisible(), "Inventory List is not visible");
		softAssert.assertTrue(inventoryPage.isFilterCorrectByDefault(), "Filter is incorrect");
		softAssert.assertTrue(inventoryPage.isProductsStringCorrect(), "Products title is not correct");
		softAssert.assertAll();
	}

	@Test(description = "Verify all items are present with standard user")
	public void verifyAllItemsPresent() {
		logInPage.accessStandardUser();
		Assert.assertTrue(productsPage.correctNumberOfProducts());
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
	
	@Test(description = "Verify item is added by Cart, and item is selected by partial name")
	public void addItemByCart() {
		logInPage.accessStandardUser();
		Assert.assertTrue(productsPage.addProductToCartByPartialTextAndVeriFyItsAdded("bolt"), "Item is not being correctly added to the cart");
	}
}

package Tests.Helpers;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import PageObjects.HeaderPage;
import PageObjects.InventoryPage;

public class CommonAssertions {
	WebDriver driver;
	
	public CommonAssertions(WebDriver driver) {
		this.driver = driver;
	}
	
	public void isInventoryPageLoaded(SoftAssert softAssert) {
		InventoryPage inventoryPage = new InventoryPage(driver);
		softAssert.assertTrue(inventoryPage.isFilterContainerVisible(), "Filter Container is not visible");
		softAssert.assertTrue(inventoryPage.isInventoryContainerVisible(), "Inventory Container is not visible");
		softAssert.assertTrue(inventoryPage.isInventoryListVisible(), "Inventory List is not visible");
		softAssert.assertTrue(inventoryPage.isFilterCorrectByDefault(), "Filter is incorrect");
		softAssert.assertTrue(inventoryPage.isProductsStringCorrect(), "Products title is not correct");
		softAssert.assertAll();
	}
	
	public void isHeaderPageLoadad(SoftAssert softAssert) {
		HeaderPage headerPage = new HeaderPage(driver);
		softAssert.assertTrue(headerPage.isHeadContainerVisible(), "Head Container is not visible");
		softAssert.assertTrue(headerPage.isSwagLabLogoVisible(), "Head SwagLab Logo is not visible");
		softAssert.assertTrue(headerPage.isShoppingCartVisible(), "Head Shopping Cart is not visible");
		softAssert.assertTrue(headerPage.isBurgerMenuVisible(), "Head Burger Menu is not visible");
		softAssert.assertTrue(headerPage.isHeaderSecondContainerVisible(), "Header Second Container is not visible");
	}
	
}

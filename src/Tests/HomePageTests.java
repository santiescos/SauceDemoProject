package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

	@Test(description = "Verify all items are present with standard user")
	public void verifyAllItemsPresent() {
		logInPage.accessStandardUser();
		Assert.assertTrue(homePage.correctNumberOfITems());
	}
	
	@Test(description = "Verify add an item by its' name")
	public void addItemToCart() {
		
	}
}

package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogInTests extends BaseTest {
	
	@Test(description = "Verification of log in of standard user succesfull login")
	public void verifyLogInStandardUser() {
		SoftAssert softAssert = new SoftAssert();
		logInPage.accessStandardUser();
		commonAssertions.isInventoryPageLoaded(softAssert);
		commonAssertions.isHeaderPageLoadad(softAssert);
		softAssert.assertAll();
	}
	
	@Test(description = "Verification of log in of locked out user")
	public void verifyLogInLockedOutUser() {
		Assert.assertTrue(logInPage.accessLockedOutUser(), "Error message is not visible or does not match expected");
	}
	
	@Test(description = "Verification of log in of problem user")
	public void verifyLogInProblemUser() {
		SoftAssert softAssert = new SoftAssert();
		logInPage.accessProblemUser();
		commonAssertions.isInventoryPageLoaded(softAssert);
	}
	
	@Test(description = "Verification of log in of performance glitch user")
	public void verifyLogInPerformanceUser() {
		SoftAssert softAssert = new SoftAssert();
		logInPage.accessPerformanceGlitchUser();
		commonAssertions.isInventoryPageLoaded(softAssert);
	}
	
	@Test(description = "Verification of log in error user")
	public void verifyLogInErrorUser() {
		SoftAssert softAssert = new SoftAssert();
		logInPage.accessErrorUser();
		commonAssertions.isInventoryPageLoaded(softAssert);
	}
	
	@Test(description = "Verification of log in visual user")
	public void verifyLogInVisualUser() {
		SoftAssert softAssert = new SoftAssert();
		logInPage.accessVisualUser();
		commonAssertions.isInventoryPageLoaded(softAssert);
	}
	
	@Test(description = "Verification of log in wrong user")
	public void verifyLogInWrongUser() {
		Assert.assertTrue(logInPage.accessIncorrectUserWithRandomChars(), "Error message is not visible or does not match expected");
	}
	
}
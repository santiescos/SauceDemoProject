package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Tests.Helpers.ElementUtils;

public class HeaderPage {
	
	//By locators
	
	private final By headContainer = By.cssSelector("div[class='primary_header']");
	private final By swagLabsLogo = By.className("app_logo");
	private final By shoppingCartIcon = By.cssSelector("a[data-test='shopping-cart-link']");
	private final By burgerMenuIcon = By.xpath("//button[@type='button' and @id='react-burger-menu-btn']");
	private final By headerSecondContainer = By.cssSelector("div[class='header_secondary_container']");
	
	// Instance variables
	private WebDriver driver;
	ElementUtils elementUtils;
	
	public HeaderPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}


	public boolean isHeadContainerVisible() {return elementUtils.isElementVisible(headContainer);}
	
	public boolean isSwagLabLogoVisible() {return elementUtils.isElementVisible(swagLabsLogo);}  
	
	public boolean isShoppingCartVisible() {return elementUtils.isElementVisible(shoppingCartIcon);}
	
	public boolean isBurgerMenuVisible() {return elementUtils.isElementVisible(burgerMenuIcon);}
	
	public boolean isHeaderSecondContainerVisible() {return elementUtils.isElementVisible(headerSecondContainer);}

}

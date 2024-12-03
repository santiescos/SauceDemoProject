package PageObjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Tests.Helpers.ElementUtils;

public class ProductsPage {

	// By locators
	private final By products = By.cssSelector("div[class='inventory_item']");
	private final By productImage = By.cssSelector("div[class='inventory_item_img']");
    private final By productTitle = By.cssSelector(".inventory_item_name");
    private final By productDescription = By.cssSelector(".inventory_item_desc");
    private final By productPrice = By.cssSelector(".inventory_item_price");
    private final By productButton = By.cssSelector(".btn");
    private final By addProductToCart = By.className("btn_primary");
    private final By removeButton = By.className("btn_secondary");
	
	// Instance variables
	private WebDriver driver;
	ElementUtils elementUtils;
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}

	private List<String> productsName;

	public List<String> getItemsName() {
	    if (productsName == null) {
	        productsName = getAllProductsNames();
	    }
	    return productsName;
	}
	
	public List <WebElement> getAllProducts() {
		return driver.findElements(products);
	}
	
	public boolean correctNumberOfProducts() {
		return (getAllProducts().size() == 6);
	}

	public List <String> getAllProductsNames() {
		List <WebElement> products = getAllProducts();
		List <String> names = new ArrayList<>();
		for (WebElement product : products) {
			names.add(product.getText());
		}
		return names;
	}

	private double extractPriceAsDouble(String priceText) {
	    priceText = priceText.replace("$", "").replace(",", "").trim();
	    return Double.parseDouble(priceText);
	}
	
	public boolean isHiLoSorted(List<WebElement> productsAsElements, String value) {
		for (int i = 0; i < (productsAsElements.size()) - 1; i++) {
			double currentPrice = extractPriceAsDouble(productsAsElements.get(i).findElement(productPrice).getText());
			double nextPrice = extractPriceAsDouble(productsAsElements.get(i+1).findElement(productPrice).getText());
			switch (value) {
				case "hilo":
					if (currentPrice < nextPrice) {
						return false;
					}
					break;
				case "lohi":
					if (currentPrice > nextPrice) {
						return false;
					}
					break;
				default:
					return false;
			}		
		}
		return true;
	}
	
	public boolean addProductToCartByPartialTextAndVeriFyItsAdded(String partialProductText) {
		List <WebElement> products = getAllProducts();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getAttribute("id").contains(partialProductText)) { //This line needs rework
				driver.findElements(addProductToCart).get(i).click();
				if (driver.findElement(removeButton).getText().equals("Remove")) {
					return true;
				}
			}
		}
		return false;
	}
}	

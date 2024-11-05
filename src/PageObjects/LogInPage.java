package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Tests.Helpers.ElementUtils;


public class LogInPage {
	
	//By locators
	protected final By mainContainer = By.id("root");
    protected final By headerLogo = By.cssSelector("div[class='login_logo']");
    protected final By loginWrapper = By.cssSelector("div[class='login_wrapper-inner']");
    protected final By userInputField = By.cssSelector("input[placeholder='Username']");
    protected final By passwordInputField = By.cssSelector("[class='form_group'] [name='password']");
    protected final By logInButton = By.id("login-button");
    protected final By errorMessageField = By.cssSelector("input[class='error-message-container']");
    protected By availableUsers = By.cssSelector("div[class='login_credentials']");
    protected By redXUser = By.cssSelector("div[class='login-box'] div:nth-child(1) svg");
    protected By redXPassword = By.cssSelector("div[class='login_wrapper-inner'] div:nth-child(2) svg");
    protected By redXListOfElements = By.cssSelector("svg[class='svg-inline--fa fa-times-circle fa-w-16 error_icon']");
    protected By errorContainerLockedOutUser = By.cssSelector("h3[data-test='error']"); 
    protected final String standardUser = "standard_user";
    protected final String lockedOutUser = "locked_out_user";
    protected final String problemUser = "problem_user";
    protected final String performanceGlitchUser = "performance_glitch_user";
    protected final String errorUser = "error_user";
    protected final String visualUser = "visual_user";
    protected final String userPassword = "secret_sauce";
    protected final String errorMessageLockedOutUser = "Epic sadface: Sorry, this user has been locked out.";
    protected final String errorMessageWrongUser = "Epic sadface: Username and password do not match any user in this service";
    
    // Instance variables
	WebDriver driver;
	ElementUtils elementUtils;
	
	public LogInPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}

    
    public InventoryPage accessStandardUser() {
    	insertUser(standardUser);
    	enterPassword();
    	elementUtils.click(logInButton);
    	return new InventoryPage(driver);
    }
    
    public boolean accessLockedOutUser() {
    	insertUser(lockedOutUser);
    	enterPassword();
    	elementUtils.click(logInButton);
    	return (elementUtils.areElementsVisible(redXUser, redXPassword) && elementUtils.isTextCorrect(errorContainerLockedOutUser, errorMessageLockedOutUser));
    }
    
    public InventoryPage accessProblemUser() {
    	insertUser(problemUser);
    	enterPassword();
    	elementUtils.click(logInButton);
    	return new InventoryPage(driver);
    }
    
    public InventoryPage accessPerformanceGlitchUser() {
    	insertUser(performanceGlitchUser);
    	enterPassword();
    	elementUtils.click(logInButton);
    	return new InventoryPage(driver);
    }
    
    public InventoryPage accessErrorUser() {
    	insertUser(errorUser);
    	enterPassword();
    	elementUtils.click(logInButton);
    	return new InventoryPage(driver);
    }
    
    public InventoryPage accessVisualUser() {
    	insertUser(visualUser);
    	enterPassword();
    	elementUtils.click(logInButton);
    	return new InventoryPage(driver);
    }
    
    public boolean accessIncorrectUserWithRandomChars() {
    	insertUser(elementUtils.generateRandomString(8));
    	driver.findElement(passwordInputField).sendKeys(elementUtils.generateRandomString(8));
    	elementUtils.click(logInButton);
    	return (elementUtils.areElementsVisible(redXUser, redXPassword) && elementUtils.isTextCorrect(errorContainerLockedOutUser, errorMessageWrongUser));
    }
    
    public void insertUser(String user) {driver.findElement(userInputField).sendKeys(user);}
    
    public void enterPassword() {driver.findElement(passwordInputField).sendKeys(userPassword);}
}

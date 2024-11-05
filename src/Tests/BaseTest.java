package Tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.InventoryPage;
import PageObjects.LogInPage;
import Tests.Helpers.CommonAssertions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	WebDriver driver;
    protected final String landingURL = "https://www.saucedemo.com/";
    protected LogInPage logInPage;
    protected InventoryPage homePage;
    protected CommonAssertions commonAssertions;
    
    @BeforeClass
    public void initialize() {
    	driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	driver.manage().window().maximize();
    	accessLandingPage();
    	logInPage = new LogInPage(driver);
    	homePage = new InventoryPage(driver);
    	commonAssertions = new CommonAssertions(driver);
    }
    
    @BeforeMethod
    public void accessLandingPage() {
    	driver.get(landingURL);
    }
    
    @AfterClass
    public void shutDriverDown() {
    	driver.quit();
    }
}
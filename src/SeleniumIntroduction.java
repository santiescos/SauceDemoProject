import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntroduction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Invoke 
		// System.setProperty("webdriver.chrome.driver", "C:\\Users\\sesco\\Documents\\chromedriver-win64\\chromedriver.exe");
		// Object webdriver
		
		//final String miNombre = "Santiago Escosteguy";
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.youtube.com");
		driver.manage().window().maximize();
		
		// Allocating lupa as a variable
		final WebElement lupa = driver.findElement(By.cssSelector("button[id='search-icon-legacy'] yt-icon[class='style-scope ytd-searchbox'] div"));
		
		// Allocating searchbox as variable
		final WebElement searchbox = driver.findElement(By.xpath("//input[@id='search']"));
		
		searchbox.sendKeys("Juan Perotti");
		lupa.click();
		Thread.sleep(4000);
		
		
		
		//driver.quit();
		
		
		
		
		
	}

}

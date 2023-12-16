package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Incognito {
	
	WebDriver driver;
	String Url = "http://www.automationpractice.pl/index.php?";
	String PATH =  "..\\SaDemo\\Drivers\\chromedriver.exe";
	@BeforeSuite
	public void LoadDriver()
	{
		System.setProperty("webdriver.chrome.driver", PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito=True");
		driver = new ChromeDriver(options);
		driver.get(Url);
		
	}
	@Test
	public void SearchItem() 
	{
		WebElement txtSearch = driver.findElement(By.id("search_query_top"));
		txtSearch.sendKeys("Bluse");
		WebElement SubmitButton = driver.findElement(By.name("submit_search"));
		SubmitButton.click();
	}
	

}

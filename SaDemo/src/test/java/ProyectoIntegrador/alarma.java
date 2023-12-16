package ProyectoIntegrador;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class alarma {
	WebDriver driver;
	String URL = "https://demoqa.com/alerts";
	String Path = "..\\SaDemo\\Drivers\\chromedriver.exe";
	@BeforeSuite
	public void SetUp()
	{
		System.setProperty("webdriver.chrome.driver", Path);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get(URL);
		driver.manage().window().maximize();	
	}
	@Test
	public void ClickAlarm()
	{
		WebElement clickB = driver.findElement(By.id("alertButton"));
		clickB.click();
		driver.switchTo().alert().accept();
	}
	@AfterSuite
	public void closeBrowser()
	{
	      driver.close();	
	}
		
	
	
	

}

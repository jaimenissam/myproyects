package ProyectoIntegrador;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoadPage {
	
	WebDriver driver;
	String URL = "https://demo.guru99.com/test/upload/";
	String Path = "..\\SaDemo\\Drivers\\chromedriver.exe"; 
	@BeforeMethod
	public void EnterWebPage()
	{
		System.setProperty("webdriver.chrome.driver", Path);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get(URL);
		driver.manage().window().maximize();
		
	}
	@Test
	public void LoadFile() 
	{
		WebElement fileUp = driver.findElement(By.id("uploadfile_0"));
		fileUp.sendKeys("D:\\Images\\icons.png");
		WebElement CheckBox = driver.findElement(By.id("terms"));
		CheckBox.click();
		WebElement SubmitButton = driver.findElement(By.id("submitbutton"));
		SubmitButton.click();
		
		
		
	}
	@AfterMethod
	public void Close()
	{
		driver.close();
	}
	
	

}

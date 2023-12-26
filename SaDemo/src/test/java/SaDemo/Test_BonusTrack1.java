package SaDemo;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Test_BonusTrack1 {
	
	@Test
	public void formulario()
	
	{
		
			
			String URL = "https://www.saucedemo.com/";
			String PATH = "..\\SaDemo\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", PATH);
			WebDriver driver = new ChromeDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			WebElement txtUser=driver.findElement(By.id("user-name"));
			txtUser.sendKeys("standard_user");
			WebElement txtPassword = driver.findElement(By.id("password"));
			txtPassword.sendKeys("secret_sauce");
			WebElement btnSubmit = driver.findElement(By.id("login-button"));
			btnSubmit.click(); 
	
	}

}
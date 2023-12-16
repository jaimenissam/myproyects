package pruebas;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.*;
import java.util.Scanner;

import paginas.Login;


public class lab4_E1 {
	WebDriver driver;
	String Url = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
	String Path = "..\\SaDemo\\Drivers\\chromedriver.exe";
	Login logins;
	
	@BeforeSuite
	public void SetUp()
	{
		
		System.setProperty("webdriver.chrome.driver",Path);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);
        driver.get(Url);
        driver.manage().window().maximize();
		
		
	}
	
	@AfterSuite
	public void CloseBrowser() 
	{
	  
		driver.close();
	}
	@Test
	public void gotoLogin()
	{
		
		logins = new Login(driver);
		logins.EnterData("jaime@gmail.com", "password123");
		Assert.assertEquals(logins.getTextTitleForm(), "AUTHENTICATION");
	}
	
		
		
}

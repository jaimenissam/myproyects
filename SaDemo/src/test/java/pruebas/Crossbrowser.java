package pruebas;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Scanner;



public class Crossbrowser {
	
	WebDriver driver;
	String Url = "http://www.automationpractice.pl/index.php";
	String Path = "..\\SaDemo\\Drivers\\chromedriver.exe";
	WebDriverWait webDriverWait;
	String name;
	String lastname;

	
	@BeforeMethod
	public void SetUp()
	{
		
		Scanner Keyboard=new Scanner(System.in);
		System.out.println("Insert name");
		name = Keyboard.next();
		System.out.println("Insert lastname");
		lastname = Keyboard.next();
		
		System.setProperty("webdriver.chrome.driver",Path);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);
        driver.get(Url);
        driver.manage().window().maximize();
	}
	
	@Test
	public void Register() 
	{
		
		WebElement link = driver.findElement(By.linkText("Sign in"));
		link.click();
		WebElement TxtEmail = driver.findElement(By.id("email_create"));
		TxtEmail.sendKeys(name + lastname + "@" + "email.com");
		WebElement SubmitButton = driver.findElement(By.id("SubmitCreate"));
		SubmitButton.click();
		WebDriverWait ewait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement sexbutton = ewait.until(ExpectedConditions.elementToBeClickable(By.id("uniform-id_gender1")));
	    sexbutton.click();
	    WebElement TxtName = driver.findElement(By.id("customer_firstname"));
		TxtName.sendKeys(name);
		WebElement TxtLast = driver.findElement(By.id("customer_lastname"));
		TxtLast.sendKeys(lastname);
		//WebElement Email = driver.findElement(By.id("email"));
		WebElement Pass = driver.findElement(By.id("passwd"));
		Pass.sendKeys();
		WebElement drowdown = driver.findElement(By.id("days"));
		Select date = new Select(drowdown);
		date.selectByValue("4");
		WebElement drowdown1 = driver.findElement(By.id("months"));
		Select months = new Select(drowdown1);
		months.selectByValue("4");
		WebElement drowdown3 = driver.findElement(By.id("years"));
		Select years = new Select(drowdown3);
		years.selectByValue("2023");
		WebElement checkbox = driver.findElement(By.id("newsletter"));
		checkbox.click();
		WebElement Button = driver.findElement(By.id("submitAccount"));
		Button.click();
		
			
	}
	
	
	@AfterMethod
	public void CloseBrowser()
	{
		driver.close();
	
	}

}

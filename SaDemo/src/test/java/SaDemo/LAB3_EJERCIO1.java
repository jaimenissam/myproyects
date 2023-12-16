package SaDemo;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class LAB3_EJERCIO1 {
	
		
		WebDriver driver;
		String Url = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
	    String PATH = "..\\SaDemo\\Drivers\\chromedriver.exe";
	    @BeforeSuite
		public void SetUp() {
			System.setProperty("webdriver.chrome.driver", PATH);
			ChromeOptions options =  new ChromeOptions();
			options.addArguments("remote-allow-origins=*");
			driver = new ChromeDriver(options); 
		}
	    @BeforeTest
	    public void GoToUrl()
	    {
	    	
	    	driver.get(Url);
	    	
	    	
	      
	    }
	    @BeforeClass
	    public void MaximizeWindow()
	    {
	    	driver.manage().window().maximize();	
	    }
	    @Test(priority=1,description="Test Create Account")
	    public void loginIn()
	    {
	    	
	    	WebElement txt_Email = driver.findElement(By.id("emai_create"));
	    	txt_Email.sendKeys("my Email"+ Math.random()+ "@email.com");
	    	WebElement btnCreate = driver.findElement(By.id("SubmitCreate"));
	    	btnCreate.click();
	    	
	    	WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    	mywait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
	    	driver.findElement(By.id("id_gender")).click();
	    	
	    	WebElement txt_FirstName=driver.findElement(By.name("customer_firstname"));
			txt_FirstName.sendKeys("Jaime");
			
			driver.findElement(By.name("passwd")).sendKeys("123456"); 
			
			Select months= new Select(driver.findElement(By.id("months")));
			months.selectByValue("4");
			
			driver.findElement(By.xpath("//*[text()='Register']")).click();
			
			AssertJUnit.assertEquals("http://www.automationpractice.pl/index.php?controller=authentication", driver.getCurrentUrl());
		}
	    @AfterMethod
	    public void Screenshot () throws Exception 
	    {
	    	File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen, new File("...\\SaDemo\\Evidencias\\pantalla.png"));
	    	
	    }
	    @AfterClass
	    public void endTest() {
	    	System.out.println("End Test");
	    	
	    }
	    @AfterTest
	    public void CloseBrowser() {
	    	
	    	
	    }
	    @AfterSuite
	    public void findSuite()
	    {
	    	System.out.println("End Suite");      
	    }
	   
	    
}



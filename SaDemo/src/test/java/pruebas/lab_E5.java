package pruebas;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import paginas.Login;

public class lab_E5 {

	WebDriver driver;
	Login logins;
	String driverPath="..\\SaDemo\\Drivers\\chromedriver.exe";
	String url="http://automationpractice.pl/index.php?controller=authentication&back=my-account";
	@BeforeSuite
	public void EnterWebpage()
	{
		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);	
    	driver.get(url);
		
	}
	@AfterSuite
	public void closeBrowser() 
	{
	   driver.close();	
	}
	@Test(dataProvider="Datos Login")
	public void GotoAccess(String User , String password) 
	{
		logins = new Login(driver);
		logins.EnterData(User, password);
		AssertJUnit.assertEquals(logins.getTextTitleForm(), "AUTHENTICATION");
	}
	@DataProvider(name="Datos Login")
	public Object [][] getData(){
		Object [][] data = new Object[3][2];
		data[0][0] = "test@gmail.com"; data[0][1]="123457";
		data[1][0] = "test1@gmail.com"; data[1][1]="1234578";
		data[2][0] = "test2@gmail.com"; data[2][1]="1234579";
		return data;
		
	}
}

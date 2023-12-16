package ProyectoIntegrador;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;

public class imprimirCelda {
	WebDriver driver;
	String path = "..\\SaDemo\\Drivers\\chromedriver.exe";
	String url = "http://demo.guru99.com/test/table.html";
	String locator = "webdriver.chrome.driver";
	@BeforeSuite
	public void setUp()
	{
		System.setProperty(locator, path);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		options.addArguments("incognite");
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	@Test
	public void SelectBoard()
	{
		 WebElement rowsNumber = driver.findElement(By.xpath("//tbody/tr[4]/td[3]"));
		 Assert.assertEquals(rowsNumber.getText(),"8");
		 System.out.println(rowsNumber);
		 
	}
	@AfterSuite
	public void CloseBrowser()
	{
		driver.close();
	}
		

}

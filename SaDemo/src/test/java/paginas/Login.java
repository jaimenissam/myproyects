package paginas;
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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import java.util.Scanner;

public class Login {
	@FindBy(id="email")
	WebElement TxtEmail;
	@FindBy(id="passwd")
	WebElement Txtpasswd;
	@FindBy(id="SubmitLogin")
    WebElement SubmitBtn;
	@FindBy(xpath="//h1[contains(text(),'Authentication']")
	WebElement titleForm;
	
	
	public Login(WebDriver driver) {
		
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
	}
	public void EnterData(String email , String Password)
	{
		TxtEmail.clear();
		TxtEmail.sendKeys(email);
		Txtpasswd.clear();
		Txtpasswd.sendKeys(Password);
		SubmitBtn.click();
	}
	public String getTextTitleForm() {
		
		return titleForm.getText();
	}
	
	

}

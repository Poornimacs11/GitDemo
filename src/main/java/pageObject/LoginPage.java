package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By Email = By.id("email");	
	By Password = By.id("password");
	By SubmitButton = By.xpath("//input[@type='submit']");
	By forgotPass = By.xpath("//a[text()='Forgot Password']");
	
	public LoginPage(WebDriver driver)
	{
		
		this.driver = driver;
	}
	
	public ForgotPass forgotPass()
	{
		driver.findElement(forgotPass).click();
		return new ForgotPass(driver);
		
	}
	
	public WebElement getId()
	{
		return driver.findElement(Email);
	}
	
	
	public WebElement getPass()
	{
		return driver.findElement(Password);
	}
	
	
	public WebElement getLogin()
	{
		return driver.findElement(SubmitButton);
	}

}

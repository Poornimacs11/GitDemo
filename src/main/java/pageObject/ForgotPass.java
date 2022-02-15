package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPass {
	
	public WebDriver driver;
	
	By Email = By.id("email");	
	By NextBtun = By.cssSelector("[type='submit']");
		
	public ForgotPass(WebDriver driver)
	{
		
		this.driver = driver;
	}
	
	
	public WebElement getId()
	{
		return driver.findElement(Email);
	}
	
	public WebElement NextBtun()
	{
		return driver.findElement(NextBtun);
	}
	

}

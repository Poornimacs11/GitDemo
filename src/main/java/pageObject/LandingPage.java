package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		
		this.driver = driver;
	}
	
	By login = By.cssSelector(".theme-btn.register-btn");
	By title = By.xpath("//div/h2[text()='Featured Courses']");
	
	By navTab = By.cssSelector(".nav-outer.clearfix");
	
	public LoginPage getLogin()
	{
		
		 driver.findElement(login).click();
		 LoginPage l = new LoginPage(driver);
		 return l;
	}
	
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNav()
	{
		return driver.findElement(navTab);
	}

}

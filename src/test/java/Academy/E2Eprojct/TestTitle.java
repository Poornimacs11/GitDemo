package Academy.E2Eprojct;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class TestTitle extends base {
	private static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	@BeforeMethod
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
	}
	
	
	
	@Test
	
	public void titleCapture() throws IOException
	{
		
		
		LandingPage lp= new LandingPage(driver);
		//one way to call the methods of other classes is inhertiance
		//another way is creating object for that class and call using the object
		
		Assert.assertEquals(lp.getTitle().getText(), "Featured Courses12");
		
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
}

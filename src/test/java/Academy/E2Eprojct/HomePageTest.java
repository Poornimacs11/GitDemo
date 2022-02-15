package Academy.E2Eprojct;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPass;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class HomePageTest extends base {
	private static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	@BeforeMethod
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Driver initialized");	}
	
	
	@Test(dataProvider = "getData")
	
	public void homePageLogin(String UserName, String Password) throws IOException//give the parameter as same as column number
	{
			
		LandingPage lp= new LandingPage(driver);
		LoginPage l = lp.getLogin();
		l.getId().sendKeys(UserName);
		l.getPass().sendKeys(Password);
		
		log.info("Login validation");
		
		l.getLogin().click();
		
		ForgotPass fp = l.forgotPass();
		fp.getId().sendKeys("shivani@amz.com");
		fp.NextBtun().click();
		
	}
	
	@DataProvider()
	public Object[][] getData()
	{
		//row stands for how many different data types test should run
		//column stands for how many values we pass per test
		
		Object[][] data = new Object[2][2];
		data[0][0] = "restriced@aq.com";
		data[0][1] ="231kns";
		
		
		data[1][0] ="alloweduser@aq.com";
		data[1][1] ="45678gv";
		
		return data;
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}

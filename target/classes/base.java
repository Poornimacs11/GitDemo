package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class base {

	public WebDriver driver;
	public Properties prop;
	private Logger log;
	
		
public WebDriver initializeDriver() throws IOException
{
	prop = new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\poorn\\E2Eprojct\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	String browserName =prop.getProperty("browser");
	
	if(browserName.equals("chrome"))
	{
		//execute in chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
					
	}
	else if(browserName.equals("firefox"))
	{
//		//Firefox
//		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
//		driver = new FirefoxDriver();

	}
	
	else if(browserName.equals("IE"))
	{
		//IE code
//		System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
//		driver = new EdgeDriver();

	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	return driver;

	
}

public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
}


}

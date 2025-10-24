package Framework.Framework.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Framework.Framework.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage lp;
	
	public WebDriver initializeDriver() throws IOException
	{
		//File file = new File("./GlobalData.properties");
		
		FileInputStream fis = new FileInputStream("C:\\study\\projects\\Framework\\src\\main\\java\\Framework\\Framework\\resources\\GlobalData.properties");
		
		Properties p1 = new Properties();
		
		p1.load(fis);
		
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : p1.getProperty("browser");
				//p1.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			ChromeOptions op = new ChromeOptions();
			
			if(browserName.contains("headless"))
				{
					op.addArguments("--headless");
				}		
			
			driver = new ChromeDriver(op);
			
			driver.manage().window().setSize(new Dimension(1440,900));
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			 driver = new FirefoxDriver();			
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			 driver = new EdgeDriver();			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;		
		
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".//screenshot//"+testCaseName+"screenshot.png");
		
		FileUtils.copyFile(src, trg);
		return ".//screenshot//screenshot.png";
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApp() throws IOException
	{
		driver = initializeDriver();
		
		lp = new LandingPage(driver);
		
		lp.goTo();	
		return lp;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
	}

}

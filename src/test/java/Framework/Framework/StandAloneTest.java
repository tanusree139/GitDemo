package Framework.Framework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;

public class StandAloneTest {
	
	@Test
	public void addToCart() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		//LandingPage Lp = new LandingPage(driver);
		
		driver.findElement(By.id("userEmail")).sendKeys("tsroy0022@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("userPassword")).sendKeys("Test@1234");
		Thread.sleep(2000);
		
		driver.findElement(By.id("login")).click();
		
		String productName = "IPHONE 13 PRO";
		
		WebDriverWait w1 = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body")));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".card-body"));
		
		for (WebElement e:products)
		{
			String s1 = e.findElement(By.cssSelector("b")).getText().trim();
			
			System.out.println("product name is =="+s1);
			//Thread.sleep(1000);
			
			if(s1.equals(productName)) //ZARA COAT 3  ,  ADIDAS ORIGINAL
				//Thread.sleep(1000);
			{
				//WebElement product = e.findElement(By.cssSelector(".w-10"));
				WebElement product = e.findElement(By.cssSelector(".card-body button:last-of-type"));
				product.click();
			}
		}
		
		
		
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		w1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> productList = driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean match=false;
		
		for(WebElement e:productList)
		{
			String s1 = e.getText();
			 if(s1.equalsIgnoreCase(productName))
			 {
				 match= true;
			 }
		}
		
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions a= new Actions(driver);
		
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").perform();
		
		w1.until(ExpectedConditions.visibilityOfElementLocated
				(By.cssSelector(".ta-results:nth-of-type(1)")));
		
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String msg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));
		
		driver.quit();
		
		}
	
	
}

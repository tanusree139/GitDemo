package Framework.Framework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framework.Framework.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	
	String productName = "IPHONE 13 PRO";
	
	@Test(dataProvider="credentials",groups="Purchase")
	public void addToCart(String email,String pwd) throws InterruptedException, IOException
	{
		initializeDriver();
		
		//driver.get("https://rahulshettyacademy.com/client");
		
		LandingPage lp = launchApp();
		
		//lp.goTo();			
		//String productName = "IPHONE 13 PRO";
		
		//ProductCatalogue pc = lp.loginApplication("tsroy0022@gmail.com", "Test@1234");
		ProductCatalogue pc = lp.loginApplication(email, pwd);
		List<WebElement>products = pc.getProductList();
		
		pc.addProductToCart(productName);
		
		CartPage cp = pc.goToCartPage();
		
		//CartPage cp = pc.goToCartPage();
		
		Boolean match = cp.verifyProductByName(productName);
		
		//WebDriverWait w1 = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		//w1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body")));
		
		//List<WebElement> products = driver.findElements(By.cssSelector(".card-body"));
		
		/*for (WebElement e:products)
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
		}*/
		
		//Thread.sleep(3000);
		
		//w1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		//w1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		/*List<WebElement> productList = driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean match=false;
		
		for(WebElement e:productList)
		{
			String s1 = e.getText();
			 if(s1.equalsIgnoreCase(productName))
			 {
				 match= true;
			 }
		}*/
		
		Assert.assertTrue(match);
		
		CheckOutPage cop = cp.goToCheckOutPage();
		
		cop.selectCountryAtcheckOutPage("india");
		
		ConfirmationPage conPage = cop.placeOrder();
		
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		
		//Actions a= new Actions(driver);
		
		//a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").perform();
		
		//w1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results:nth-of-type(1)")));
		
		//driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		
		//driver.findElement(By.cssSelector(".action__submit")).click();
		
		String conMsg = conPage.getConfirmMsg();		
		
		Assert.assertTrue(conMsg.equalsIgnoreCase("Thankyou for the order."));		
		
		}
	
	@Test(dependsOnMethods="addToCart")
	
	public void orderHistory()
	{
		System.out.println("this is dependsOnMethods=SubmitOrderTest method"+productName);
	}
	
	
	
	@DataProvider(name="credentials")
	public Object[][] getData()
	{
		 Object[][] data=  {{"tsroy0022@gmail.com", "Test@1234"},{"tsroy00@gmail.com", "Test@1234"}};
		 
		 return data;
	}

}

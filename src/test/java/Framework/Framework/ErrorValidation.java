package Framework.Framework;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import Framework.Framework.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {
	
	@Test(groups={"errorHandling"},retryAnalyzer=Framework.Framework.TestComponents.Retry.class)
	public void inCorrectCredValidation() throws InterruptedException, IOException
	{
			
		String productName = "IPHONE 13 PRO";
		
		lp.loginApplication("tsroy@gmail.com", "Test@1234");
		
		Assert.assertEquals("Incorrect email or password.", lp.getErrorMsg());
				
		}
	
	@Test(retryAnalyzer=Framework.Framework.TestComponents.Retry.class)
	
	public void productErrValidation()
	{
		String productName = "IPHONE 13 PRO";
		ProductCatalogue pc = lp.loginApplication("tsroy0022@gmail.com", "Test@1234");
		List<WebElement>products = pc.getProductList();
		
		pc.addProductToCart(productName);
		
		CartPage cp = pc.goToCartPage();
		
		Boolean match = cp.verifyProductByName("IPHONE PRO");
		
		Assert.assertTrue(match);
	}
}

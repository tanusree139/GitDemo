package Framework.Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.Framework.AbstractComponents.AbstractComenets;

public class CartPage extends AbstractComenets {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
		
	//Page factory locator
	
	@FindBy(css=".cartSection h3")
	List<WebElement> productList;
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	@FindBy(css=".totalRow button")
	WebElement checkOutPage;
	
	
	public Boolean verifyProductByName(String productName)
	{
		Boolean match=false;
		for (WebElement e:productList)
		{
			String s1 = e.getText();
			
			if(s1.equalsIgnoreCase(productName))
			 {
				 match= true;
			 }
		}
		return match;
	}
	
	public CheckOutPage goToCheckOutPage()
	{
		checkOutPage.click();
		
		CheckOutPage cop = new CheckOutPage(driver);
		return cop;
	}
	
}

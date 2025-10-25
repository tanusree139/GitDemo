package Framework.Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.Framework.AbstractComponents.AbstractComenets;

public class ProductCatalogue extends AbstractComenets {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		
	//Page factory locator
	
	@FindBy(css=".card-body")
	List<WebElement> products;
	
	
	
	By productList = By.cssSelector(".card-body");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMsg = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productList);
		
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement product=null;
		for (WebElement e:getProductList())
		{
			String s1 = e.findElement(By.cssSelector("b")).getText().trim();
			
			System.out.println("product name is =="+s1);
			//Thread.sleep(1000);
			
			if(s1.equals(productName)) //ZARA COAT 3  ,  ADIDAS ORIGINAL
				//Thread.sleep(1000);
			{
				//WebElement product = e.findElement(By.cssSelector(".w-10"));
				product = e.findElement(addToCart);	
				
			}
		}
		return product;
	}
	
	public void addProductToCart(String productName)
	{
		WebElement product = getProductByName(productName);
		product.click();
		waitForElementToAppear(toastMsg);
		
		waitForElementToDisappear(toastMsg);
	}
	
}

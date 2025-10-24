package Framework.Framework.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.Framework.CartPage;

public class AbstractComenets {
	
	WebDriver driver;
	
	public AbstractComenets(WebDriver driver) {
		
		this.driver=driver;	
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[routerlink*='cart']") 
	WebElement cartHeader;

	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait w1 = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		w1.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait w1 = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		w1.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDisappear(By findBy)
	{
		WebDriverWait w1 = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		w1.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		
		CartPage cp = new CartPage(driver);
		return cp;
	}

}

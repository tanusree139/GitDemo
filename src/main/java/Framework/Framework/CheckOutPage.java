package Framework.Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.Framework.AbstractComponents.AbstractComenets;

public class CheckOutPage extends AbstractComenets {
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
		
	//Page factory locator
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectCountry;
	
	By selectCountry1 = By.cssSelector(".ta-item:nth-of-type(2)");
	
	@FindBy(css=".action__submit")
	WebElement submitBtn;
	
	
	public void selectCountryAtcheckOutPage(String countryName)
	{
		Actions a= new Actions(driver);
		
		a.sendKeys(country, countryName).perform();
		
		//w1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results:nth-of-type(1)")));
		waitForElementToAppear(selectCountry1);
		selectCountry.click();
	}
	
	public ConfirmationPage placeOrder()
	{
		submitBtn.click();
		
		ConfirmationPage conPage = new ConfirmationPage(driver);
		return conPage;
	}
	
}

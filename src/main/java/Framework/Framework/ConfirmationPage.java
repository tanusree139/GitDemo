package Framework.Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.Framework.AbstractComponents.AbstractComenets;

public class ConfirmationPage extends AbstractComenets {
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
		
	//Page factory locator
	
	@FindBy(css=".hero-primary")
	WebElement confirmMsg;
	
	public String getConfirmMsg()
	{
		String msg = confirmMsg.getText();
		
		return msg;
	}
	
	
}

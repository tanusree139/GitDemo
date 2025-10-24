package Framework.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.Framework.AbstractComponents.AbstractComenets;

public class LandingPage extends AbstractComenets{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement username = driver.findElement(By.id("userEmail"));	
	//WebElement password = driver.findElement(By.id("userPassword"));	
	//WebElement btn = driver.findElement(By.id("login"));
	
	//Page factory locator
	
	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement btn;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errMsg;
	
	public ProductCatalogue loginApplication(String email,String pwd)
	{
		username.sendKeys(email);
		password.sendKeys(pwd);
		btn.click();
		ProductCatalogue pc = new ProductCatalogue(driver);
		return pc;
	}
	
	public String getErrorMsg()
	{
		waitForWebElementToAppear(errMsg);
		return errMsg.getText();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

}

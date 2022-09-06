package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class HomePage extends PageBase
{
	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
	}
	
	
	@FindBy( css  ="button#ACCOUNT.btn.btn-primary.dropdown-toggle.waves-effect" )
	WebElement AccountBtn; 
	
	@FindBy(linkText="Customer Login")
	WebElement CustomerLogin; 
	
	@FindBy(linkText="Customer Signup")
	WebElement CustomerSignup; 
	
	
	
	public void openRegistrationPage() 
	{
		//clickButton(AccountBtn);
		action.moveToElement(AccountBtn).click().build().perform();
		clickButton(CustomerSignup);
	}
	
	public void openLoginPage() 
	{
		//clickButton(AccountBtn);
		action.moveToElement(AccountBtn).click().build().perform();
		clickButton(CustomerLogin);
	}
	
	

}

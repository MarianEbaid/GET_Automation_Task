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
	
	
	@FindBy( linkText  ="Course Registration" )
	WebElement CourseRegistrationBtn; 
	
	@FindBy(linkText ="Registration Form")
	WebElement RegistrationForm; 
		
	
	public void openRegistrationPage() 
	{
		clickButton(CourseRegistrationBtn);
		clickButton(RegistrationForm);
		//action.moveToElement(CourseRegistrationBtn).click().build().perform();
		//action.moveToElement(RegistrationForm).click().build().perform();
	}
	
	
	

}

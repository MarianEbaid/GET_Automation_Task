package pages;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.*;


public class RegistrationPage extends PageBase 
{
	public RegistrationPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
		wait = new WebDriverWait(driver, Duration.ofSeconds(3500));	
	}
	
	
	@FindBy(id = "nf-field-17")
	WebElement fnTxtBox; 
	
	@FindBy(id = "nf-field-18")
	WebElement lnTxtBox ; 
	
	@FindBy(id = "nf-field-20")
	WebElement phoneTxtBox ; 
	
	@FindBy(id = "nf-field-19")
	WebElement emailTxtBox ; 	
	
	@FindBy(id = "nf-field-22")
	WebElement courseMenu ; 
	
	@FindBy(id = "nf-field-24")
	WebElement monthMenu ;
	
	@FindBy(id = "nf-field-23-1")
	WebElement knowAboutRdoBtn ; 
	
	@FindBy(id = "nf-field-15")
	WebElement registerBtn ; 
	
	@FindBy(className  = "nf-response-msg")
	public WebElement successMessage ; 
	
	@FindBy(id  = "nf-error-17")
	public WebElement fnReqMessage ;
	
	@FindBy(id  = "nf-error-18")
	public WebElement lnReqMessage ; 
	
	@FindBy(id  = "nf-error-19")
	public WebElement emailReqMessage ;
	
	@FindBy(id  = "nf-error-19")
	public WebElement emailInvalidMessage ; 
	
	@FindBy(id  = "nf-error-23")
	public WebElement knwAbtInvalidMessage ; 
	
	public void userRegistration(String firstName, String lastName, String email, String phone, String course, String month)
	
	{
		fnTxtBox.clear();
		lnTxtBox.clear();
		emailTxtBox.clear();
		phoneTxtBox.clear();
		
		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lnTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(phoneTxtBox, phone);
		
		Select courseName = new Select(courseMenu);
		courseName.selectByValue(course);
		
		Select monthName = new Select(monthMenu);
		monthName.selectByValue(month);
		
		jse.executeScript("arguments[0].click();", knowAboutRdoBtn);
		//clickButton(referralRdoBtn);

		clickButton(registerBtn);
		
	}
	
public void userRegistrationWithoutRdo(String firstName, String lastName, String email, String phone, String course, String month)
	
	{
		fnTxtBox.clear();
		lnTxtBox.clear();
		emailTxtBox.clear();
		phoneTxtBox.clear();
		
		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lnTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(phoneTxtBox, phone);
		
		Select courseName = new Select(courseMenu);
		courseName.selectByValue(course);
		
		Select monthName = new Select(monthMenu);
		monthName.selectByValue(month);
		
		//jse.executeScript("arguments[0].click();", knowAboutRdoBtn);
		//clickButton(referralRdoBtn);

		clickButton(registerBtn);
		
	}
	
	
}

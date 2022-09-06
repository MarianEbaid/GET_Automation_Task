package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends PageBase 
{
	public RegistrationPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
	}
	
	
	@FindBy(id = "nf-field-17")
	WebElement fnTxtBox; 
	
	@FindBy(id = "nf-field-18")
	WebElement lnTxtBox ; 
	
	@FindBy(id = "nf-field-20")
	WebElement phoneTxtBox ; 
	
	@FindBy(id = "nf-field-19")
	WebElement emailTxtBox ; 
	
	//@FindBy(name="password")
	//WebElement passwordTxtBox ; 
	
	@FindBy(id = "nf-field-22")
	WebElement courseMenu ; 
	
	@FindBy(id = "nf-field-24")
	WebElement monthMenu ;
	
	@FindBy(id = "nf-label-class-field-23-1")
	WebElement referralRdoBtn ; 
	
	
	//@FindBy(className="recaptcha-checkbox-checkmark")
	//WebElement recaptchaChkBox ; 
	
	
	@FindBy(id = "nf-field-15")
	WebElement registerBtn ; 
	
	@FindBy(css="div.nf-response-msg")
	public WebElement successMessage ; 
	
	//@FindBy(className="nf-error-msg nf-error-required-error")
	//public WebElement requiredMessage ; 
	
	//@FindBy(css ="button.btn.btn-default.btn-lg.btn-block.effect.ladda-button.waves-effect")
	//public WebElement loginBtn; 
	
	//@FindBy(className="author__meta")
	//public WebElement WelcomeMessage; 
	
	
	
	public void userRegistration(String firstName, String lastName, String phone, String email, String course, String month)
	//, String accountType) 
	{
		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lnTxtBox, lastName);
		setTextElementText(phoneTxtBox, phone);
		setTextElementText(emailTxtBox, email);
		//setTextElementText(passwordTxtBox, password);
		
		Select courseName = new Select(courseMenu);
		courseName.selectByValue(course);
		
		Select monthName = new Select(monthMenu);
		monthName.selectByValue(month);
		
		//scrollIntoElement(referralRdBtn);
		clickButton(referralRdoBtn);
		
		/*
		//scrollIntoElement(accountTypeMenu);		
		//action.moveToElement(accountTypeMenu).click().build().perform();
		
		scrollIntoElement(customerType);
		action.moveToElement(customerType).click().build().perform();
		
		scrollIntoElement(recaptchaChkBox);
		recaptchaChkBox.click();
		*/
		//scrollIntoElement(registerBtn);
		//scrollToBottom() ;
		clickButton(registerBtn);
		System.out.println(successMessage.getText());
	}
	/*
	public void userLogin (String email , String password) 
	{
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		clickButton(loginBtn);
	}
	*/
	
}

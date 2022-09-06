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
	
	@FindBy(id = "input#nf-field-23-1.ninja-forms-field.nf-element")
	WebElement referralRdoBtn ; 

	
	@FindBy(id = "nf-field-15")
	WebElement registerBtn ; 
	
	@FindBy(id ="nf-form-3-cont")
	public WebElement successMessage ; 
	
	
	
	public void userRegistration(String firstName, String lastName, String email, String phone, String course, String month)
	//, String accountType) 
	{
		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lnTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(phoneTxtBox, phone);
		

		Select courseName = new Select(courseMenu);
		courseName.selectByValue(course);
		
		Select monthName = new Select(monthMenu);
		monthName.selectByValue(month);
		
		
		referralRdoBtn.click();

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

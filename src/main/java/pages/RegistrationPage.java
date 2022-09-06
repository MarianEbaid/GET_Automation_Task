package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class RegistrationPage extends PageBase 
{
	public RegistrationPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
		wait = new WebDriverWait(driver, Duration.ofSeconds(3500));	
		//waitDriver(driver);
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
	WebElement referralRdoBtn ; 
	
	@FindBy(id = "nf-field-15")
	WebElement registerBtn ; 
	
	@FindBy(className  = "nf-response-msg")
	public WebElement successMessage ; 
	/*
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)                            
			.withTimeout(Duration.ofSeconds(3500))          
			.pollingEvery(Duration.ofSeconds(3500))          
			;    

			 WebElement successMessagee = wait.until(new Function<WebDriver, WebElement>() {       
			public WebElement apply(WebDriver driver) { 
			return driver.findElement(By.className("nf-response-msg"));     
			 }  
			});  
*/
	
	
	public void userRegistration(String firstName, String lastName, String email, String phone, String course, String month)
	
	{
		
		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lnTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(phoneTxtBox, phone);
		

		Select courseName = new Select(courseMenu);
		courseName.selectByValue(course);
		
		Select monthName = new Select(monthMenu);
		monthName.selectByValue(month);
		
		jse.executeScript("arguments[0].click();", referralRdoBtn);
		//clickButton(referralRdoBtn);

		clickButton(registerBtn);
		
		//action.pause(Duration.ofSeconds(3500));	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nf-response-msg")));
		
		
		
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

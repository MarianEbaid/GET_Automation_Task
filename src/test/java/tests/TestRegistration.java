package tests;



import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class TestRegistration extends TestBase
{
	HomePage homeObject ; 
	RegistrationPage registerObject ; 
	LoginPage loginObject ; 
	String ReqMessage = "This is a required field.";
	String successMsg = "Thank you for registering for our event.";

	// Registration with all valid data
	@Test(priority=1,alwaysRun=true)
	public void ValidRegistrationTest() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan","test@hotmail.com", "01225369841", "selenium-automation","april");
		
		registerObject.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nf-response-msg")));
		Assert.assertTrue(registerObject.successMessage.getText().contains(successMsg));
	}
	
	
	// Registration without providing user first name field
	@Test(priority=2,alwaysRun=true)
	public void EmptyFNameRegistrationTest() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("", "Sultan","test@hotmail.com", "01225369841", "selenium-automation","april");
		
		Assert.assertTrue(registerObject.fnReqMessage.getText().contains(ReqMessage));
	}
	
	// Registration with invalid user first name field (begins with small letter)
	@Test(priority=3,alwaysRun=true)
	public void InvalidFNameRegistrationTest() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver); 
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("marian", "Sultan","test@hotmail.com", "01225369841", "selenium-automation","april");
		
		registerObject.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nf-response-msg")));
		Assert.assertFalse(registerObject.successMessage.getText().contains(successMsg));
	}
	
	// Registration without providing user last name field
	@Test(priority=4,alwaysRun=true)
	public void EmptyLNameRegistrationTest() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "", "test@hotmail.com", "01225369841", "selenium-automation","april");

		Assert.assertTrue(registerObject.lnReqMessage.getText().contains(ReqMessage));
	}
	
	// Registration with invalid user last name field (begins with small letter)
	@Test(priority=5,alwaysRun=true)
	public void InvalidLNameRegistrationTest() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "sultan", "test@hotmail.com", "01225369841", "selenium-automation","april");
		
		registerObject.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nf-response-msg")));
		Assert.assertFalse(registerObject.successMessage.getText().contains(successMsg));
	}
	

	// Registration without providing user email field
	@Test(priority=6,alwaysRun=true)
	public void EmptyEmailRegistrationTest() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan", "", "01225369841", "selenium-automation","april");
			
		Assert.assertTrue(registerObject.emailReqMessage.getText().contains(ReqMessage));
	}
		
	// Registration with email id which already have account
	@Test(priority=7,alwaysRun=true)
	public void ExistedEmailRegistrationTest() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan", "test@hotmail.com", "01225369841", "selenium-automation","april");
		
		registerObject.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nf-response-msg")));			
		Assert.assertFalse(registerObject.successMessage.getText().contains(successMsg));	
	}		

	// Registration with invalid user email field (doesn't contain @symbol)
	@Test(priority=8,alwaysRun=true)
	public void InvalidEmailRegistrationTest() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan", "test.com", "01225369841", "selenium-automation","april");
		
		String expectedErrorMsg = "Please enter a valid email address!";
		Assert.assertTrue(registerObject.emailInvalidMessage.getText().contains(expectedErrorMsg));
		
	}

		
	// Registration with invalid user email field (doesn't contain dot)
	@Test(priority=9,alwaysRun=true)
	public void InvaldEmailRegistrationTest() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		
		registerObject.userRegistration("Marian", "Sultan", "test@com", "01225369841", "selenium-automation","april");
		
		String expectedErrorMsg = "Please enter a valid email address!";
		Assert.assertTrue(registerObject.emailInvalidMessage.getText().contains(expectedErrorMsg));
		
		registerObject.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nf-response-msg")));
		Assert.assertFalse(registerObject.successMessage.getText().contains(successMsg));	
		
	}
		
					
}

package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.HomePage;
import pages.RegistrationPage;

public class TestLogin extends TestBase
{
	HomePage homeObject ; 
	RegistrationPage registerObject ; 
	
	String successMsg = "Thank you for registering for our event.";
	String ReqMessage = "This is a required field.";
	String invalidEmailErrorMsg = "Please enter a valid email address!";

	// Registration with all valid data
	@Test(priority=1,alwaysRun=true)
	public void ValidRegistrationTest() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan","test@example.com", "01225369841", "selenium-automation","april");
		
		registerObject.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nf-response-msg")));
		Assert.assertTrue(registerObject.successMessage.getText().contains(successMsg));
	}
	
	// Registration with all valid data
	@Test(priority=2,alwaysRun=true)
	public void InValidRegistrationTest() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistrationWithoutRdo("", "","", "01225369841", "selenium-automation","april");
		
		String ExcpectedReqMsg = "Please correct errors before submitting this form.";
		Assert.assertTrue(registerObject.ReqErrorMessage.getText().contains(ExcpectedReqMsg));
		
		Assert.assertTrue(registerObject.fnReqMessage.getText().contains(ReqMessage));
		Assert.assertTrue(registerObject.lnReqMessage.getText().contains(ReqMessage));
		Assert.assertTrue(registerObject.emailReqMessage.getText().contains(ReqMessage));
	}
	
	// Registration without providing user first name field
	@Test(priority=3,alwaysRun=true)
	public void EmptyFNameRegistrationTest() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("", "Sultan","test@example.com", "01225369841", "selenium-automation","april");
		
		Assert.assertTrue(registerObject.fnReqMessage.getText().contains(ReqMessage));
	}
	
	// Registration without providing user last name field
	@Test(priority=4,alwaysRun=true)
	public void EmptyLNameRegistrationTest() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "", "test@example.com", "01225369841", "selenium-automation","april");

		Assert.assertTrue(registerObject.lnReqMessage.getText().contains(ReqMessage));
	}
	
//////////////////////////////////////////////////Email Validation - Positive Scenarios//////////////////////////////////
	// Registration with valid email field (contains a dot in the address field)
	@Test(priority=5,alwaysRun=true)
	public void ValidEmailRegistrationTest() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan", "test.test@example.com", "01225369841", "selenium-automation","april");
		
		registerObject.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nf-response-msg")));			
		Assert.assertTrue(registerObject.successMessage.getText().contains(successMsg));	
	}	
	
	// Registration with valid email field (contains dot with subdomain)
	@Test(priority=6,alwaysRun=true)
	public void ValidEmailRegistrationTest2() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan", "test@subdomain.example.com", "01225369841", "selenium-automation","april");
		
		registerObject.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nf-response-msg")));			
		Assert.assertTrue(registerObject.successMessage.getText().contains(successMsg));	
	}	
	
	// Registration with valid email field (With the Plus sign is considered a valid character)
	@Test(priority=7,alwaysRun=true)
	public void ValidEmailRegistrationTest3() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan", "test+test@example.com", "01225369841", "selenium-automation","april");
		
		registerObject.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nf-response-msg")));			
		Assert.assertTrue(registerObject.successMessage.getText().contains(successMsg));	
	}
	
	// Registration with valid email field (With Quotes around the email is considered valid)
	@Test(priority=8,alwaysRun=true)
	public void ValidEmailRegistrationTest4() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan", "\"test\"@example.com", "01225369841", "selenium-automation","april");
		
		registerObject.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nf-response-msg")));			
		Assert.assertTrue(registerObject.successMessage.getText().contains(successMsg));	
	}
	
	// Registration with valid email field (With Digits in the address are valid)
	@Test(priority=9,alwaysRun=true)
	public void ValidEmailRegistrationTest5() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan", "123@example.com", "01225369841", "selenium-automation","april");
		
		registerObject.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nf-response-msg")));			
		Assert.assertTrue(registerObject.successMessage.getText().contains(successMsg));	
	}
	
	// Registration with valid email field (With Underscore in the address field is valid)
	@Test(priority=10,alwaysRun=true)
	public void ValidEmailRegistrationTest6() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan", "___@example.com", "01225369841", "selenium-automation","april");
		
		registerObject.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nf-response-msg")));			
		Assert.assertTrue(registerObject.successMessage.getText().contains(successMsg));	
	}
	
	// Registration with valid email field (With Dot in Top Level Domain name is valid)
	@Test(priority=11,alwaysRun=true)
	public void ValidEmailRegistrationTest7() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan", "test@example.com.eg", "01225369841", "selenium-automation","april");
			
		registerObject.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nf-response-msg")));			
		Assert.assertTrue(registerObject.successMessage.getText().contains(successMsg));	
	}
	
	// Registration with valid email field (With Dash in the address field is valid)
	@Test(priority=12,alwaysRun=true)
	public void ValidEmailRegistrationTest8() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan", "test-test@example.com.eg", "01225369841", "selenium-automation","april");
			
		registerObject.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nf-response-msg")));			
		Assert.assertTrue(registerObject.successMessage.getText().contains(successMsg));	
	}
//////////////////////////////////////////////////Email Validation - Negative Scenarios//////////////////////////////////	
	// Registration without providing user email field
	@Test(priority=13,alwaysRun=true)
	public void EmptyEmailRegistrationTest() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan", "", "01225369841", "selenium-automation","april");
			
		Assert.assertTrue(registerObject.emailReqMessage.getText().contains(ReqMessage));
	}
			

	// Registration with invalid user email field (doesn't contain @symbol)
	@Test(priority=14,alwaysRun=true)
	public void InvalidEmailRegistrationTest() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan", "test.com", "01225369841", "selenium-automation","april");
		
		Assert.assertTrue(registerObject.emailInvalidMessage.getText().contains(invalidEmailErrorMsg));		
	}
	
	// Registration with invalid user email field (With Two @ symbol)
	@Test(priority=15,alwaysRun=true)
	public void InvalidEmailRegistrationTest2() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan", "test@example@example.com", "01225369841", "selenium-automation","april");
		
		Assert.assertTrue(registerObject.emailInvalidMessage.getText().contains(invalidEmailErrorMsg));		
	}
	
	// Registration with invalid user email field (With space  in the address field)
	@Test(priority=16,alwaysRun=true)
	public void InvalidEmailRegistrationTest3() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan", "test @example.com", "01225369841", "selenium-automation","april");
		
		Assert.assertTrue(registerObject.emailInvalidMessage.getText().contains(invalidEmailErrorMsg));		
	}
	
	// Registration with invalid user email field (With the Missing top-level domain (.com/.net/.org/etc))
	@Test(priority=17,alwaysRun=true)
	public void InvalidEmailRegistrationTest4() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan", "test@example", "01225369841", "selenium-automation","april");
		
		Assert.assertTrue(registerObject.emailInvalidMessage.getText().contains(invalidEmailErrorMsg));		
	}
		
	// Registration with invalid user email field (With the Leading dot in the address)
	@Test(priority=18,alwaysRun=true)
	public void InvalidEmailRegistrationTest5() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh (driver);
		registerObject = new RegistrationPage(driver); 
		
		registerObject.userRegistration("Marian", "Sultan", ".test@example.com", "01225369841", "selenium-automation","april");
		
		Assert.assertTrue(registerObject.emailInvalidMessage.getText().contains(invalidEmailErrorMsg));				
	}
/////////////////////////////////////////Know About Us Validation//////////////////////////////	
	// Registration without selecting know about us field (doesn't contain dot)
		@Test(priority=19,alwaysRun=true)
		public void EmptyKnowAboutRegistrationTest() 
		{
			//homeObject = new HomePage(driver); 
			//homeObject.openRegistrationPage();
			PageRefresh (driver);
			registerObject = new RegistrationPage(driver); 
			registerObject.userRegistrationWithoutRdo("Marian", "Sultan", "test@example.com", "01225369841", "selenium-automation","april");
			
			Assert.assertTrue(registerObject.knwAbtInvalidMessage.getText().contains(ReqMessage));
			
		}
/////////////////////////////////////////not enabled////////////////////////////////////
		
		// Registration with invalid user first name field (begins with small letter)
		@Test(enabled=false)
		public void InvalidFNameRegistrationTest() 
		{
			//homeObject = new HomePage(driver); 
			//homeObject.openRegistrationPage();
			PageRefresh (driver); 
			registerObject = new RegistrationPage(driver); 
			registerObject.userRegistration("marian", "Sultan","test@example.com", "01225369841", "selenium-automation","april");
			
			registerObject.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nf-response-msg")));
			Assert.assertTrue(registerObject.successMessage.getText().contains(successMsg));
		}

		// Registration with invalid user last name field (begins with small letter)
		@Test(enabled=false)
		public void InvalidLNameRegistrationTest() 
		{
			//homeObject = new HomePage(driver); 
			//homeObject.openRegistrationPage();
			PageRefresh (driver);
			registerObject = new RegistrationPage(driver); 
			registerObject.userRegistration("Marian", "sultan", "test@example.com", "01225369841", "selenium-automation","april");
			
			registerObject.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nf-response-msg")));
			Assert.assertTrue(registerObject.successMessage.getText().contains(successMsg));
		}
					
}

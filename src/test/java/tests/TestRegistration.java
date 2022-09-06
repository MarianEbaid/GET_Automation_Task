package tests;



//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class TestRegistration extends TestBase
{
	HomePage homeObject ; 
	RegistrationPage registerObject ; 
	LoginPage loginObject ; 

	// Registration with all valid data
	@Test(priority=1,alwaysRun=true)
	public void ValidRegistrationTest() 
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan", "01225369841", "test@hotmail.com", "selenium-automation","april");
		//, "customers");
		
		//String expectedURL = "https://phptravels.net/login/signup";
		//String actualURL = driver.getCurrentUrl();
		//Assert.assertEquals(actualURL, expectedURL);	
		System.out.println(registerObject.successMessage.getText());
		Assert.assertTrue(registerObject.successMessage.getText().contains("Thank you for registering for our event."));
	}
	
	/*
	@Test(priority=2,dependsOnMethods= {"ValidRegistrationTest"})
	public void RegisteredUserCanLogin() 
	{
		registerObject.userLogin("test@hotmail.com", "Password");
		Assert.assertTrue(registerObject.WelcomeMessage.getText().contains("Welcome Back"));
	}*/
	/*
	// Registration without providing user first name field
	@Test(priority=3,alwaysRun=true)
	public void EmptyFNameRegistrationTest() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("", "Sultan", "01225369841", "test@hotmail.com", "Password", "customers");
		
		String expectedURL = "https://phptravels.net/signup";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	// Registration with invalid user first name field (begins with small letter)
	@Test(priority=4,alwaysRun=true)
	public void InvalidFNameRegistrationTest() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("marian", "Sultan", "01225369841", "test@hotmail.com", "Password", "customers");
		
		String expectedURL = "https://phptravels.net/signup";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	// Registration without providing user last name field
	@Test(priority=4,alwaysRun=true)
	public void EmptyLNameRegistrationTest() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "", "01225369841", "test@hotmail.com", "Password", "customers");
		
		String expectedURL = "https://phptravels.net/signup";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
		
		//Assert.assertTrue(registerObject.successMessage.getText().contains("Signup Successfull please login"));
	}
	
	// Registration with invalid user last name field (begins with small letter)
	@Test(priority=5,alwaysRun=true)
	public void InvalidLNameRegistrationTest() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "sultan", "01225369841", "test@hotmail.com", "Password", "customers");
		
		String expectedURL = "https://phptravels.net/signup";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	// Registration without providing user phone field
	@Test(priority=6,alwaysRun=true)
	public void EmptyPhoneRegistrationTest() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan", "", "test@hotmail.com", "Password", "customers");
		
		String expectedURL = "https://phptravels.net/signup";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
	}

	// Registration with invalid user phone field (string instead of number) 
	@Test(priority=7,alwaysRun=true)
	public void StringPhoneRegistrationTest() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration("Marian", "Sultan", "test", "test@hotmail.com", "Password", "customers");
		
		String expectedURL = "https://phptravels.net/signup";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
	}	
	
	// Registration with invalid user phone field (length less than 11 digits) 
		@Test(priority=8,alwaysRun=true)
		public void BeyondLimitPhoneRegistrationTest() 
		{
			homeObject = new HomePage(driver); 
			homeObject.openRegistrationPage();
			registerObject = new RegistrationPage(driver); 
			registerObject.userRegistration("Marian", "Sultan", "010", "test@hotmail.com", "Password", "customers");
			
			String expectedURL = "https://phptravels.net/signup";
			String actualURL = driver.getCurrentUrl();
			Assert.assertEquals(actualURL, expectedURL);
		}	
		
	// Registration with invalid user phone field (length more than 11 digits) 
		@Test(priority=9,alwaysRun=true)
		public void AboveLimitPhoneRegistrationTest() 
		{
			homeObject = new HomePage(driver); 
			homeObject.openRegistrationPage();
			registerObject = new RegistrationPage(driver); 
			registerObject.userRegistration("Marian", "Sultan", "0102527696689", "test@hotmail.com", "Password", "customers");
			
			String expectedURL = "https://phptravels.net/signup";
			String actualURL = driver.getCurrentUrl();
			Assert.assertEquals(actualURL, expectedURL);
		}

	// Registration without providing user email field
		@Test(priority=10,alwaysRun=true)
		public void EmptyEmailRegistrationTest() 
		{
			homeObject = new HomePage(driver); 
			homeObject.openRegistrationPage();
			registerObject = new RegistrationPage(driver); 
			registerObject.userRegistration("Marian", "Sultan", "01225369841", "", "Password", "customers");
			
			String expectedURL = "https://phptravels.net/signup";
			String actualURL = driver.getCurrentUrl();
			Assert.assertEquals(actualURL, expectedURL);
			
	        String expectedErrorMsg = "Please add email!";
	        WebElement exp = driver.findElement(By.xpath("")); //cann't find
	        String actualErrorMsg = exp.getText();     		
	        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		}
		
	// Registration with email id which already have account
		@Test(priority=11,alwaysRun=true)
		public void ExistedEmailRegistrationTest() 
		{
			homeObject = new HomePage(driver); 
			homeObject.openRegistrationPage();
			registerObject = new RegistrationPage(driver); 
			registerObject.userRegistration("Marian", "Sultan", "01225369841", "test@hotmail.com", "Password", "customers");
					
			String expectedURL = "https://phptravels.net/signup";
			String actualURL = driver.getCurrentUrl();
			Assert.assertEquals(actualURL, expectedURL);
					
			String expectedErrorMsg = "Email exist";
			WebElement exp = driver.findElement(By.xpath("")); //cann't find
			String actualErrorMsg = exp.getText();     		
			Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
			        
					//Assert.assertTrue(registerObject.successMessage.getText().contains("Signup Successfull please login"));
		}		

	// Registration with invalid user email field (doesn't contain @symbol)
		@Test(priority=12,alwaysRun=true)
		public void InvalidEmailRegistrationTest() 
		{
			homeObject = new HomePage(driver); 
			homeObject.openRegistrationPage();
			registerObject = new RegistrationPage(driver); 
			registerObject.userRegistration("Marian", "Sultan", "01225369841", "test.com", "Password", "customers");
			
			String expectedURL = "https://phptravels.net/signup";
			String actualURL = driver.getCurrentUrl();
			Assert.assertEquals(actualURL, expectedURL);
			
	        String expectedErrorMsg = "Please add correct email!";
	        WebElement exp = driver.findElement(By.xpath("")); //cann't find
	        String actualErrorMsg = exp.getText();     		
	        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		}
		
	// Registration without providing user password field
		@Test(priority=13,alwaysRun=true)
		public void EmptyPasswordRegistrationTest() 
		{
			homeObject = new HomePage(driver); 
			homeObject.openRegistrationPage();
			registerObject = new RegistrationPage(driver); 
			registerObject.userRegistration("Marian", "Sultan", "01225369841", "test@hotmail.com", "", "customers");
			
			String expectedURL = "https://phptravels.net/signup";
			String actualURL = driver.getCurrentUrl();
			Assert.assertEquals(actualURL, expectedURL);
		}
		
		// Registration with invalid password (less than 8 characters)
		@Test(priority=14,alwaysRun=true)
		public void InvalidPasswordRegistrationTest() 
		{
			homeObject = new HomePage(driver); 
			homeObject.openRegistrationPage();
			registerObject = new RegistrationPage(driver); 
			registerObject.userRegistration("Marian", "Sultan", "01225369841", "test@hotmail.com", "pass", "customers");
			
			String expectedURL = "https://phptravels.net/signup";
			String actualURL = driver.getCurrentUrl();
			Assert.assertEquals(actualURL, expectedURL);
		}
		*/
				
}

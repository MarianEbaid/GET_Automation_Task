package tests;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class TestRegistrationWithDataProvider extends TestBase
{
	HomePage homeObject ; 
	RegistrationPage registerObject ; 
	LoginPage loginObject ; 


	@DataProvider(name="testData")
	public static Object[][] userData()
	{
		return new Object[][] {
			{"Marian" , "Sultan","1225276466","test@gmail.com","password1"},
			{"Mena","Adel","1225276422","test2@gmail.com","password2"}
		};
	}

	@Test(priority=1,dataProvider="testData")
	public void UserRegisterSuccessfully(String fname, String lname, String phone, String email,String password)
	//, String accountType) 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration(fname,lname,phone,email,password);
		//,accountType);
		
		String expectedURL = "https://phptravels.net/login/signup";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
		
		Assert.assertTrue(registerObject.successMessage.getText().contains("Signup Successfull please login"));
		
		registerObject.userLogin(email, password);		
		Assert.assertTrue(registerObject.WelcomeMessage.getText().contains("Welcome Back"));
		
		/*
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
		*/
	}

}

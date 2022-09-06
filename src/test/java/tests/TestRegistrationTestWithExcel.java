package tests;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class TestRegistrationTestWithExcel extends TestBase
{
	HomePage homeObject ; 
	RegistrationPage registerObject ; 
	LoginPage loginObject ; 

	@DataProvider(name="ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}

	@Test(priority=1,alwaysRun=true,dataProvider="ExcelData")
	public void UserRegisterSuccessfully(String fname, String lname, String phone, String email,	String password)
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
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin(email,password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
		*/
	}

}

package tests;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.ExcelReaderInv;
import data.ExcelReader;
import pages.HomePage;
import pages.RegistrationPage;

public class TestRegistrationTestWithExcel extends TestBase
{
	HomePage homeObject ; 
	RegistrationPage registerObject ; 
	String ReqMessage = "This is a required field.";
	String successMsg = "Thank you for registering for our event.";

	@DataProvider(name="ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}
	
	@DataProvider(name="ExcelDataInv")
	public Object[][] userRegisterDataInv() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReaderInv ERI = new ExcelReaderInv();
		return ERI.getExcelData();
	}


	@Test(priority=1,alwaysRun=true,dataProvider="ExcelData")
	public void UserRegisterSuccessfully(String fName, String lName, String email, String phone, String course, String month)
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh(driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration(fName,lName,email,phone,course,month);
				
		registerObject.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nf-response-msg")));			
		Assert.assertTrue(registerObject.successMessage.getText().contains(successMsg));	
		
	}
	
	@Test(priority=2,alwaysRun=true,dataProvider="ExcelData")
	public void UserRegisterUnSuccessfully(String fName, String lName, String email, String phone, String course, String month)
	{
		//homeObject = new HomePage(driver); 
		//homeObject.openRegistrationPage();
		PageRefresh(driver);
		registerObject = new RegistrationPage(driver); 
		registerObject.userRegistration(fName,lName,email,phone,course,month);		

		Assert.assertTrue(registerObject.fnReqMessage.getText().contains(ReqMessage));	
		
	}

}

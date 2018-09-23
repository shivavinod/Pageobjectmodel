package com.crm.qa.testpages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestbaseClass;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends TestbaseClass {

	LoginPage loginpage;
	HomePage homepage;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		Intialization();
	    loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void verifyLoginTittle() {
		String Tittle=loginpage.ValidateTittle();
		Assert.assertEquals(Tittle, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void LogoTest() {
	boolean	flag=loginpage.validateCRMLogo();
	Assert.assertTrue(flag);
	}
	
	
	@Test(priority=3)
	public void Login() {
	homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	

	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
}

package com.crm.qa.testpages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestbaseClass;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTestCases extends TestbaseClass {
	
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage con;
	public HomePageTestCases()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		Intialization();
	    loginpage=new LoginPage();
	    con=new ContactsPage();
	   // loginpage.login(un, Pwd)
	    homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyTittleTest()
	{
		String Homepagetittle=homepage.VerifyTittle();
		Assert.assertEquals(Homepagetittle,"CRMPRO"," homepage tittle failed" );
	}
	
	public void ClickContactspage() {
		con=homepage.ClickonContacts();
	}
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
}

package com.crm.qa.testpages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.Base.TestbaseClass;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsTestCases extends TestbaseClass {
	
	LoginPage loginpage;
	ContactsPage con;
	HomePage homepage;
	
	public ContactsTestCases()
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
	    homepage.ClickonContacts();
	    
	    
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}

}

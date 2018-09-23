package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.Base.TestbaseClass;

public class ContactsPage extends TestbaseClass {
	
	
	
	@FindBy(id="first_name")
	WebElement FirstName;
	
	@FindBy(id="surname")
	WebElement LastName;
	
	@FindBy(name="client_lookup")
	WebElement Companyname;
	
	@FindBy(xpath="//input[@type='submit'  and @value='Save']")
	WebElement savebtn;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void CreatenewContact(String title,String Fname,String Lname,String CompName)
	{
		Select select=new Select(driver.findElement(By.name("title")));
		select.deselectByVisibleText(title);
		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		Companyname.sendKeys(CompName);
		savebtn.click();
	}

}

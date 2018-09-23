package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestbaseClass;

public class HomePage extends TestbaseClass {
	
	@FindBy(xpath="//td[contains(text(),'User: Naveen K')]")
	WebElement Usernamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement Contactslink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink ;
	
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink ;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement NewContactsLink ;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String VerifyTittle() {
		return driver.getTitle();
	}
	public ContactsPage ClickonContacts()
	{
		Contactslink.click();
		return new ContactsPage(); 
	}
	
	public DealsPage ClickonDeals()
	{
		DealsLink.click();
		return new DealsPage(); 
	}
	
	public TasksPage ClickonTasks() {
		TasksLink.click();
		return new TasksPage();
	}
	
	public void clickonnewcontactLink()
	{
		
		Actions actions=new Actions(driver);
		actions.moveToElement(Contactslink).build().perform();
		NewContactsLink.click();
		//return  new ContactsPage(); 
	}
	
	

}

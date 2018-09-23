package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestbaseClass;

public class LoginPage extends TestbaseClass {
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name ="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
public String ValidateTittle()
{
	return driver.getTitle();
}

public boolean validateCRMLogo()
{
	return crmlogo.isDisplayed();
}
public HomePage login(String un,String Pwd)
{
	username.sendKeys(un);
	password.sendKeys(Pwd);
	//LoginBtn.click();
	LoginBtn.click();
	
	return  new HomePage();
}
	
}

package com.pacs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(how=How.XPATH, using="//input[@name='email']")
	@CacheLookup
	public WebElement txtUserid;
	
	/*@FindBy(xpath="//input[@name='email']")
	public WebElement txtUserid;*/
	
	@FindBy(how=How.NAME, using="password")
	@CacheLookup
	public WebElement txtPasswrd;
	
	@FindBy(how=How.XPATH, using="//div[text()='Login']")
	@CacheLookup
	public WebElement btnLogin;
	
	@FindBy(how=How.LINK_TEXT, using="Forgot your password?")
	public WebElement lnkForgotPwd;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT, using="Classic CRM")
	public WebElement lnkLogintoClassicCRM;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Sign')]")
	public WebElement lnkSignUp;
	
	public LoginPage()
	{
		this.driver=driver;
	}

}

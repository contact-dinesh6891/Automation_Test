package com.eVisa.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eVisa.qa.base.TestBase;
import com.eVisa.qa.util.TestUtil;

public class LoginPage  extends TestBase{

	// Page Factory - OR
	
	@FindBy(id = "_evisaregister_WAR_Evisaregisterportlet_INSTANCE_123_login_username")
	@CacheLookup
	WebElement usename;
	@FindBy(id = "_evisaregister_WAR_Evisaregisterportlet_INSTANCE_123_login_password")
	WebElement password;
	@FindBy(id = "loginButtonId")
	//@FindBy(xpath ="//input[@type='submit']")
	WebElement btnLogin;
	@FindBy(xpath = "//div[@class = 'logo_new']")
	WebElement logoHomePage;
	
	// Initialize the Object Repository
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
		// Action
	
	public String ValidateLoginPageTitle() {
			return driver.getTitle();
	}
	
	public boolean ValidateLogoHomePage() {
		
		return logoHomePage.isDisplayed();
		
	}
	
	public HomePage login(String un , String pwd) {
		usename.sendKeys(un);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		password.sendKeys(pwd);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		btnLogin.click();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return new HomePage();
	}
	

}

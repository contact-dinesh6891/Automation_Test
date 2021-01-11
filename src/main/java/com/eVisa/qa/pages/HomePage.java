package com.eVisa.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eVisa.qa.base.TestBase;
import com.eVisa.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	
	// Page Factory - OR
	
	@FindBy(xpath = "//span[contains(text(),'User: ')]")
	WebElement loggedInuser;
	
	@FindBy(xpath = "//*[@id=\"collapseListGroupHeading0\"]")
	WebElement lnkApplyForVisa;
	
	@FindBy(xpath = "//*[@id=\"collapseListGroupHeading0\"]")
	WebElement linkApplyForSponsorVisa;
	
	// Initialize the Object Repository
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
		
	// Action-Methods

	public String validateTitleHomePage() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return (driver.getTitle());
		
	}
	
	public boolean validateLoggedInUser() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return(loggedInuser.isDisplayed());
		
	}
	
	
	public SponsorSelectionPage applyForVisa() {
		lnkApplyForVisa.isDisplayed();
		lnkApplyForVisa.click();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		linkApplyForSponsorVisa.isDisplayed();
		linkApplyForSponsorVisa.click();
		return new SponsorSelectionPage();
		
	}
	
	
	
	
	
}

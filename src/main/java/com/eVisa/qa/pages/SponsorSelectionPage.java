package com.eVisa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eVisa.qa.base.TestBase;

public class SponsorSelectionPage extends TestBase {
	
	// Page Factory - OR
	@FindBy(xpath="//*[@id=\'DataTables_Table_0_wrapper\']")
	WebElement sponsorVisa;
	
			
	// Initialize the Object Repository
	
	public SponsorSelectionPage() {
		PageFactory.initElements(driver, this);
			
	}
	
	// Action-Methods

	
	
	
	
	
	
	
	
	

}

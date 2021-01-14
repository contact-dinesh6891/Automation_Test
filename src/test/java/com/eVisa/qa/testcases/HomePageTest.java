package com.eVisa.qa.testcases;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.eVisa.qa.base.TestBase;
import com.eVisa.qa.pages.HomePage;
import com.eVisa.qa.pages.LoginPage;
import com.eVisa.qa.pages.SponsorSelectionPage;
import com.eVisa.qa.util.TestUtil;


public class HomePageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	SponsorSelectionPage sponsorSelectionPage;
	TestUtil testUtil;
	
	
	public HomePageTest() {
				super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		}	
	
	@Test(priority = 1)
	
	public void ValidateHomePageTitleTest() {
		String title = homePage.validateTitleHomePage();
		assertEquals(title, "Sponsor Home","Home Page is not as Expected.");
	}
	
	@Test (priority = 2)
	
	public void validateLoggedInUserTest() {
		testUtil.switchToFrame();
		assertTrue(homePage.validateLoggedInUser());
	 }
	
	@Test(priority = 3)
	
	public void applyForSponsorVisaTest() {
		sponsorSelectionPage = homePage.applyForVisa();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
		

}

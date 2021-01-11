package com.eVisa.qa.pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.eVisa.qa.base.TestBase;
import com.eVisa.qa.util.TestUtil;

public class TravelDocumentDetailPage extends TestBase {
	
	LoginPage loginPage;
	TestUtil testUtil;
	HomePage  homePage;
	
	public TravelDocumentDetailPage() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		}	
	
	
	
	@DataProvider
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	

}

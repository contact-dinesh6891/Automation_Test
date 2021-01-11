
/*
 * @Dinesh Kumar shrama
 * 
 */

package com.eVisa.qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

//import com.aventstack.extentreports.util.Assert;
import com.eVisa.qa.base.TestBase;
import com.eVisa.qa.pages.HomePage;
import com.eVisa.qa.pages.LoginPage;
import com.eVisa.qa.util.TestUtil;

public class LoginPageTest  extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	Logger log = Logger.getLogger(LoginPageTest.class);
	public LoginPageTest() {
		super();
	}
		
	@BeforeMethod
	public void setUp() {
		log.info("Lanuching chrome browser");
		initialization();
		loginPage = new LoginPage();
	}	
	
	@Test (priority = 1)
		
	public void loginPageTitleTest() {
		String title = loginPage.ValidateLoginPageTitle(); 
		assertEquals(title, "Home - Liferay", "Title has been Verified OK");
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	
	@Test (priority = 2)
	
	public void loginPageLogoTest() {
		boolean logoExist = loginPage.ValidateLogoHomePage();
		assertTrue(logoExist);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	
	@Test (priority = 3)
	
	public void loginTest() {
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
				
	}
	
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
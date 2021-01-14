
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
/*import org.testng.annotations.Listeners;*/
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

//import com.aventstack.extentreports.util.Assert;
import com.eVisa.qa.base.TestBase;
import com.eVisa.qa.pages.HomePage;
import com.eVisa.qa.pages.LoginPage;
import com.eVisa.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

 

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
	
	@Test (priority = 1 ,description = "Verifying login Page Title.")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case Description: Verify Login Page Title on Login Page.")
	@Story("Story Name : Check Login Page.")
			
	public void loginPageTitleTest() {
		String title = loginPage.ValidateLoginPageTitle(); 
		assertEquals(title, "Home - Liferay", "Title has been Verified OK");
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	
	@Test (priority = 2 ,description = "Verifying Logo on Login page.")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify Logo on Login Page.")
	@Story("Story Name : Check Logo on Login Page.")
	
	public void loginPageLogoTest() {
		boolean logoExist = loginPage.ValidateLogoHomePage();
		assertTrue(logoExist);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	
	@Test (priority = 3 ,description = "Login into Application Test.")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description: verify Login into application with correct credentials.")
	@Story("Story Name : Check the Login Funtionality.")
	
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
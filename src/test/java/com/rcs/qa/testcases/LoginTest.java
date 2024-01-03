package com.rcs.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rcs.qa.base.TestBase;
import com.rcs.qa.pages.Login;
import com.rcs.qa.pages.WidgetDashboard;
import com.rcs.qa.utils.TestUtils;

public class LoginTest extends TestBase {
	Login login;
	WidgetDashboard wigetDashboard;
	
	public LoginTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		
		 login = new Login();
		
	}	
		
		@Test
		public void employeeLogin() throws InterruptedException 
		{
			login.clickEmployeeLoginButton();
			wigetDashboard = login.employeeLogin(prop.getProperty("username"), prop.getProperty("password"));
			
			}
		
		
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

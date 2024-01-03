package com.rcs.qa.testcases;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rcs.qa.base.TestBase;
import com.rcs.qa.pages.AddNewCustomerPage;
import com.rcs.qa.pages.Login;
import com.rcs.qa.pages.WidgetDashboard;
import com.rcs.qa.utils.TestUtils;

public class WidgetDashboardTest extends TestBase {
	
	Login login;
	WidgetDashboard wigetDashboard;
	AddNewCustomerPage addNewCustomer;
		
	
	public WidgetDashboardTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		wigetDashboard=new WidgetDashboard();
		addNewCustomer= new AddNewCustomerPage();
		 login = new Login();
		 login.clickEmployeeLoginButton();
		 wigetDashboard = login.employeeLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}	
	
	@Test(priority=1)
	public void clickOnAddNewCustomerButton() {
		wigetDashboard.hoverOnCustomerManagementMenu();
		Assert.assertTrue(wigetDashboard.verifyTooltipForcustomerMangement());
		System.out.println("verified tooltip");
		
		wigetDashboard.clickOnAddCustomerButton();
		Assert.assertTrue(addNewCustomer.verifyGeneralDataHeader());
		

		
		
	}
		
	
	
@AfterMethod
public void tearDown() {
	driver.quit();
}


}

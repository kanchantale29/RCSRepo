package com.rcs.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rcs.qa.base.TestBase;
import com.rcs.qa.pages.AddNewCustomerPage;
import com.rcs.qa.pages.Login;
import com.rcs.qa.pages.WidgetDashboard;

public class AddNewCustomerTest extends TestBase {
	
		
		Login login;
		WidgetDashboard wigetDashboard;
		AddNewCustomerPage addNewCustomer;
	
			
		
		public AddNewCustomerTest() {
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
		public void addNewCustomer() {
			wigetDashboard.hoverOnCustomerManagementMenu();
			Assert.assertTrue(wigetDashboard.verifyTooltipForcustomerMangement());
			System.out.println("verified tooltip");
			wigetDashboard.clickOnAddCustomerButton();
			Assert.assertTrue(addNewCustomer.verifyGeneralDataHeader());
			System.out.println("clicked on button");
			
			addNewCustomer.selectSaluation();
			System.out.println("salutation selected");
			addNewCustomer.enterFirstName();
			System.out.println("entered first name");
			addNewCustomer.enterLastName();
			System.out.println("entered last name");
			addNewCustomer.enterAddress();
			System.out.println("entered address");
			addNewCustomer.selectDivision();
			System.out.println("division selected");
			addNewCustomer.selectMainContact();
			System.out.println("main contact selected");
			addNewCustomer.selectClassification();
			System.out.println("classification selected");
			addNewCustomer.selectRoleOfCustomer();
			System.out.println("role o f customer selected");
			addNewCustomer.selectStatus();
			System.out.println("status selected");
			addNewCustomer.enterSalesStatus();
			System.out.println("entered sales status ");
			addNewCustomer.selectBrokerageMandate();
			System.out.println("brokerage mandate selected");
			addNewCustomer.selectDate();
			System.out.println("date selected");
			addNewCustomer.uploadBrokerageMandateDocument();
			System.out.println("file uploaded");
			
			addNewCustomer.clickSaveButton();
			
			
			
			System.out.println("form saved");

			
			
		}
			
		
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}



}

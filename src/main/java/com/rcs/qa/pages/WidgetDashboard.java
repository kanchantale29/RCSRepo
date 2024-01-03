package com.rcs.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rcs.qa.base.TestBase;
import com.rcs.qa.utils.TestUtils;

public class WidgetDashboard extends TestBase {

	
	@FindBy(xpath="//a[@href ='/widget_dashboard']")
	WebElement homePageMenu;
	
	@FindBy(xpath="//a[@href='/add-new-customer']")
	WebElement addCustomerButton;

	@FindBy(xpath = "//ul[@class='navbar-nav menu1 ng-star-inserted']//li[2]")
	WebElement customerManagementMenu;
	
	
	@FindBy(xpath = "//ul[@class='navbar-nav menu1 ng-star-inserted']//li[2]")
	WebElement tooltipForCustomerManagement;
	
	
	public WidgetDashboard() {
		PageFactory.initElements(driver,this);
	}
	
	
	public void hoverOnCustomerManagementMenu() {

		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(customerManagementMenu).perform();
		
	}
	
	public void clickOnAddCustomerButton() {
		addCustomerButton.click();
		JavascriptExecutor j = (JavascriptExecutor)driver;
		if (j.executeScript("return document.readyState").toString().equals("complete")){
			System.out.println("Customer Page has loaded");
		}
		for (int i=0; i<60; i++){
			try {
				Thread.sleep(1000);
			}catch (InterruptedException ex) {
				System.out.println("Customer Page has not loaded yet ");
			}
			//again check page state
			if (j.executeScript("return document.readyState").toString().equals("complete")){
				break;
			}
		}
				
		
	}
	
	public boolean verifyTooltipForcustomerMangement() {
		return tooltipForCustomerManagement.isDisplayed();
	
	}
	
	}
		
	
	



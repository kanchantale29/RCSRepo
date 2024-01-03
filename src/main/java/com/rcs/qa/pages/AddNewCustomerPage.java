package com.rcs.qa.pages;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.rcs.qa.base.TestBase;

public class AddNewCustomerPage extends TestBase {
	
	@FindBy(xpath="//div[@class='general-tab']//h6[@class='customer-management-page-heading']")
	WebElement generalDataHeader;

	@FindBy(xpath = "//mat-select[@formcontrolname='salutation']")
	WebElement salutation;
	
	
	@FindBy(xpath = "//input[@placeholder='Name 1']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@placeholder='Name 2']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='location']")
	WebElement address;
	
	@FindBy(xpath = "//*[contains(@ng-reflect-name,'division')]")
	WebElement division;
	
	@FindBy(xpath = "//*[contains(@formcontrolname,'artus_user']")
	WebElement mainContact;
	
	@FindBy(xpath = "//*[contains(@formcontrolname,'classification']")
	WebElement classification;
	
	@FindBy(xpath = "//*[contains(@formcontrolname,'roleOfCustomer']")
	WebElement roleOfCustomer;
	
	@FindBy(xpath = "//*[contains(@formcontrolname,'status']")
	WebElement status;
	
	@FindBy(xpath = "//input[@class='input mat-autocomplete-trigger ng-untouched ng-pristine ng-valid']")
	WebElement salesStatus;
	
	@FindBy(xpath = "//*[contains(@formcontrolname,'brokerageMandate']")
	WebElement brokerageMandate;
	
	@FindBy(xpath = "//div[@class=\"mat-form-field-suffix ng-tns-c30-16 ng-star-inserted\"]//child::mat-datepicker-toggle")
	WebElement brokerageMandateDate;
	
	@FindBy(xpath = "//button[@class='upload-button']//img")
	WebElement brokerageMandateDocuemnt;
	
	@FindBy(xpath = "//button[@class='custom-btn save-btn']")
	WebElement saveButton;
	
	@FindBy(xpath = "//button[@class='mat-calendar-period-button mat-focus-indicator mat-button mat-button-base _mat-animation-noopable']")
	WebElement calenderButton;
	
	@FindBy(xpath = "//tbody[@class='mat-calendar-body']//tr[3]//td[3]")
	WebElement yearSelection;
	
	@FindBy(xpath = "//tbody[@class='mat-calendar-body']//tr[3]//td[1]")
	WebElement monthSelection;
	
	@FindBy(xpath = "//tbody[@class='mat-calendar-body']//tr[3]//td[2]")
	WebElement dateSelection;
	
	@FindBy(xpath = "//button[@class='custom-btn save-btn']")
	WebElement saveNutton;
	
	@FindBy(xpath = "//div[@class='custom-btn cancel-btn']")
	WebElement browseButton;
	
	@FindBy(xpath = "//button[@class='custom-btn save-btn ml-2']")
	WebElement uploadDocumentButton;
	
	@FindBy(xpath = "//button[@class='close']//img")
	WebElement closeButton;
	
	//button[@class='close']//img
	
	
	
	

	public AddNewCustomerPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void enterFirstName() {
		firstName.sendKeys("First Name");
	}
	
	public void enterLastName() {
		lastName.sendKeys("Last Name");
	}
	
	public void enterAddress() {
		address.sendKeys("hamburg 5");
		
		
	}
	

	
	public boolean verifyGeneralDataHeader() {
		
	
		return  generalDataHeader.isDisplayed();
		
		
	}
	
	public void selectSaluation() {
		Select sal = new Select(salutation);
		sal.selectByVisibleText("Firm");	
		
	}
	public void selectStatus() {
		Select stat = new Select(status);
		stat.selectByIndex(1);	
		
	}
	public void selectDivision() {
		Select div = new Select(division);
		div.selectByVisibleText("ARTUS FRIEDRICH GANZ Versicherungsmakler GmbH");	
		
	}
	public void selectMainContact() {
		Select maincontact = new Select(mainContact);
		maincontact.selectByIndex(2);	
		
	}
	public void selectClassification() {
		Select classi = new Select(classification);
		classi.selectByIndex(2);	
		
	}
	public void selectRoleOfCustomer() {
		Select role = new Select(roleOfCustomer);
		role.selectByIndex(1);
}
	public void enterSalesStatus() {
		salesStatus.sendKeys("Test sales status");
	}
	public void selectBrokerageMandate() {
		Select brokerMandate = new Select(brokerageMandate);
		brokerMandate.selectByIndex(1);
}
	public void selectDate() {
		brokerageMandate.click();
		calenderButton.click();
		yearSelection.click();
		monthSelection.click();
		dateSelection.click();
		
	}
	
	
	public void uploadBrokerageMandateDocument() {
		
		brokerageMandateDocuemnt.click();
		File uploadFile = new File("/Users/kanchan/Desktop/ARTUS- Automation/RCSTest/Resources/sample.pdf");

	    browseButton.sendKeys(uploadFile.getAbsolutePath());
	    uploadDocumentButton.click();
	    closeButton.click();
	
		
	}
	public void clickSaveButton() {
		saveButton.click();
	}
		
	}

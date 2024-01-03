package com.rcs.qa.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rcs.qa.base.TestBase;
import com.rcs.qa.utils.TestUtils;

public class Login extends TestBase{
	
	//pagefactory --- OR
	
	
	@FindBy(xpath="//input[@value='ARTUS Mitarbeiter Login'] | //input[@value='ARTUS Employee Login']")
	WebElement employeeLoginButton;

	@FindBy(xpath="//div[@Text='Use another account']")
	WebElement useAnotherAccountLink1;
	
	@FindBy(xpath="//div[@id='otherTileText']  | //div[@Text='Use another account']")
	WebElement useAnotherAccountLink2;

	@FindBy(xpath="//input[@type='email']")
	WebElement empUsername;

	@FindBy(xpath="//input[@id='idSIButton9']")
	WebElement clickNextButton;

	@FindBy(xpath="//input[@id='idBtn_Back']")
	WebElement clickBackButton;

	@FindBy(xpath="//input[@type='password']")
	WebElement empPassword;

	@FindBy(xpath="//input[@value='Sign in']")
	WebElement clickSignInButton;

	@FindBy(xpath="//input[@value='Yes']")
	WebElement clickYesButton;

	@FindBy(xpath="//input[@value='No']")
	WebElement clickNoButton;

	@FindBy(css = "a[class=\'nav-link\'][data-title=\'Abmeldung\'], a[class=\'nav-link\'][data-title=\'Logout\']")
	WebElement logOutButton;
	
	@FindBy(xpath = "//span[@text='   Widget Dashboard']")
	WebElement textDashboard;

	@FindBy(xpath="//*[@id=\"tilesHolder\"]/div[1]/div/div/div/div[2]/div")
	WebElement clickLogoutBackButton;
	
	@FindBy(xpath="//a[@href ='/widget_dashboard']")
	WebElement homePageMenu;
	
	
	
	//Actions
	public Login() {
		PageFactory.initElements(driver,this);
	}
	
	public void clickEmployeeLoginButton() {

		employeeLoginButton.click();

	}
	public WidgetDashboard  employeeLogin(String empun , String emppass) {
		empUsername.sendKeys(empun);
		clickNextButton.click();
		empPassword.sendKeys(emppass);
		clickSignInButton.click();
		JavascriptExecutor j = (JavascriptExecutor)driver;
		if (j.executeScript("return document.readyState").toString().equals("complete")){
			System.out.println("dashboard Page has loaded");
		}
		for (int i=0; i<60; i++){
			try {
				Thread.sleep(1000);
			}catch (InterruptedException ex) {
				System.out.println("Dashboard Page has not loaded yet ");
			}
			//again check page state
			if (j.executeScript("return document.readyState").toString().equals("complete")){
				break;
			}
		}
	
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 
		//wait until the page return complete as its status
		wait.until(webDriver -> ((JavascriptExecutor)webDriver).executeScript("return document.readyState").equals("complete"));
		
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.l)*/
		return new WidgetDashboard();
		

	}
	

	public void clickBackButton() {

		clickBackButton.click();

	}


	public void clickYesButton() {

		clickYesButton.click();

	}

	public void clickNoButton() {

		clickNoButton.click();

	}
	
	public void clickLogoutButton() {
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("arguments[0].click()", logOutButton);

	}

	public void clickLogoutBackButton() {

		clickLogoutBackButton.click();

	}

	public void clickAnotherAccountLink() {

		useAnotherAccountLink2.click();

	}

		
}

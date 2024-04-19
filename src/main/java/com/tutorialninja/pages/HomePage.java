package com.tutorialninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath ="//span[.='My Account']")
	private WebElement myaccountDropMenu;

	@FindBy(xpath = "//a[.='Login']")
	private WebElement loginOption;

	@FindBy(xpath = "//a[.='Register']")
	private WebElement registerOption;

	@FindBy(xpath = "//div[@id='search']//i")
	private WebElement clickSearchButton;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement enterProduct;

	
	public HomePage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	//actions
	
	public void enterProduct(String product){
		enterProduct.sendKeys(product);
	}

	public void clickOnMyAccount(){
		myaccountDropMenu.click();
	}
	
	public SearchPage searchForProduct(String product) {
		enterProduct.sendKeys(product);
		clickSearchButton.click();
		return new SearchPage(driver);
	}
	
	public LoginPage selectLoginOption(){
		loginOption.click();
		return new LoginPage(driver);
	}
	
//	public LoginPage login() {
//		myaccountDropMenu.click();
//		loginOption.click();
//		return new LoginPage(driver);
//	}
	
	public LoginPage navigateToLoginPage() {
		myaccountDropMenu.click();
		loginOption.click();
		return new LoginPage(driver);

	}

	public RegisterPage clickOnregisterOption(){
		registerOption.click();
		return new RegisterPage(driver);
	}
	public RegisterPage navigateToRegisterPage(){
		myaccountDropMenu.click();
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	
	public SearchPage clickonSearchButton(){
		clickSearchButton.click();
		return new SearchPage(driver);
	}

}

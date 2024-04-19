package com.tutorialninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement LoginBotton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement matchForEmailAddressAndPassword;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,LoginPage.this);
	}
	
	//actions
	public void enterEmailAddress(String emailText){
		emailField.sendKeys(emailText);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public AccountPage clickOnLoginButton() {
		LoginBotton.click();
		return new AccountPage(driver);
	}
	
	public AccountPage login(String emailText,String password) {
		emailField.sendKeys(emailText);
		passwordField.sendKeys(password);
		LoginBotton.click();
		return new AccountPage(driver);

		
	}
	
	public String warningmessageDisplayed() {
		String message=matchForEmailAddressAndPassword.getText();
		return message;
	}
	
	
}

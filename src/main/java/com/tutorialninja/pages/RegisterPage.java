package com.tutorialninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	
	WebDriver driver;
	
	//objects
	@FindBy(id = "input-firstname")
	private WebElement fistNameField;
	
	
	@FindBy(id = "input-firstname")
	private WebElement lastNameField;
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	
	@FindBy(id = "input-confirm")
	private WebElement confimPasswordField;
	
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement newslatter;
	
	@FindBy(name = "agree")
	private WebElement agreeClick;
	
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement ContineButton;
	

	
	@FindBy(xpath ="//div[contains(@class,'alert alert-danger')]")
	private WebElement privacyPolicy;
	
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailAdrressWarning;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	//actions
	public void enterFirstName(String firstName) {
		fistNameField.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void enterTelephone(String telephone) {
		telephoneField.sendKeys(telephone);
	}
	
	public void enterPassword(String passoword) {
		passwordField.sendKeys(passoword);
	}
	
	public void enterConfirmPassword(String confirmPassoword) {
		confimPasswordField.sendKeys(confirmPassoword);
	}
	
	public void clickOnNewsLetter(){
		newslatter.click();
	}
	
	
	public void clickOnprivacyPolicy(){
		agreeClick.click();
	}
	
	public AccountSuccessPage clickOnContinue(){
		ContineButton.click();
		return new AccountSuccessPage(driver);
	}
	
	
	public String retrieveDuplicateEmailAddressWarning(){
		String duplicateEmailAddressWarningText=duplicateEmailAdrressWarning.getText();
		return duplicateEmailAddressWarningText;
	}
	
	public String retrievePravacyPolicyAddressMessage(){
		String data=privacyPolicy.getText();
		return data;
	}
	
	
	public AccountSuccessPage registerWithMandatoryFields(String firstName,String lastName,String email,String telephone,String passoword,String confirmPassoword) {
		
		fistNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		telephoneField.sendKeys(telephone);
		passwordField.sendKeys(passoword);
		confimPasswordField.sendKeys(confirmPassoword);
		agreeClick.click();
		ContineButton.click();
		return new AccountSuccessPage(driver);

	}	

public AccountSuccessPage registerWithAllFields(String firstName,String lastName,String email,String telephone,String passoword,String confirmPassoword) {
		
		fistNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		telephoneField.sendKeys(telephone);
		passwordField.sendKeys(passoword);
		confimPasswordField.sendKeys(confirmPassoword);
		newslatter.click();
		agreeClick.click();
		ContineButton.click();
		return new AccountSuccessPage(driver);

	}	

		
public AccountSuccessPage registerWithExistingEmailField(String firstName,String lastName,String email,String telephone,String passoword,String confirmPassoword) {
	
	fistNameField.sendKeys(firstName);
	lastNameField.sendKeys(lastName);
	emailField.sendKeys(email);
	telephoneField.sendKeys(telephone);
	passwordField.sendKeys(passoword);
	confimPasswordField.sendKeys(confirmPassoword);
	newslatter.click();
	agreeClick.click();
	ContineButton.click();
	return new AccountSuccessPage(driver);

}	
		
	}
	


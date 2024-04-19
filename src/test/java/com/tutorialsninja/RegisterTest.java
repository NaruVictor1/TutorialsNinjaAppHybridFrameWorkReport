package com.tutorialsninja;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Tutorialninja.Base.BaseClass;
import com.tutorialninja.pages.AccountSuccessPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.RegisterPage;
import com.tutorialsninja.Utils.Utilities;

public class RegisterTest extends BaseClass{
	
	public WebDriver driver;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;

	public RegisterTest() {
		super();
	}
	
	
		
	@BeforeMethod
	public void setUp() throws Exception {
		
		driver=initializaBrowser(prop.getProperty("browserName"));
		HomePage hp =new HomePage(driver);
		registerPage=hp.navigateToRegisterPage();
//		hp.clickOnMyAccount();
//		registerPage=hp.clickOnregisterOption();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


	
	@Test(priority = 1)
	public void verityRegisterAnAccountWithMandatoryFields() {
		
		
		accountSuccessPage=registerPage.registerWithMandatoryFields(dataprop.getProperty("firstName"),dataprop.getProperty("lastName"),Utilities.generateEmailWithtimeStamp(),dataprop.getProperty("telephone"),prop.getProperty("validPassword"),prop.getProperty("validPassword"));
//		registerPage.enterFirstName(dataprop.getProperty("firstName"));
//		registerPage.enterLastName(dataprop.getProperty("lastName"));
//		registerPage.enterEmail(Utilities.generateEmailWithtimeStamp());  //classname.staticMethos
//		registerPage.enterTelephone(dataprop.getProperty("telephone"));
//		registerPage.enterPassword(prop.getProperty("validPassword"));
//		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//		registerPage.clickOnprivacyPolicy();
//		accountSuccessPage = registerPage.clickOnContinue();
        assertTrue(accountSuccessPage.retrieveAccountSuccessPageheading(),dataprop.getProperty("accountCreadted"));
	}
	@Test(priority = 2,testName = "RegisterTest")
	public void verityRegisterAnAccountWithAllfields(){
		
		accountSuccessPage=registerPage.registerWithAllFields(dataprop.getProperty("firstName"),dataprop.getProperty("lastName"),Utilities.generateEmailWithtimeStamp(),dataprop.getProperty("telephone"),prop.getProperty("validPassword"),prop.getProperty("validPassword"));

//		registerPage.enterFirstName(dataprop.getProperty("firstName"));
//		registerPage.enterLastName(dataprop.getProperty("lastName"));
//		registerPage.enterEmail(Utilities.generateEmailWithtimeStamp());  //classname.staticMethos
//		registerPage.enterTelephone(dataprop.getProperty("telephone"));
//		registerPage.enterPassword(prop.getProperty("validPassword"));
//		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//		registerPage.clickOnNewsLetter();
//        registerPage.clickOnprivacyPolicy();
//        accountSuccessPage=registerPage.clickOnContinue();
        assertTrue(accountSuccessPage.retrieveAccountSuccessPageheading(),dataprop.getProperty("accountCreadted"));
	}
	@Test(priority = 3)
	public void verityRegisterAnAccountWithExistingEmailAddresss() throws Exception {
		
		
		accountSuccessPage=registerPage.registerWithExistingEmailField(dataprop.getProperty("firstName"),dataprop.getProperty("lastName"),prop.getProperty("validEmail"),dataprop.getProperty("telephone"),prop.getProperty("validPassword"),prop.getProperty("validPassword"));

//		registerPage.enterFirstName(dataprop.getProperty("firstName"));
//		registerPage.enterLastName(dataprop.getProperty("lastName"));
//		registerPage.enterEmail(prop.getProperty("validEmail"));                //classname.staticMethos
//		registerPage.enterTelephone(dataprop.getProperty("telephone"));
//		registerPage.enterPassword(prop.getProperty("validPassword"));
//		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//		registerPage.clickOnNewsLetter();
//       registerPage.clickOnprivacyPolicy();
//        registerPage.clickOnContinue();
        String actual=registerPage.retrieveDuplicateEmailAddressWarning();
        assertEquals(actual,dataprop.getProperty("emailWarning"));
	
	}
	@Test(priority = 4)
	public void verityRegisterAnAccountWithoutAntCretendials() {
		registerPage.clickOnContinue();
        String actual=registerPage.retrievePravacyPolicyAddressMessage();
        assertTrue(actual.contains(dataprop.getProperty("privacypolicyWarning")));
	}

}

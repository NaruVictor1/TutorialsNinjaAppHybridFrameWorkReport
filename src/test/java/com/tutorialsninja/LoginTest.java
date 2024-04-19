package com.tutorialsninja;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Tutorialninja.Base.BaseClass;
import com.supplay.SupplyData;
import com.tutorialninja.pages.AccountPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.LoginPage;
import com.tutorialsninja.Utils.Utilities;

public class LoginTest extends BaseClass{

	public WebDriver driver;
	LoginPage login;

	public LoginTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws Exception{
		
		driver=initializaBrowser(prop.getProperty("browserName"));	
		HomePage homepage =new HomePage(driver);
//		homepage.clickOnMyAccount();
//		login= homepage.selectLoginOption();
		login=homepage.navigateToLoginPage();
		
	}
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	

	@Test(priority = 0,dataProvider = "supplyTestData",dataProviderClass = SupplyData.class)
	public void verifyLoginWithVaildCredentails(String email,String password){
		
		AccountPage accountPage = login.login(email, password);
//		login.enterEmailAddress(email);
//		login.enterPassword(password);
//		AccountPage accountPage = login.clickOnLoginButton();
		
		assertTrue(accountPage.getDisplayStatusOfeditYourAccountInformationOption(),"after login button clicks show YourAcctount information");
		String actualTitle=driver.getTitle();
		String expectedTitle="My Account";
		assertEquals(actualTitle, expectedTitle);
	}


	@Test(priority = 1)
	public void verifyLoginwithInvalidCredentails() {

		  login.login(Utilities.generateEmailWithtimeStamp(),dataprop.getProperty("invalidpassword"));
//        login.enterEmailAddress(Utilities.generateEmailWithtimeStamp());
//        login.enterPassword(dataprop.getProperty("invalidpassword"));
//        login.clickOnLoginButton();
		String actual=login.warningmessageDisplayed();
		String expected=dataprop.getProperty("warning");
		assertTrue(actual.contains(expected));
		
	}


	@Test(priority = 2)
	public void verifyLoginwithInvalidEmailAndValidPassword() {
		login.login(Utilities.generateEmailWithtimeStamp(),prop.getProperty("validPassword"));
//		login.enterEmailAddress(Utilities.generateEmailWithtimeStamp());        //invalied email
//		login.enterPassword(prop.getProperty("validPassword"));                 //validpassword
//      login.clickOnLoginButton();
        String actual=login.warningmessageDisplayed();
		String expected=dataprop.getProperty("warning");
		assertTrue(actual.contains(expected));
	}
	
	@Test(priority = 3)
	public void verifyLoginwithvalidEmailAndInValidPassword() throws Exception{
//		System.out.println(10/0);
		login.login(Utilities.generateEmailWithtimeStamp(),dataprop.getProperty("invalidpassword"));
//		login.enterEmailAddress(Utilities.generateEmailWithtimeStamp());         //valied email
//		login.enterPassword(dataprop.getProperty("invalidpassword"));            //Invalidpassword
//		login.clickOnLoginButton();
		String actual=login.warningmessageDisplayed();
		String expected=dataprop.getProperty("warning");
		assertTrue(actual.contains(expected));

	}
	@Test(priority = 4,dependsOnMethods = "verifyLoginwithvalidEmailAndInValidPassword")
	public void verifyLoginwithoutProvindingCretials() {

        login.clickOnLoginButton();
        String actual=login.warningmessageDisplayed();
		String expected=dataprop.getProperty("warning");
		assertTrue(actual.contains(expected));

	}
}

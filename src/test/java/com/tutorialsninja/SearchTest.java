package com.tutorialsninja;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Tutorialninja.Base.BaseClass;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.SearchPage;

public class SearchTest extends BaseClass{

	SearchPage searchPage;
	HomePage homePage;
	public SearchTest(){
		super();
	}

	private WebDriver driver;


	@BeforeMethod
	public void setUp() throws Exception{

		driver=initializaBrowser(prop.getProperty("browserName"));
		homePage=new HomePage(driver);

	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void searchForValidProduct() {
		searchPage=homePage.searchForProduct(dataprop.getProperty("validProduct"));
//		homePage.enterProduct(dataprop.getProperty("validProduct"));
//		searchPage = homePage.clickonSearchButton();
		assertTrue(searchPage.HpHeadingDisplayed());
	}

	@Test(priority = 2)
	public void searchForInValidProduct() throws Exception {
		searchPage=homePage.searchForProduct(dataprop.getProperty("inValidProduct"));
//		homePage.enterProduct(dataprop.getProperty("inValidProduct"));
//		searchPage = homePage.clickonSearchButton();
		assertTrue(searchPage.noProductCretiria());
	}

	@Test(priority = 3)
	public void searchForWithoutProvidingCredentials(){
		searchPage=homePage.clickonSearchButton();
		assertTrue(searchPage.noProductMatchesThesearchCriteria());
	}

}

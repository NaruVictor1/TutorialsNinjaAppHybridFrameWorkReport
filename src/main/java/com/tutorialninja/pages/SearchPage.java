package com.tutorialninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;

	//objects
	

	@FindBy(xpath = "//a[.='HP LP3065']")
	private WebElement HPheading;

	@FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
	private WebElement noMoreProductcriteria;

	@FindBy(xpath = "//p[starts-with(.,'There is no product that')]")
	private WebElement noProductMatchesThesearchCriteria;

	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	//actions
	public boolean HpHeadingDisplayed() {
		boolean heading = HPheading.isDisplayed();
		return heading;
	}

	public boolean noProductCretiria() {
		boolean product = noMoreProductcriteria.isDisplayed();
		return product;
	}
	public boolean noProductMatchesThesearchCriteria() {
		boolean noProduct = noProductMatchesThesearchCriteria.isDisplayed();
		return noProduct;
	}



}

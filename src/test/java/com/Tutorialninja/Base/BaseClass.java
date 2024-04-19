package com.Tutorialninja.Base;

import java.io.File;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	WebDriver driver;
	public Properties prop;
	public Properties dataprop;


	public  BaseClass() {

		prop=new Properties();
		File propFile=new File("C:\\javapratice\\JavaPractice\\LiveProjectSelenium\\src\\main\\java\\com\\tutorial\\config/config.properties");
		
		dataprop=new Properties();
		File datapropFile=new File("C:\\javapratice\\JavaPractice\\LiveProjectSelenium\\src\\main\\java\\com\\tutorialsninja\\testdata/testdata.properties");

		try {
			FileInputStream fis2 =new FileInputStream(datapropFile);
			dataprop.load(fis2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		try {
			FileInputStream fis =new FileInputStream(propFile);
			prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}

		

	}


	public WebDriver initializaBrowser(String broswerName) {

		if(broswerName.equals("chrome")){
			driver=new ChromeDriver();
		}
		else if(broswerName.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(broswerName.equals("edge")) {
			driver=new EdgeDriver();
		}
		else {
			System.out.println("invalied browers");
		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

		return driver;
	}
}

package com.tutorialsninja.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tutorial.config.ExtentReporter;
import com.tutorialsninja.Utils.Utilities;


public class ListenersClass implements ITestListener{
	ExtentReports extentReport;
	ExtentTest extendTest;
	String testName;
	
	@Override
	public void onStart(ITestContext context) {
		extentReport = ExtentReporter.generateExtentReport(); //class.static method
	}

	@Override
	public void onTestStart(ITestResult result) {
		testName=result.getName();
	    extendTest = extentReport.createTest(testName);
		extendTest.log(Status.INFO, testName+" stared exection");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extendTest.pass(result.getName()+"got successully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {	
		
	WebDriver driver = null;
	try {
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (IllegalArgumentException e) {
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	} catch (NoSuchFieldException e) {
		e.printStackTrace();
	} catch (SecurityException e) {
		e.printStackTrace();
	}
		
	String path=Utilities.captureScreenshot(driver,result.getName());// if we not extend that class using class name
	    
	extendTest.log(Status.FAIL,MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    extendTest.addScreenCaptureFromPath(path);
	
		System.out.println("screenshort succussfull");
		extendTest.info(result.getThrowable());
		extendTest.fail(testName+"got failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
        extendTest.skip(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context){

		extentReport.flush();
		
		try {
			Desktop.getDesktop().browse(new File("C:/javapratice/JavaPractice/LiveProjectSelenium/test-output/ExtentReporters/sample.html").toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

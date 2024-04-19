package com.tutorialsninja.Utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {

	public  static String generateEmailWithtimeStamp() {
		Date date=new Date();
		String timestamp= date.toString().replace(" ","_").replace(":","_");
		return "narunaamma"+timestamp+"@gamil.com";
	}
	
	
	public static String captureScreenshot(WebDriver driver,String testName) {
		
		TakesScreenshot  takesScreenshot= (TakesScreenshot) driver;
		
		File source=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String path="./Screenshot/+"+testName+"+.jpg";
	    File dist=new File(path);
		try {
			FileUtils.copyFile(source, dist);
		    }catch (IOException e) {
			e.printStackTrace();
		    }
		
		return dist.getAbsolutePath();
	}
}

package com.tutorial.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter{

static	WebDriver driver;
	public static ExtentReports generateExtentReport() {
		ExtentReports extentReport = new ExtentReports();
		File file =new File("C:\\javapratice\\JavaPractice\\LiveProjectSelenium\\test-output\\ExtentReporters/sample.html");
		ExtentSparkReporter extentSparkReporter= new ExtentSparkReporter(file);
		extentReport.attachReporter(extentSparkReporter);
		
		ExtentSparkReporterConfig config = extentSparkReporter.config();
		config.setTheme(Theme.DARK);
		config.setDocumentTitle("tutorials ninja automation test");
		config.setReportName("NVR aumotion Report");
		config.setTimeStampFormat("yyyymmdd hhmmss");
		
		
		
//	Capabilities  capabilities =((RemoteWebDriver)driver).getCapabilities();
	
           Properties prop=new Properties();
           File file1=new File("./src/main/java/com/tutorial/config/config.properties");
           try {
           FileInputStream fis=new FileInputStream(file1);
           prop.load(fis);
           }catch (Exception e) {
        	   e.printStackTrace();
		}
	
   		extentReport.setSystemInfo("name",System.getProperty("user.name"));
		extentReport.setSystemInfo("version",System.getProperty("java.version"));
		extentReport.setSystemInfo("os",System.getProperty("os.name"));
//		extentReport.setSystemInfo("browserNmae",capabilities.getBrowserName());
//		extentReport.setSystemInfo("browserversion",capabilities.getBrowserVersion());
		extentReport.setSystemInfo("URL",prop.getProperty("url"));
		extentReport.setSystemInfo("name",prop.getProperty("name"));
		extentReport.setSystemInfo("password",prop.getProperty("password"));

		return extentReport;
	}
	
}

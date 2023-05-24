package com.sore.utilities;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport()
	{
		String timetStamp = new SimpleDateFormat("dd.mm.yyyy.hh.mm.ss").format(new Date());
		String reportName = "StoreTestReport-" + timetStamp + ".html" ;
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add system information
		reports.setSystemInfo("Machine", "abhijain");
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("user", "abhi");
		
		
		//config to change look and feel
		htmlReporter.config().setDocumentTitle("Execution Report");
		htmlReporter.config().setReportName("Report Name");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	public void onStart(ITestContext Result)
	{
		configureReport();
		System.out.println("On Start method..");
	}
	
	public void onFinish(ITestContext Result)
	{
		System.out.println("On Finish method..");
		reports.flush();//mandatory to call flush method to ensure information is written to reports
		
	}
	
	public void onTestFailure(ITestResult Result)
	{
		System.out.println("Name of the test method failed" + Result.getName());
		test = reports.createTest(Result.getName()); //create entry in report for failed
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is : "  + Result.getName() , ExtentColor.RED));

		String ss = System.getProperty("user.dir") + "\\Screenshots\\" + Result.getName() + ".png";
		File ssfile = new File(ss);
		if (ssfile.exists())
		{
			test.fail("Captured ss is below : " + test.addScreenCaptureFromPath(ss));
		}
	}
	
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println("Name of the test method skipped" + Result.getName());
	
		test = reports.createTest(Result.getName()); //create entry in report for failed
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skippped test case is : "  + Result.getName() , ExtentColor.ORANGE));
	}
	
	public void onTestStart(ITestResult Result)
	{
		System.out.println("Name of the test method started" + Result.getName());
	}
	
	public void onTestSuccess(ITestResult Result)	
	{
		System.out.println("Name of the test method passed" + Result.getName());
			
		test = reports.createTest(Result.getName()); //create entry in report for failed
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is : "  + Result.getName() , ExtentColor.GREEN));
	
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
	{		

	}	
	
}

package com.restcountry.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners implements ITestListener  {

	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public void onStart(ITestContext testcontext)
	{
		
	}

	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "test case is passed " +result.getName());
		if(result.getStatus()==ITestResult.SUCCESS)
	    {
	        test.log(Status.PASS,result.getName());

	    }

	}
	public void onFailure(ITestResult result)
	{
		
	}
	public void onSkipped(ITestResult result)
	{
		

	}
	public void onFinish(ITestContext testcontext)
	{
		extent.flush();

	}

	@Override
	public void onTestStart(ITestResult result) {
		reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//reports/report.html");
				
		reporter.config().setDocumentTitle("RestCountryApi Testing");
		reporter.config().setReportName(" Automated Api testing");
		reporter.config().setTheme(Theme.DARK);
	
		extent.setSystemInfo("host name", "localhost");
		extent.setSystemInfo("user", "swetha");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "test case is failure " +result.getName());
		test.log(Status.FAIL, "test case is failure " +result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "test case is Skipped " +result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	


}


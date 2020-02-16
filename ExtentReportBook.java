package com.book;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportBook implements ITestListener {
	ExtentHtmlReporter report;
	ExtentReports extent;
	ExtentTest logger;						
	

	@Override
	public void onFinish(ITestContext ctx) {
		extent.flush();
		extent.close();
		
	}

	@Override
	public void onStart(ITestContext ctx) {
		report = new ExtentHtmlReporter("./Report/Book_Details.html");
		extent = new ExtentReports();
		extent.attachReporter(report);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.log(Status.FAIL, result.getName()+" test case failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		logger = extent.createTest(result.getName());
		logger.log(Status.INFO, result.getName()+" start executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.log(Status.PASS, result.getName()+" test case pass");
		
	}

}

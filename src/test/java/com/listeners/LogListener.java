package com.listeners;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LogListener implements ITestListener {
	
	private ExtentReports extentReport;
	private ExtentTest extentTest;
	private ExtentSparkReporter sparkReporter;
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("========================================== "+ result.getName() + " Test Started: =========================================");
		System.out.println("DESCRIPTION: " + result.getMethod().getDescription());
		System.out.println("GROUPS: " + Arrays.toString(result.getMethod().getGroups()));
		System.out.println("TEST START TIME: " + result.getStartMillis());
		
		extentTest = extentReport.createTest(result.getMethod().getMethodName());
        extentTest.log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());

		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("=========================================== " + result.getName() + " Test Passed: =====================================");
		System.out.println("TEST END TIME: " + result.getEndMillis());
		
		extentTest.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());

	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("======================================== " + result.getName() + " Test Failed: =====================================");
		System.out.println("Test Failed: " + result.getName());
		
		
        extentTest.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        extentTest.log(Status.FAIL, result.getThrowable());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("==================================== " + result.getName() + " Test Skipped: ==================================");
		System.out.println("Test Skipped: " + result.getName());
		
		extentTest.log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());

	}
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("========================================== " + context.getName() + " Test Suite Started: =========================================");
		
		sparkReporter = new ExtentSparkReporter("ExtentReport.html");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Automation Test Report");
		sparkReporter.config().setDocumentTitle("API Automation Test Report");
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReporter);
	}
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("========================================== " + context.getName() + " Test Suite Finished: =========================================");
		extentReport.flush();
	}

}

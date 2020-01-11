package com.qspiders.btm.actitime.generic;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listener implements ITestListener {

	private ExtentReports reports;
	private ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getName());
		test.info("Started: " + result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.pass("Passed: " + result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		try {
			test.addScreenCaptureFromPath("./src/test/resources/screenshot/failure.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.fail("Failed: " + result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		test.skip("Skipped: " + result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		reports = ExtentLib.init();
		
	}

	public void onFinish(ITestContext context) {
		reports.flush();

	}

}

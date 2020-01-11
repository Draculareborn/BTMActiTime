package com.qspiders.btm.actitime.generic;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentLib {
	public static ExtentReports init() {

//		Create ExtentHtmlReporter object
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File("./reports/ActitimeReport.html"));
		reporter.config().setDocumentTitle("Google Title");
		reporter.config().setReportName("Google Name");
		reporter.config().setTheme(Theme.DARK);

//		Create ExtentReports object and attach it to the reporter
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Environment", "Testing");
		reports.setSystemInfo("Platform", "Win7 Ultimate x64");
		reports.setSystemInfo("Version", "actiTIME 2017.4");
		reports.setSystemInfo("Build", "39769");
		reports.setSystemInfo("Engineer", "Ramya");
		
		return reports;
	}
}

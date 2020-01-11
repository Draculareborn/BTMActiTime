package com.qspiders.btm.actitime.generic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.google.common.io.Files;
import com.qspiders.btm.actitime.pages.ATEnterTTPage;
import com.qspiders.btm.actitime.pages.ATLoginPage;

@Listeners(com.qspiders.btm.actitime.generic.Listener.class)
public class BaseTest implements IFilePaths {

	public WebDriver driver;
	public ATLoginPage loginPage;
	public ATEnterTTPage enterTTPage;
	
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		
		driver.get(FileLib.readValue(BROWSER, "url"));
	}
	
	@BeforeClass
	public void login() {
		String username = FileLib.readValue(USER, "username");
		String password = FileLib.readValue(USER, "password");
		loginPage = new ATLoginPage(driver);
		enterTTPage = loginPage.login(username, password);
	}
	
	@AfterMethod
	public void captureError(ITestResult result) {
		if(result.getStatus()==2) {
			//Take Screenshot
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./src/test/resources/screenshot/failure.png");
			try {
				Files.copy(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@AfterClass
	public void logout() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		enterTTPage.logout();
	}
	
	@AfterTest
	public void closeBrowser() {
//		driver.quit();
	}
}

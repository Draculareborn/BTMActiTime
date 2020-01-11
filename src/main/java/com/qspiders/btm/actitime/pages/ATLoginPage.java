package com.qspiders.btm.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ATLoginPage {
	
	WebDriver driver;
	
	@FindBy(id="username") private WebElement unTxtB;
	@FindBy(name="pwd") private WebElement pwTxtB;
	@FindBy(id="loginButton") private WebElement loginBtn;
	
	public ATLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ATEnterTTPage login(String username, String password) {
		unTxtB.sendKeys(username);
		pwTxtB.sendKeys(password);
		loginBtn.click();
		return new ATEnterTTPage(driver);
	}
}

package com.qspiders.btm.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ATEnterTTPage {
	
	WebDriver driver;
	
	@FindBy(id="logoutLink") private WebElement logoutLnk;
	@FindBy(xpath="//div[contains(text(), 'Settings')]") private WebElement settingsTab;
	@FindBy(linkText="Licenses") private WebElement licensesLnk;
	
	public ATEnterTTPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logout() {
		logoutLnk.click();
	}
	
	public ATLicensePage navigateToLicenses() {
		settingsTab.click();
		licensesLnk.click();
		return new ATLicensePage(driver);
	}
}

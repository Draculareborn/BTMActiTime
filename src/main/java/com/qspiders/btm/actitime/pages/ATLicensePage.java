package com.qspiders.btm.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ATLicensePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//nobr[text()='Product Edition:']/following::td") private WebElement prodEdn;
	
	public ATLicensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProdEdn() {
		return prodEdn.getText();
	}
}

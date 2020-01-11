package com.qspiders.btm.actitime.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qspiders.btm.actitime.generic.BaseTest;
import com.qspiders.btm.actitime.pages.ATLicensePage;

public class ATVersionTest extends BaseTest {
	@Test
	public void getVersion() {
		ATLicensePage licenses = enterTTPage.navigateToLicenses();
//		String lic = licenses.getProdEdn();
//		Assert.assertEquals("actiTIME 2017.4", lic);
		Assert.assertEquals("actiTIME 2017", licenses.getProdEdn());
	}

}

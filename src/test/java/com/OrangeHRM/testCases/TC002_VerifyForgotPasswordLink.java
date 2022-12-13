package com.OrangeHRM.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.pageObjects.LoginPage;
import com.OrangeHRM.testBase.BaseClass;

public class TC002_VerifyForgotPasswordLink extends BaseClass{
	
	@Test
	public void forgotPasswordLinkTest() {
		LoginPage lp = new LoginPage(driver);
		String retVal = lp.getForgotPasswordText();
		Assert.assertEquals(retVal, "Forgot your password?", "Forgot your password? link is not displayed");
		//System.out.println("Forgot your password? link is displayed");
		logger.info("Forgot your password? link is displayed");
	}
}

package com.OrangeHRM.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.pageObjects.LoginPage;
import com.OrangeHRM.testBase.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_UserLoginTest extends BaseClass{
	@Test
	public void loginTest() {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(prop.getProperty("username"));
		lp.setPassword(prop.getProperty("password"));
		lp.clickLoginButton();
		boolean status = driver.findElement(By.xpath("//div[@class='oxd-brand-banner']")).isDisplayed();
		Assert.assertEquals(status, true, "User did not logged into application");
		//System.out.println("User has logged into application");
		logger.info("User has logged into application");
	}
	
	

}

package com.OrangeHRM.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;
	
	public Logger logger = LogManager.getLogger(this.getClass());
	
	
	@BeforeMethod
	@Parameters("browser")
	public void setup(String br) throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Training\\Selenium\\ClassTraining_2022\\DemoOrangeHRM\\resources\\config.properties");
		prop.load(fis);
				
		if (br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome Browser is launched successfully");
		} else if(br.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("Edge Browser is launched successfully");
		} else {
			logger.info("Browsers supported as Chrome / Edge");
		}
		
		driver.manage().window().maximize();
		logger.info("URL that will be entered in the browser is - " + prop.getProperty("url"));
		
		driver.get(prop.getProperty("url"));
		
		logger.info("Orange HRM application is opened");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		logger.info("Orange HRM application is closed");
	}

}

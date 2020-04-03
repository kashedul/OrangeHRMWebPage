package com.bitm.OrangeHRMAutomation.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	
	static{
		System.setProperty("webdriver.gecko.driver", "F:\\Kashedul\\Selenium Files\\Gecko\\geckodriver.exe");
	}
		
	public static WebDriver dr = new FirefoxDriver();
	
	
 
	private DriverManager(){
		
		
	}

}

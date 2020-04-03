package com.bitm.OrangeHRMAutomation.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bitm.OrangeHRMAutomation.DTO.LoginDTO;
import com.bitm.OrangeHRMAutomation.Provider.LoginDataProvider;
import com.bitm.OrangeHRMAutomation.Utils.DriverManager;
import com.bitm.OrangeHRMAutomation.Utils.UrlTextUtils;
import com.bitm.OrangeHRMAutomation.Utils.XpathUtils;

public class LoginTest {
	
private WebDriver wb = null;
	
	@Test(priority = 1)
	public void checkloginpagetitle() {
		
		
		wb = DriverManager.dr;
		
		wb.get(UrlTextUtils.URL.BaseUrl);
		
		Assert.assertEquals(wb.getTitle(),UrlTextUtils.Text.LoginPageTitle);
		
		System.out.println("Login Page Verified");

}
	
	@Test(priority = 2, dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
	public void logintest (List<LoginDTO> logindata) {
		
		for(LoginDTO login:logindata) {
		
		wb.findElement(By.xpath(XpathUtils.LoginTest.UserName)).sendKeys(login.getUsername());
		
		wb.findElement(By.xpath(XpathUtils.LoginTest.Password)).sendKeys(login.getPassword());
		
		wb.findElement(By.xpath(XpathUtils.LoginTest.SignIn)).click();
		
		wb.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println("Login Successfully");

		
	}
	

  }
	
	
	
	
}

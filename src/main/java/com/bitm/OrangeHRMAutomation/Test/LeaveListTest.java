package com.bitm.OrangeHRMAutomation.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bitm.OrangeHRMAutomation.DTO.LeaveListDTO;
import com.bitm.OrangeHRMAutomation.Provider.LeaveListProvider;
import com.bitm.OrangeHRMAutomation.Utils.DriverManager;
import com.bitm.OrangeHRMAutomation.Utils.UrlTextUtils;
import com.bitm.OrangeHRMAutomation.Utils.XpathUtils;

public class LeaveListTest {
	
	
private WebDriver wc = null;
	
	
	@Test (priority = 1)
	public void CheckFlightFinderTitle () {
		
		wc = DriverManager.dr;
		
		WebDriverWait wt = new WebDriverWait(wc, 20);
		
		WebElement el = wt.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathUtils.LeaveListTest.Leave)));
		
		Assert.assertEquals(wc.getTitle(),UrlTextUtils.Text.LeaveListPageTitle);
		
		System.out.println("LeaveList Page Verified");

  }
	
	
	@Test(priority = 2, dataProvider = "leavelistData", dataProviderClass = LeaveListProvider.class)
	public void logintest (List<LeaveListDTO> leavelistdata) {
		
		for(LeaveListDTO leavelist:leavelistdata) {
		
		//wc.findElement(By.xpath(XpathUtils.LeaveListTest.LeaveList)).click();
			
			//Double Click
			Actions action = new Actions(wc) ;
			action.moveToElement(wc.findElement(By.xpath(XpathUtils.LeaveListTest.Leave))).doubleClick().perform();
		
		
		wc.findElement(By.xpath(XpathUtils.LeaveListTest.DatePicker)).click();
		
		//Select Month
		wc.findElement(By.xpath(XpathUtils.LeaveListTest.Month)).click();
		Select Month = new Select(wc.findElement(By.xpath(XpathUtils.LeaveListTest.Month)));
		Month.selectByVisibleText(leavelist.getMonth());
		
		//Select Year
		wc.findElement(By.xpath(XpathUtils.LeaveListTest.Year)).click();
		Select Year = new Select(wc.findElement(By.xpath(XpathUtils.LeaveListTest.Year)));
		Year.selectByVisibleText(leavelist.getYear());
		
		//Select Date
		WebElement dateWidget = wc.findElement(By.className("ui-datepicker-calendar"));
		List<WebElement> columns=dateWidget.findElements(By.tagName("td"));

		for (WebElement cell: columns){
		 //Select 1th Date 
		 if (cell.getText().equals(leavelist.getDate())){
		 cell.findElement(By.linkText(leavelist.getDate())).click();
		  break;
		 }
		   
	}
		
		wc.findElement(By.xpath(XpathUtils.LeaveListTest.Scheduled)).click();
		
		Select SubUnit = new Select(wc.findElement(By.xpath(XpathUtils.LeaveListTest.SubUnit)));
		SubUnit.selectByVisibleText(leavelist.getSubUnit());
		
		wc.findElement(By.xpath(XpathUtils.LeaveListTest.Save)).click();
		
		System.out.println("LeaveList Page Succesfull");
		
	}
		
		
	
	}
	
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
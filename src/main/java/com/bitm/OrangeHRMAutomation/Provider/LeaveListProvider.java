package com.bitm.OrangeHRMAutomation.Provider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.bitm.OrangeHRMAutomation.Utils.ExcelUtils;

public class LeaveListProvider {
	
	@DataProvider(name="LeaveListData")
	public static Object [][] getLeaveListData(){
		try {
			return new Object[][]{
					{
						ExcelUtils.getLeaveListData()
					},
				};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	        
    }


}

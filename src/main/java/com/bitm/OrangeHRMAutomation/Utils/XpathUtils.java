package com.bitm.OrangeHRMAutomation.Utils;

public class XpathUtils {
	
public class LoginTest {
		
		public static final String UserName = "//*[@id=\"txtUsername\"]";
		
		public static final String Password = "//*[@id=\"txtPassword\"]";
		
		public static final String SignIn = "//*[@id=\"btnLogin\"]";
		
	}

public class LeaveListTest {

	public static final String Leave = "//*[@id=\"menu_leave_viewLeaveModule\"]/b";
	
	public static final String DatePicker = "//*[@id=\"calFromDate\"]";
	
	public static final String Month = "//*[@id=\"ui-datepicker-div\"]/div/div/select[1]";
	
	public static final String Year = "//*[@id=\"ui-datepicker-div\"]/div/div/select[2]";
	
	public static final String Date = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[1]/a";
	
	public static final String Scheduled = "//*[@id=\"leaveList_chkSearchFilter_2\"]";
	
	public static final String Employee = "//*[@id=\"leaveList_txtEmployee_empName\"]";
	
	public static final String SubUnit = "//*[@id=\"leaveList_cmbSubunit\"]";
	
	public static final String Save = "//*[@id=\"btnSave\"]";
	
}

}

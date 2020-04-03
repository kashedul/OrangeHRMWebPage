package com.bitm.OrangeHRMAutomation.DTO;

public class LeaveListDTO {
	
	
	private String Month;
	
	private String Year;
	
	private String Date;
	
	private String Employee;
	
    private String SubUnit;

	public String getMonth() {
		return Month;
	}

	public void setMonth(String month) {
		Month = month;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getEmployee() {
		return Employee;
	}

	public void setEmployee(String employee) {
		Employee = employee;
	}

	public String getSubUnit() {
		return SubUnit;
	}

	public void setSubUnit(String subUnit) {
		SubUnit = subUnit;
	}

	@Override
	public String toString() {
		return "LeaveListDTO [Month=" + Month + ", Year=" + Year + ", Date=" + Date + ", Employee=" + Employee
				+ ", SubUnit=" + SubUnit + "]";
	}
	
	

	
}

package com.bitm.OrangeHRMAutomation.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bitm.OrangeHRMAutomation.DTO.LeaveListDTO;
import com.bitm.OrangeHRMAutomation.DTO.LoginDTO;


public class ExcelUtils {
	private static FileInputStream inputStream = null;
	private static Workbook workbook = null;

	private static Sheet getSheet(int sheetNo) throws IOException {
		// change the file location as per your computer
		File f = new File("src/main/java");
		File fs = new File(f, "data.xlsx");
		inputStream = new FileInputStream(new File(fs.getAbsolutePath()));
		workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(sheetNo);
		return sheet;
		
	}
	

	public static List<LoginDTO> getLoginData() throws IOException {
		List<LoginDTO> logindata = new ArrayList<LoginDTO>();
		DataFormatter formatter = new DataFormatter();
		// login is the first sheet in excel so getSheet parameter set to 0
		Iterator<Row> iterator = ExcelUtils.getSheet(0).iterator();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			LoginDTO login = new LoginDTO();
			byte cellCounter = 0;
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cellCounter) {
				case 0:
					login.setUsername(formatter.formatCellValue(cell));
					cellCounter++;
					break;
				case 1:
					login.setPassword(formatter.formatCellValue(cell));
					break;
				default:
					break;
				}

			}
			logindata.add(login);
		}
		close();
		return logindata;
		
	}
	
		
	public static List<LeaveListDTO> getLeaveListData() throws IOException {
		List<LeaveListDTO> BookFlightdata = new ArrayList<LeaveListDTO>();
		DataFormatter formatter = new DataFormatter();
		// login is the fourth sheet in excel so getSheet parameter set to 0
		Iterator<Row> iterator = ExcelUtils.getSheet(3).iterator();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			LeaveListDTO LeaveList = new LeaveListDTO();
			byte cellCounter = 0;
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cellCounter) {
				case 0:
					LeaveList.setMonth(formatter.formatCellValue(cell));
					cellCounter++;
					break;
				case 1:
					LeaveList.setYear(formatter.formatCellValue(cell));
					cellCounter++;
					break;
				case 2:
					LeaveList.setDate(formatter.formatCellValue(cell));
					cellCounter++;
					break;
					
				case 3:
					LeaveList.setEmployee(formatter.formatCellValue(cell));
					cellCounter++;
					break;
					
				case 4:
					LeaveList.setSubUnit(formatter.formatCellValue(cell));
					cellCounter++;
					break;
					
				
				case 5:
					LeaveList.setSubUnit(formatter.formatCellValue(cell));
					break;
				default:
					break;
				}

			}
			BookFlightdata.add(LeaveList);
		}
		close();
		return BookFlightdata;
		
	}
					
				
		
		private static void close() throws IOException{
			workbook.close();
			inputStream.close();

		}

}

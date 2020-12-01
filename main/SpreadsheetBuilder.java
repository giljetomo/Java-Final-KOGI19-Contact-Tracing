package kogi19.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import kogi19.DatabaseHandler.DatabaseHandler;

public class SpreadsheetBuilder {
   
	DatabaseHandler dbhandler = null;
	     public boolean createSpreadsheet () throws IOException {
	    	 
	    	 boolean isSuccessful = false;
	    	 dbhandler = DatabaseHandler.getInstance();
	    	 ArrayList<ReportData> dataList = dbhandler.getArrayListOfDataForReport();
	    	 String[] columns = {"SOURCE_ID", "SOURCE NAME", "EXPOSED ID",  "EXPOSED NAME", "AGE", "PHONE", "EXPOSURE DATE", "LOCATION", "CLINIC NAME", "RESULT"};
	         XSSFWorkbook workbook = new XSSFWorkbook();
	         XSSFSheet sheet = workbook.createSheet("List of Exposed Individuals by Source");
	            
	         Row headerRow = sheet.createRow(0);
	            
	         for (int i = 0; i < columns.length; i++) {
	        	 Cell cell = headerRow.createCell(i);
	        	 cell.setCellValue(columns[i]);
	         }
	         
	         int rowNum = 1;
	         
	         for (ReportData data : dataList) {
	        	 Row row = sheet.createRow(rowNum++);
	        	 row.createCell(0).setCellValue(data.getSourceId());
	        	 row.createCell(1).setCellValue(data.getSourceName());
	        	 row.createCell(2).setCellValue(data.getExposedId());
	        	 row.createCell(3).setCellValue(data.getExposedName());
	        	 row.createCell(4).setCellValue(data.getAge());
	        	 row.createCell(5).setCellValue(data.getPhone());
	        	 row.createCell(6).setCellValue(data.getExposureDate());
	        	 row.createCell(7).setCellValue(data.getLocation()); 
	        	 row.createCell(8).setCellValue(data.getClinicName()); 
	        	 row.createCell(9).setCellValue(data.getResult()); 
	        	 
	         }
	         
	         for(int i = 0; i <columns.length; i++) {
	        	 sheet.autoSizeColumn(i);
	         }
	            
	        LocalDateTime dt = LocalDateTime.now();
	 		String dateformat = String.valueOf(dt.getYear()) + dt.getMonthValue() + dt.getDayOfMonth() + "." + dt.getHour() + "." + dt.getMinute() + "." + dt.getSecond();
	 		File file = new File("KOGI-19-ExposedIndividuals" + dateformat + ".xlsx");
	 		
	 		  try (FileOutputStream outputStream = new FileOutputStream(file)) {
	             workbook.write(outputStream);
	             outputStream.close();
	             workbook.close();
	             isSuccessful = true;
	         }
	 		  
	 	return isSuccessful;
	            
	     }
}

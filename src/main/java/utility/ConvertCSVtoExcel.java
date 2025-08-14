package utility;

import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static org.testng.Assert.fail;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.IOException;
//import utility.ExcelReader;
	public class ConvertCSVtoExcel {

		public void convertCsvToExcel(String csvFilePath, String excelFilePath) {
	        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
	             XSSFWorkbook workbook = new XSSFWorkbook();  // For .xlsx format
	             FileOutputStream fos = new FileOutputStream(excelFilePath)) {

	            // Create a new sheet in the workbook
	            Sheet sheet = workbook.createSheet("Sheet1");

	            String line;
	            int rowIndex = 0;

	            // Read each line from the CSV
	            while ((line = br.readLine()) != null) {
	                // Split each line by comma (assuming comma-separated values)
	                String[] values = line.split(",");

	                // Create a new row in the sheet
	                Row row = sheet.createRow(rowIndex++);

	                // Create a cell for each value in the CSV
	                for (int colIndex = 0; colIndex < values.length; colIndex++) {
	                    Cell cell = row.createCell(colIndex);
	                    cell.setCellValue(values[colIndex]);
	                }
	            }

	            // Write the Excel file to the output file path
	            workbook.write(fos);

	            System.out.println("CSV file successfully converted to Excel: " + excelFilePath);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public String readFirstRow(String filePath) {
	        StringBuilder rowContent = new StringBuilder();
	        try (FileInputStream fis = new FileInputStream(filePath);
	             Workbook workbook = new XSSFWorkbook(fis)) {
	            
	            // Access the first sheet
	            Sheet sheet = workbook.getSheetAt(0);
	            
	            // Get the first row
	            Row row = sheet.getRow(0);
	            if (row != null) {
	                for (Cell cell : row) {
	                    // Append each cell's content to the string builder
	                    switch (cell.getCellType()) {
	                        case STRING:
	                            rowContent.append(cell.getStringCellValue()).append("\t");
	                            break;
	                        case NUMERIC:
	                            rowContent.append(cell.getNumericCellValue()).append("\t");
	                            break;
	                        case BOOLEAN:
	                            rowContent.append(cell.getBooleanCellValue()).append("\t");
	                            break;
	                        case FORMULA:
	                            rowContent.append(cell.getCellFormula()).append("\t");
	                            break;
	                        default:
	                            rowContent.append(" ").append("\t");
	                            break;
	                    }
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return rowContent.toString().trim();
	    }
	    
		/*
		 * public static void main(String[] args) { String csvFilePath =
		 * "C:\\Users\\LENOVO\\Downloads\\PTdeductionReport (3).xls"; String
		 * xlsxFilePath = "C:\\Users\\LENOVO\\Downloads\\PTdeductionReport (3)100.xlsx";
		 * 
		 * convertCsvToExcel(csvFilePath, xlsxFilePath); }
		 */
	    public String readExcelToString(String filePath) {
            StringBuilder result = new StringBuilder();
            
            try (FileInputStream fis = new FileInputStream(filePath);
                 XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
                
                // Iterate through each sheet in the workbook
                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                    Sheet sheet = workbook.getSheetAt(i);
                    
                    // Append the sheet name (optional)
                    result.append("Sheet: ").append(sheet.getSheetName()).append("\n");
                    
                    // Iterate through each row in the sheet
                    for (Row row : sheet) {
                        // Iterate through each cell in the row
                        for (Cell cell : row) {
                            // Append the cell's content depending on its type
                            switch (cell.getCellType()) {
                                case STRING:
                                    result.append(cell.getStringCellValue()).append("\t");
                                    break;
                                case NUMERIC:
                                    result.append(cell.getNumericCellValue()).append("\t");
                                    break;
                                case BOOLEAN:
                                    result.append(cell.getBooleanCellValue()).append("\t");
                                    break;
                                case FORMULA:
                                    result.append(cell.getCellFormula()).append("\t");
                                    break;
                                default:
                                    result.append(" ").append("\t");
                                    break;
                            }
                        }
                        // Add a newline after each row
                        result.append("\n");
                    }
                    // Add a newline after each sheet
                    result.append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result.toString();
        }
	    
	public boolean stringpresent(String text,String teststring) {
		if (text.contains(teststring)) {
			//	System.out.println("Given string is present in the provided pdf: " + teststring);
				return true;
			}else {
			//System.out.println("Given string is not present");   
			fail("Condition check failed."); 
			return false;} 
	   
	}

	}
   


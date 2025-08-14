package utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import utility.ExcelReader;

public class testReadExcelFile {  
	//ExcelReader excelReader;
    public static void main(String[] args) {
    	
       	String excelFilePath = "C:\\Users\\LENOVO\\Downloads\\StudentRollList501.xlsx"; 

        try (FileInputStream fis = new FileInputStream(new File(excelFilePath));
             Workbook workbook = WorkbookFactory.create(fis)) {

            // Iterate through each sheet
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);
                System.out.println("Sheet Name: " + sheet.getSheetName());

                // Iterate through rows
                for (Row row : sheet) {
                    // Iterate through cells
                    for (Cell cell : row) {
                        // Print cell value
                        System.out.print(getCellValue(cell) + "\t");
                    }
                    System.out.println(); // Newline for the next row
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    // Helper method to get cell value
    private static String getCellValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";  
        }
    }
    
       

      }



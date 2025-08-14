package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class ExcelFileValidator {
	
	FileInputStream fis;
	Workbook workbook;
	Sheet sheet;
	Row row;
	Cell cell;

	String path = null;

	public ExcelFileValidator(String path) throws IOException {
		this.path = path;
	}

	public void getFileType(String searchValue) throws IOException {
		// Check file type
		if (isExcelXLS(path)) {
			System.out.println("The file is an .xls file.");

			searchStringInXLS(searchValue);

		} else if (isExcelXLSX(path)) {

			System.out.println("The file is an .xlsx file."); 
			searchStringInXLSX(searchValue);

		} else {
			System.out.println("The file is not a valid Excel file.");
		}
	}

	public static boolean isExcelXLS(String filePath) {
		return filePath.toLowerCase().endsWith(".xls");
	}
	// Method to check if the file is .xlsx
	public static boolean isExcelXLSX(String filePath) {
		return filePath.toLowerCase().endsWith(".xlsx");
	}


	public void searchStringInXLS(String searchValue) throws IOException{
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			Pattern pattern = Pattern.compile(Pattern.quote(searchValue)); // Compile the search string
			boolean found = false;

			while ((line = br.readLine()) != null) {
				Matcher matcher = pattern.matcher(line);
				if (matcher.find()) {
					System.out.println("Found '" + searchValue + "' in: " + line);
					found = true;
				}
			}

			if (!found) {
				System.out.println("String '" + searchValue + "' not found in the HTML file.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void searchStringInXLSX(String searchValue) throws IOException {
		fis = new FileInputStream(path);
		workbook = WorkbookFactory.create(fis);
		sheet = workbook.getSheetAt(0);
		System.out.println((sheet).getLastRowNum());
		fis.close();


		boolean isFound = false;

		// Iterate through rows and cells
		for (Row row : sheet) {
			for (Cell cell : row) {
				// Check if the cell value matches the search value
				if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equals(searchValue)) {
					System.out.println("Value found at row: " + row.getRowNum() + ", column: " + cell.getColumnIndex());
					isFound = true;
					break;
				}
			}
			if (isFound) break;
		}

		if (!isFound) {
			System.out.println("Value not found in the sheet.");
		}

		// Close the workbook
		workbook.close();
		fis.close();


	}	
		
}

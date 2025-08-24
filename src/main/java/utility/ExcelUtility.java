package utility;

import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ExcelUtility extends BaseClass {
	public ExcelUtility(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public ExcelUtility ReadExcel(String searchString, String finename) throws IOException {
		String path = System.getProperty("user.dir") + File.separator + "DownloadPDFs";
		File file = new File(path);
		String filepath = SearchExcelFile.searchFile(file, finename);
		//SearchStringInXML.searchStringInExcel(filepath, "Mr. MOHAMMED ABUBACKER MR");
		ExcelFileValidator excelRead = new ExcelFileValidator(filepath);
		excelRead.getFileType(searchString);
		return this;
	}



//	public static String getLastValueFromColumn(String relativePath, String columnName) {
//		 String filePath = System.getProperty("user.dir") + "/src/test/resources/" + relativePath;
//		try (InputStream fis = new FileInputStream(filePath);
//			 Workbook workbook = new XSSFWorkbook(fis)) {
//
//			Sheet sheet = workbook.getSheetAt(0);
//			Row headerRow = sheet.getRow(0);
//			if (headerRow == null) return null;
//
//			int columnIndex = -1;
//
//			// Find the index of the target column
//			for (Cell cell : headerRow) {
//				if (cell.getStringCellValue().trim().equalsIgnoreCase(columnName.trim())) {
//					columnIndex = cell.getColumnIndex();
//					break;
//				}
//			}
//
//			if (columnIndex == -1) {
//				System.out.println("Column '" + columnName + "' not found.");
//				return null;
//			}
//
//			// Iterate from the last row upwards to find the last non-empty cell in that column
//			for (int i = sheet.getLastRowNum(); i > 0; i--) {
//				Row row = sheet.getRow(i);
//				if (row == null) continue;
//
//				Cell cell = row.getCell(columnIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//				String value = getCellValueAsString(cell);
//
//				if (!value.isEmpty()) {
//					return value;
//				}
//			}
//
//			return null; // No non-empty cell found
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//	// Helper to convert cell to String
//	private static String getCellValueAsString(Cell cell) {
//		if (cell == null) return "";
//		switch (cell.getCellType()) {
//			case STRING: return cell.getStringCellValue();
//			case NUMERIC:
//				if (DateUtil.isCellDateFormatted(cell))
//					return cell.getDateCellValue().toString();
//				else
//					return String.valueOf((long) cell.getNumericCellValue());
//			case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
//			case FORMULA: return cell.getCellFormula();
//			case BLANK: return "";
//			default: return "";
//		}
//	}
//
//	private static final String FILE_NAME = "src/test/resources/Excel/NewStudents.xlsx";
//	public static void writeStudentDataToExcel(
//			String studentName, String fatherName, String mobileNumber, String alternateMobileNumber,
//			String email,String RRNOnumber) throws IOException {
//
//		File file = new File(FILE_NAME);
//		Workbook workbook;
//		Sheet sheet;
//
//		if (file.exists()) {
//			try (FileInputStream fis = new FileInputStream(file)) {
//				workbook = new XSSFWorkbook(fis);
//				sheet = workbook.getSheetAt(0);
//			}
//		} else {
//			workbook = new XSSFWorkbook();
//			sheet = workbook.createSheet("StudentData");
//			Row header = sheet.createRow(0);
//			String[] headers = {
//					"Student Name", "Father Name", "Mobile Number", "Alternate Mobile Number", "Email",
//			};
//			for (int i = 0; i < headers.length; i++) {
//				header.createCell(i).setCellValue(headers[i]);
//			}
//		}
//
//		// Append at the next empty row
//		int rowCount = sheet.getLastRowNum() + 1;
//		Row row = sheet.createRow(rowCount);
//		row.createCell(0).setCellValue(studentName);
//		row.createCell(1).setCellValue(fatherName);
//		row.createCell(2).setCellValue(mobileNumber);
//		row.createCell(3).setCellValue(alternateMobileNumber);
//		row.createCell(4).setCellValue(email);
//		row.createCell(5).setCellValue(RRNOnumber);
//		try (FileOutputStream fos = new FileOutputStream(file)) {
//			workbook.write(fos);
//		}
//		workbook.close();
//	}

}
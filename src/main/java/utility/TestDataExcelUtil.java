package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Utility class for reading and writing test data to/from Excel
 */
public class TestDataExcelUtil {
    private static final String TEST_DATA_FILE = System.getProperty("user.dir") + File.separator + "src" + File.separator
            + "test" + File.separator + "resources" + File.separator + "TestData.xlsx";

    /**
     * Writes a key-value pair to the Excel test data file
     * 
     * @param key   The key (identifier) for the data
     * @param value The value to store
     * @throws IOException If an I/O error occurs
     */
    public static void writeData(String key, String value) throws IOException {
        File file = new File(TEST_DATA_FILE);
        Workbook workbook;
        Sheet sheet;

        // Check if file exists
        if (file.exists()) {
            // File exists, open it
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet("TestData");
            if (sheet == null) {
                sheet = workbook.createSheet("TestData");
                // Create header row
                Row headerRow = sheet.createRow(0);
                Cell keyCell = headerRow.createCell(0);
                keyCell.setCellValue("Key");
                Cell valueCell = headerRow.createCell(1);
                valueCell.setCellValue("Value");
            }
            fis.close();
        } else {
            // File doesn't exist, create new workbook
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("TestData");
            // Create header row
            Row headerRow = sheet.createRow(0);
            Cell keyCell = headerRow.createCell(0);
            keyCell.setCellValue("Key");
            Cell valueCell = headerRow.createCell(1);
            valueCell.setCellValue("Value");
        }

        // Look for the key in existing rows
        boolean keyFound = false;
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Cell keyCell = row.getCell(0);
                if (keyCell != null && keyCell.getStringCellValue().equals(key)) {
                    // Key found, update value
                    Cell valueCell = row.getCell(1);
                    if (valueCell == null) {
                        valueCell = row.createCell(1);
                    }
                    valueCell.setCellValue(value);
                    keyFound = true;
                    break;
                }
            }
        }

        // If key not found, add a new row
        if (!keyFound) {
            Row newRow = sheet.createRow(sheet.getLastRowNum() + 1);
            Cell keyCell = newRow.createCell(0);
            keyCell.setCellValue(key);
            Cell valueCell = newRow.createCell(1);
            valueCell.setCellValue(value);
        }

        // Write to file
        FileOutputStream fos = new FileOutputStream(TEST_DATA_FILE);
        workbook.write(fos);
        workbook.close();
        fos.close();
        
        System.out.println("Successfully wrote " + key + " = " + value + " to Excel");
    }

    /**
     * Reads a value from the Excel test data file based on the provided key
     * 
     * @param key The key (identifier) for the data to retrieve
     * @return The value associated with the key, or null if not found
     * @throws IOException If an I/O error occurs
     */
    public static String readData(String key) throws IOException {
        File file = new File(TEST_DATA_FILE);
        if (!file.exists()) {
            System.out.println("Test data file not found: " + TEST_DATA_FILE);
            return null;
        }

        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("TestData");

        if (sheet == null) {
            workbook.close();
            fis.close();
            System.out.println("TestData sheet not found in Excel file");
            return null;
        }

        // Look for the key in rows
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Cell keyCell = row.getCell(0);
                if (keyCell != null && keyCell.getStringCellValue().equals(key)) {
                    // Key found, get value
                    Cell valueCell = row.getCell(1);
                    String value = (valueCell == null) ? null : valueCell.getStringCellValue();
                    workbook.close();
                    fis.close();
                    System.out.println("Successfully read " + key + " = " + value + " from Excel");
                    return value;
                }
            }
        }

        workbook.close();
        fis.close();
        System.out.println("Key not found in Excel: " + key);
        return null;
    }
}

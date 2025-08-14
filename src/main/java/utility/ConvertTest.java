package utility;
import java.io.IOException;

import org.testng.annotations.Test;

import utility.ConvertCSVtoExcel;



public class ConvertTest extends ConvertCSVtoExcel {
	
	ConvertCSVtoExcel test;
	 String csvFilePath = "C:\\Users\\LENOVO\\Downloads\\SessionwiseExamRegistrationCount.xls";
     String xlsxFilePath = "C:\\Users\\LENOVO\\Downloads\\SessionwiseExamRegistrationCount504.xlsx";

	@Test
	public void testmethod() 
	{
		ConvertCSVtoExcel test=new ConvertCSVtoExcel();
		test.convertCsvToExcel(csvFilePath,xlsxFilePath);   
		String str;
		str=test.readExcelToString(xlsxFilePath);
		//System.out.println(str);
		test.stringpresent(str,"ramdom"); 
		
		
	}
}

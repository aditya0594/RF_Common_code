package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {
	
	String data;
	public String getData(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		
		String path=System.getProperty("user.dir")+File.separator+"New workspace"+"NopCommerceProject"+"src"+"test"+"resources";
		FileInputStream file=new FileInputStream(path);
		Sheet s = WorkbookFactory.create(file).getSheet(sheet);
		Cell c = s.getRow(row).getCell(cell);
		CellType type = c.getCellType();
		if(type==CellType.STRING)
		{ 
			data=c.getStringCellValue();
		}
		else if(type==CellType.NUMERIC)
		{
			double number=c.getNumericCellValue();
			data=Double.toString(number);
		}
		else if(type==CellType.BLANK)
		{
			System.out.println("You Trying"); 
		}
		return data;
	}

}

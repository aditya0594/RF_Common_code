package chandigarhUniversity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import utility.BaseClass;
import utility.Reports;

public class NewStudentTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting Test: " + m.getName() + "*****" + "\n");
	} 

	@Test
	public void newStudentTest() throws Exception {
		test = reports.createTest("newStudentTest");
		Thread.sleep(2000);

		// RF_AdminLoginPage.loginPage();

		Thread.sleep(1000);
		System.out.println("Enter UserName -> admin");
		driver.findElement(By.id("txt_username")).sendKeys("admin");

		Thread.sleep(1000);
		System.out.println("Enter Password Live -> admin@123 || UAT -> Admin@12345");
		driver.findElement(By.id("txt_password")).sendKeys("M$cul@2024");

		///// captchaHandle();
		Thread.sleep(1000);
		System.out.println("Enter Master Captcha -> UAT - >RFC123 || Live -> RFC@123");
		driver.findElement(By.id("txtcaptcha")).sendKeys("RFC@1234"); // this captcha not working

		Thread.sleep(7000);
		System.out.println("Click on Login Button");
		driver.findElement(By.id("btnLogin")).click();

		Thread.sleep(2000);
		driver.get(
				"https://culuat.mastersofterp.in/academic/iitmsHE7+PocJtP77i+RKyYAFL1KA4TruUcaX86+8wKLgyGoFPI+dnwIISoVYwCdeyun53i3UObyejTovYQtfDpI26w==?enc=3Q2Y1k5BriJsFcxTY7ebQr2NsscpaMS40nFIhyqHwSo=");

		// driver.findElement(By.id("ctl00_repLinks_ctl01_lbLink")).click();
		System.out.println("Click on Search Student Button");
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSearchStu")).click();
		
		

		 
		Thread.sleep(1000);
		//driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtREGNo")).clear();
		//System.out.println("Enter ID : TEST_CULAPP0001"); 
		//driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtREGNo")).sendKeys("TEST_CULAPP0001");
		//driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtREGNo")).clear();
		
		Thread.sleep(1000);
		
//		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\Excel\\NewStudentIDs.xlsx");
//		Workbook workbook = new XSSFWorkbook(file);
//		Sheet sheet = workbook.getSheet("Sheet1");
//		Thread.sleep(1000);
//		
//		Iterator<Row> rowIterator = sheet.iterator();
//		while (rowIterator.hasNext()) 
//		{
//			Row row = rowIterator.next();
//			Iterator<Cell> cellIterator = row.iterator();
//			Thread.sleep(1000);
//			
//			while (cellIterator.hasNext()) 
//			{
//				Cell cell = cellIterator.next(); 
//				// Process the cell value
//				Thread.sleep(1000);
//				DataFormatter dataFormatter = new DataFormatter();
//				String cellValue = dataFormatter.formatCellValue(cell);
// 
//				System.out.println(cellValue);
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Excel\\NewStudentIDs.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//Read sheet inside the workbook by its name
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		//Find number of rows in excel file
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		for (int i = 1; i < rowCount+1; i++)
		{
			
			Row row = sheet.getRow(i);
			System.out.println(row.getCell(1).getStringCellValue());
			if(row.getCell(1).getStringCellValue().equals("pending"))
			{
				System.out.println(row.getCell(0).getStringCellValue());
				System.out.println("Enter Application ID");
				driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtREGNo")).click(); 
				Thread.sleep(3000); 
				driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtREGNo")).sendKeys(row.getCell(0).getStringCellValue());
				
				Thread.sleep(1000);
				System.out.println("Click on Search");
				driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSearch")).click();
				
				
//				 WebElement searchbtn = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSearch"));
//				 searchbtn.click();
//				 Alert alt = driver.switchTo().alert();
//				 
				// WebDriverWait w = new WebDriverWait(driver, 5);				 
				 
//				if(w.until(ExpectedConditions.alertIsPresent()) == null)
//				{
//					System.out.println("Alert is Present");
//					driver.switchTo().alert().accept();
//				}
//				else 
//				{
//					System.out.println("Alert is not Present");
////					driver.switchTo().alert().dismiss(); 
//				}
				
				
 
				Thread.sleep(3000);
				System.out.println("Payment Type -> Indian");
				WebElement paymentType = driver
						.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlPaymentType-container"));
				paymentType.click();
				driver.findElement(By.className("select2-search__field")).sendKeys("Please Select", Keys.ENTER);
				Thread.sleep(2000);
				driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlPaymentType-container")).click();
				Thread.sleep(2000);
				driver.findElement(By.className("select2-search__field")).sendKeys("Indian", Keys.ENTER);
				
				Thread.sleep(2000);
				WebElement submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
				
				Thread.sleep(2000);
				WebElement sendEmail = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnsendmail"));
				
				Thread.sleep(2000);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", sendEmail);

				Thread.sleep(2000);
				System.out.println("Click on Submit");
				submit.click();  
				 
				Thread.sleep(2000);
				String s1 = driver.switchTo().alert().getText();
				driver.switchTo().alert().accept();
				System.out.println("Alert Text is : " + s1);
				
				System.out.println("\n-----------testcase is passed-----------");
				//System.out.println("\n alerttext is= "+expected);
				row.getCell(1).setCellValue("done");
				FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Excel\\NewStudentIDs.xlsx");
				workbook.write(fos);
				workbook.close();
				fos.close();
				Thread.sleep(2000);
				driver.navigate().refresh();
				
				Thread.sleep(2000);
				System.out.println("Click on Search Student Button");
				driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSearchStu")).click();
				Thread.sleep(1000);

//				try {
//					submit.click();
//				} catch (Exception e) {
//					JavascriptExecutor executor = (JavascriptExecutor) driver;
//					executor.executeScript("arguments[0].click();", submit);
//				} 

				
			}
		}
 
//		workbook.close();
//		file.close();

//		Thread.sleep(1000);
//		System.out.println("Click on Search");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSearch")).click();

//		Thread.sleep(2000);
//		System.out.println("Name of the Student (as per 10th marksheet) -> ROHIT SARVASN ANJOLE");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudentfullName")).click();
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudentfullName")).clear();
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudentfullName")).sendKeys("ROHIT SARVASN ANJOLE");
//
//		Thread.sleep(2000);
//		System.out.println("Father's Name - SARVASN");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFatherName")).click();
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFatherName")).clear();
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFatherName")).sendKeys("SARVASN");
//
//		Thread.sleep(2000);
//		System.out.println("Student Mobile No. - 8149914475 -> This ID is Unique");//// 8149914475
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudMobile")).click();
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudMobile")).clear();
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudMobile")).sendKeys("0123456780"); // this is unique
//
//		Thread.sleep(2000);
//		System.out.println("Student Mobile No. 2 -> 8799943430");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudMobile2")).click();
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudMobile2")).clear();
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudMobile2")).sendKeys("8799943430");
//
//		Thread.sleep(2000);
//		System.out.println("Personal Email -> Minakshi.Giradkar@mastersoftere.com -> This ID is Unique"); //// Minakshi.Giradar@mastersofterp.com
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudEmail")).click();
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudEmail")).clear();
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtStudEmail")).sendKeys("vishal@mastersofterp.com"); // this is unique
//																															
//		Thread.sleep(2000);
//		System.out.println("State -> Maharashtra");
//		WebElement state = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlstate-container"));
//		state.click();
//		driver.findElement(By.className("select2-search__field")).sendKeys("Maharashtra", Keys.ENTER);
//
//		Thread.sleep(2000);
//		System.out.println("city -> NAGPUR");
//		WebElement city = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlCity-container"));
//		city.click();
//		driver.findElement(By.className("select2-search__field")).sendKeys("NAGPUR", Keys.ENTER);
//
//		Thread.sleep(2000);
//		System.out.println("Select Gender - Male");
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdoMale")).click();
//
//		Thread.sleep(3000);
//		System.out.println("Select Session - DEC 2018");
//		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSession-container")).click();
//		driver.findElement(By.className("select2-search__field")).sendKeys("DEC 2018", Keys.ENTER);
//
//		Thread.sleep(3000);
//		System.out.println("School/Institute - Crescent School of Architecture");
//		WebElement school = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlSchool-container"));
//		school.click();
//		driver.findElement(By.className("select2-search__field")).sendKeys("Crescent School of Architecture",
//				Keys.ENTER);
//
//		Thread.sleep(2000);
//		System.out.println("Degree - Bachelor of Architecture");
//		WebElement degree = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlDegree-container"));
//		degree.click();
//		driver.findElement(By.className("select2-search__field")).sendKeys("Bachelor of Architecture", Keys.ENTER);
//
//		Thread.sleep(2000);
//		System.out.println("Branch / Programme -> Architecture");
//		WebElement branch = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlBranch-container"));
//		branch.click();
//		driver.findElement(By.className("select2-search__field")).sendKeys("Architecture", Keys.ENTER);
//
//		Thread.sleep(2000);
//		System.out.println("Admission Type -> REGULAR");
//		WebElement AdmType = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlAdmType-container"));
//		AdmType.click();
//		driver.findElement(By.className("select2-search__field")).sendKeys("REGULAR", Keys.ENTER);
//
//		Thread.sleep(2000);
//		System.out.println("DOB - 14/06/2000");
//		driver.findElement(By.id("txtDateOfBirth1")).click();
//		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtDateOfBirth")).sendKeys("14/06/2000");
//
//		Thread.sleep(2000);
//		System.out.println("Category - OBC/BC");
//		WebElement category = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlAllotedCat-container"));
//		category.click();
//		driver.findElement(By.className("select2-search__field")).sendKeys("OBC/BC", Keys.ENTER);
//

//		Thread.sleep(3000);
//		System.out.println("Payment Type -> Indian");
//		WebElement paymentType = driver
//				.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlPaymentType-container"));
//		paymentType.click();
//		driver.findElement(By.className("select2-search__field")).sendKeys("Please Select", Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlPaymentType-container")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.className("select2-search__field")).sendKeys("Indian", Keys.ENTER);
//
//		Thread.sleep(2000);
//		System.out.println("Click on Submit");
//		WebElement submit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave"));
//
//		try {
//			submit.click();
//		} catch (Exception e) {
//			JavascriptExecutor executor = (JavascriptExecutor) driver;
//			executor.executeScript("arguments[0].click();", submit);
//		}
//
//		Thread.sleep(2000);
//		String s1 = driver.switchTo().alert().getText();
//		driver.switchTo().alert().accept();
//		System.out.println("Alert Text is : " + s1);

	}

//	@AfterMethod
//	public void getTestResult(ITestResult result) throws IOException {
//		if (result.getStatus() == ITestResult.SUCCESS) {
//			test.log(Status.PASS, result.getName());
//		} else if (result.getStatus() == ITestResult.FAILURE) {
//			test.log(Status.FAIL, result.getName());
//		} else {
//			test.log(Status.SKIP, result.getName());
//		}
//	}
//
//	@AfterTest
//	public void publishResult() {
//		reports.flush();
//	}

}

package CDCTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import CDC.AL_CDC_Reports_PlacedStudentReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.PDFUtility;
import utility.Reports;

public class AL_CDC_Reports_PlacedStudentReportTests extends BaseClass{
	ExtentReports reports;
	ExtentTest test;
	PDFUtility pdfutility;
	ExcelUtility excelutilitytest;
	HomePageAdmin HP;
	
	AL_CDC_Reports_PlacedStudentReport PlacedStudentReport;
	
	@BeforeTest
	public void configureReport() {
		reports=Reports.createReport();
	}
	
	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver=Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting : " + m.getName() + "******" + "\n");
	}
	
	@Test
	public void aL_CDC_Reports_PlacedStudentReportTests() throws Throwable 
	{
		test=reports.createTest("aL_CDC_Reports_PlacedStudentReportTests");
		HP = new HomePageAdmin(driver);
		

		excelutilitytest = new ExcelUtility(driver);

		
		RF_AdminLoginPage.loginPage();
		Thread.sleep(1000);
		
		System.out.println("CDC -> Reports -> Student Placement Report");
		
		PlacedStudentReport = new AL_CDC_Reports_PlacedStudentReport(driver);
		
		pdfutility = new PDFUtility(driver);
		
		Thread.sleep(2000);
		HP.CDC();
		Thread.sleep(2000);
		
		Thread.sleep(3000);
		PlacedStudentReport.ClickReportsTest();
		
		Thread.sleep(3000);
		PlacedStudentReport.ClickPlacedStudentReportTest();
		
		Thread.sleep(2000);
		PlacedStudentReport.ClickReportButtonTest();

		Thread.sleep(5000);
		switchToNextWindow(); 

		Thread.sleep(4000);
		pdfutility.downloadPDF(driver, "CDC - Placed Student Report");
		Thread.sleep(2000);
		pdfutility.readPDF("CDC - Placed Student Report", "AASIF SHAREEF. A");	
		
		Thread.sleep(2000);
		switchToFrameOrDefault();	
		
		Thread.sleep(2000);
		PlacedStudentReport.ClickExcelReportTest();
		
		Thread.sleep(2000);
		excelutilitytest.ReadExcel("AASIF SHAREEF. A","PLACED_STUDENT_Report"); 
	}

}

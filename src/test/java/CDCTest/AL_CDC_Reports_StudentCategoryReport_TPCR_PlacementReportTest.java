package CDCTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import CDC.AL_CDC_Reports_StudentCategoryReport_TPCR_PlacementReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.PDFUtility;
import utility.Reports;

public class AL_CDC_Reports_StudentCategoryReport_TPCR_PlacementReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin HP;
	PDFUtility pdfutility;
	ExcelUtility excelutilitytest;

	AL_CDC_Reports_StudentCategoryReport_TPCR_PlacementReport placementreport;
	
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
	public void aL_CDC_Reports_StudentCategoryReport_TPCR_PlacementReportTest() throws Throwable 
	{
		test=reports.createTest("aL_CDC_Reports_StudentCategoryReport_TPCR_PlacementReportTest");
		
		RF_AdminLoginPage.loginPage();
		Thread.sleep(1000);
		
		System.out.println("CDC -> Reports -> Student Category Report -> T&P CATEGORY REPORT -> Placement report");
		
		placementreport = new AL_CDC_Reports_StudentCategoryReport_TPCR_PlacementReport(driver);
		HP = new HomePageAdmin(driver);
		excelutilitytest = new ExcelUtility(driver);
		pdfutility = new PDFUtility(driver);
		
		Thread.sleep(2000);
		HP.CDC();
		
		Thread.sleep(2000);
		HP.CDC_Reports();
		
		Thread.sleep(2000);
		placementreport.Select_ApplicationCategoryType();
		
		Thread.sleep(2000);
		placementreport.Click_ExcelReportBtn();
		
		Thread.sleep(5000);
		excelutilitytest.ReadExcel("ABISHEK","TP_CategoryReport"); 
		
		Thread.sleep(2000);
		placementreport.Click_ReportBtn();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "CDC - Student Category Report Placement report");
		pdfutility.readPDF("CDC - Student Category Report Placement report", "ABISHEK");
	}
}

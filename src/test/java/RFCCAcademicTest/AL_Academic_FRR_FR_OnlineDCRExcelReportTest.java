package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FRR_FR_OnlineDCRExcelReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_FRR_FR_OnlineDCRExcelReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FRR_FR_OnlineDCRExcelReport onlineDCRExcelReport;
	HomePageAdmin HP;
	ExcelUtility excelutilitytest;
	
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}
	
	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n"); 
	}
		
	@Test
	public void aL_Academic_FRR_FR_OnlineDCRExcelReportTest() throws Exception {

		onlineDCRExcelReport = new AL_Academic_FRR_FR_OnlineDCRExcelReport(driver);
		excelutilitytest = new ExcelUtility(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_FRR_FR_OnlineDCRExcelReportTest"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("ACADEMICS > FRR > Fees Report > Online DCR Excel Report");

		threadWait1();
		HP.Academic();
		
		threadWait1();
		HP.Academic_FeesRelated_Reports();

		threadWait1();
		onlineDCRExcelReport.Click_FeesReport();
		
		threadWait1();
		onlineDCRExcelReport.Select_ReportType();
		
		threadWait1();
		onlineDCRExcelReport.Enter_FromDate();
		
		threadWait1();
		onlineDCRExcelReport.Enter_ToDate();
		
		threadWait1();
		onlineDCRExcelReport.Select_Degree();
		
		threadWait1();
		onlineDCRExcelReport.Click_SelectCheckbox();
		
		threadWait1();
		onlineDCRExcelReport.Click_ExcelReportButton();
		
		threadWait1();
		excelutilitytest.ReadExcel("MOHAMED","ONLINE_PAYMODE_DCR_REPORT"); 

	}
}

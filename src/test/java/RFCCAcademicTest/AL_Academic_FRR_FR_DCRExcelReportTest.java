package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FRR_FR_DCRExcelReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_FRR_FR_DCRExcelReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FRR_FR_DCRExcelReport dcrExcelReport;
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
	public void aL_Academic_FRR_FR_DCRExcelReportTest() throws Exception {

		dcrExcelReport = new AL_Academic_FRR_FR_DCRExcelReport(driver);
		excelutilitytest = new ExcelUtility(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_FRR_FR_DCRExcelReportTest"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("ACADEMICS > FRR > Fees Report > DCR Excel Report");

		threadWait1();
		HP.Academic();
		
		threadWait1();
		HP.Academic_FeesRelated_Reports();

		threadWait1();
		dcrExcelReport.Click_FeesReport();
		
		threadWait1();
		dcrExcelReport.Select_ReportType();
		
		threadWait1();
		dcrExcelReport.Enter_FromDate();
		
		threadWait1();
		dcrExcelReport.Enter_ToDate();
		
		threadWait1();
		dcrExcelReport.Select_College();
		
		threadWait1();
		dcrExcelReport.Select_Degree();
		
		threadWait1();
		dcrExcelReport.Click_SelectCheckbox();
		
		threadWait1();
		dcrExcelReport.Click_ExcelReportButton();
		
		Thread.sleep(2000);
		excelutilitytest.ReadExcel("RAHUL","DemandWiseFeesPaidStudentsList"); 

	}
}

package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FRR_FR_DailyFeeCollectionReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_FRR_FR_DailyFeeCollectionReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FRR_FR_DailyFeeCollectionReport dailyFeeCollectionReport;
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
	public void aL_Academic_FRR_FR_DailyFeeCollectionReportTest() throws Exception {

		dailyFeeCollectionReport = new AL_Academic_FRR_FR_DailyFeeCollectionReport(driver);
		excelutilitytest = new ExcelUtility(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_FRR_FR_DailyFeeCollectionReportTest"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("ACADEMICS > FRR > Fees Report > Daily Fee Collection Report");

		threadWait1();
		HP.Academic();
		
		threadWait1();
		HP.Academic_FeesRelated_Reports();

		threadWait1();
		dailyFeeCollectionReport.Click_FeesReport();
		
		threadWait1();
		dailyFeeCollectionReport.Select_ReportType();
		
		threadWait1();
		dailyFeeCollectionReport.Enter_FromDate();
		
		threadWait1();
		dailyFeeCollectionReport.Enter_ToDate();
		
		threadWait1();
		dailyFeeCollectionReport.Select_College();
		
		threadWait1();
		dailyFeeCollectionReport.Select_Degree();
		
		threadWait1();
		dailyFeeCollectionReport.Click_ReceiptTypeCheckbox();
		
		threadWait1();
		dailyFeeCollectionReport.Click_ReportButton();
		
		threadWait1();
		excelutilitytest.ReadExcel("Admission Fee","Daily_Fee_Collection_Report"); 

	}
}

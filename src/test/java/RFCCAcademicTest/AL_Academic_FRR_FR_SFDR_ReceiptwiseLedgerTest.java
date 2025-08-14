package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FRR_FR_SFDR_ReceiptwiseLedger;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_FRR_FR_SFDR_ReceiptwiseLedgerTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FRR_FR_SFDR_ReceiptwiseLedger receiptwiseLedgerReport;
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
	public void aL_Academic_FRR_FR_SFDR_ReceiptwiseLedgerTest() throws Exception {

		receiptwiseLedgerReport = new AL_Academic_FRR_FR_SFDR_ReceiptwiseLedger(driver);
		excelutilitytest = new ExcelUtility(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_FRR_FR_SFDR_ReceiptwiseLedgerTest"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("ACADEMICS > FRR > Fees Report > Selected Field DCR Report > Receipt wise Ledger");

		threadWait1();
		HP.Academic();
		
		threadWait1();
		HP.Academic_FeesRelated_Reports();

		threadWait1();
		receiptwiseLedgerReport.Click_FeesReport();
		
		threadWait1();
		receiptwiseLedgerReport.Click_SelectedFieldDCRReport();
		
		threadWait1();
		receiptwiseLedgerReport.Select_ReportType();
		
		threadWait1();
		receiptwiseLedgerReport.Select_ReceiptType();
		
		threadWait1();
		receiptwiseLedgerReport.Click_MultiSelectField();
		
		threadWait1();
		receiptwiseLedgerReport.Click_SelectAllCheckbox();
		
		threadWait1();
		receiptwiseLedgerReport.Enter_FromDate();
		
		threadWait1();
		receiptwiseLedgerReport.Enter_ToDate();
		
		threadWait1();
		receiptwiseLedgerReport.Click_ShowButton();
		
		threadWait1();
		receiptwiseLedgerReport.VerifyText();
		
		captureScreenshot(driver, "Fees Report - Receipt wise Ledger");
	}
}

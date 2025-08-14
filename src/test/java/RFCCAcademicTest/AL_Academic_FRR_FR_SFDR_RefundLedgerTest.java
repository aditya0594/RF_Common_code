package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FRR_FR_SFDR_RefundLedger;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;

public class AL_Academic_FRR_FR_SFDR_RefundLedgerTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FRR_FR_SFDR_RefundLedger refundLedgerReport;
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
	public void aL_Academic_FRR_FR_SFDR_RefundLedgerTest() throws Exception {

		refundLedgerReport = new AL_Academic_FRR_FR_SFDR_RefundLedger(driver);
		excelutilitytest = new ExcelUtility(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_FRR_FR_SFDR_RefundLedgerTest"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("ACADEMICS > FRR > Fees Report > Selected Field DCR Report > Refund Ledger");

		threadWait1();
		HP.Academic();
		
		threadWait1();
		HP.Academic_FeesRelated_Reports();

		threadWait1();
		refundLedgerReport.Click_FeesReport();
		
		threadWait1();
		refundLedgerReport.Click_SelectedFieldDCRReport();
		
		threadWait1();
		refundLedgerReport.Select_ReportType();
		
		threadWait1();
		refundLedgerReport.Select_ReceiptType();
		
		threadWait1();
		refundLedgerReport.Click_MultiSelectField();
		
		threadWait1();
		refundLedgerReport.Click_SelectAllCheckbox();
		
		threadWait1();
		refundLedgerReport.Enter_FromDate();
		
		threadWait1();
		refundLedgerReport.Enter_ToDate();
		
		threadWait1();
		refundLedgerReport.Click_ShowButton();
		
		threadWait1();
		refundLedgerReport.Verify_Student();
		
		captureScreenshot(driver, "Fee Report - Refund Leadger Report");
		
	}
}

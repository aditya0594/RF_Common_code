package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FRR_FR_FeeCollectionSummaryReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.PDFUtility;
import utility.Reports;

public class AL_Academic_FRR_FR_FeeCollectionSummaryReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FRR_FR_FeeCollectionSummaryReport feeCollectionSummaryReport;
	HomePageAdmin HP;
	PDFUtility pdfutility;
	
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
	public void aL_Academic_FRR_FR_FeeCollectionSummaryReportTest() throws Exception {

		feeCollectionSummaryReport = new AL_Academic_FRR_FR_FeeCollectionSummaryReport(driver);
		pdfutility =new PDFUtility(driver);	
			
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_FRR_FR_FeeCollectionSummaryReportTest"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("ACADEMICS > FRR > Fees Report > Fee Collection Summary Report");

		threadWait1();
		HP.Academic();
		
		threadWait1();
		HP.Academic_FeesRelated_Reports();

		threadWait1();
		feeCollectionSummaryReport.Click_FeesReport();
		
		threadWait1();
		feeCollectionSummaryReport.Select_ReportType();
		
		threadWait1();
		feeCollectionSummaryReport.Enter_FromDate();
		
		threadWait1();
		feeCollectionSummaryReport.Enter_ToDate();
		
		threadWait1();
		feeCollectionSummaryReport.Select_Degree();
		
		threadWait1();
		feeCollectionSummaryReport.Click_ReceiptTypeCheckbox();
		
		threadWait1();
		feeCollectionSummaryReport.Click_ReportButton();
		
		threadWait1();
		pdfutility.downloadPDF(driver, "Academic - Fee Collection Summary Report");
		Thread.sleep(2000);
		pdfutility.readPDF("Academic - Fee Collection Summary Report", "Admission");

	}
}

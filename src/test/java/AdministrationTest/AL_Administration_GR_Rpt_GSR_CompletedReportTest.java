package AdministrationTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Administration.AL_Administration_GR_Rpt_GSR_CompletedReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Administration_GR_Rpt_GSR_CompletedReportTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	HomePageAdmin homePageAdmin;
	PDFUtility pdfutility;

	AL_Administration_GR_Rpt_GSR_CompletedReport aL_Administration_GA_GSR_CompletedReport;

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
	public void aL_Administration_GA_GSR_CompletedReportTest() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);

		aL_Administration_GA_GSR_CompletedReport = new AL_Administration_GR_Rpt_GSR_CompletedReport(driver);

		pdfutility = new PDFUtility(driver);

		test = reports.createTest("AL_Administration_GA_GSR_CompletedReportTest");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		
		System.out.println("Administration-GrievanceRedressal-Reports - Grievance Status Report - Completed Report");

		Thread.sleep(2000);
		homePageAdmin.ADMINISTRATION();

		Thread.sleep(2000);
		homePageAdmin.GrievanceRedressal();

		Thread.sleep(2000);
		homePageAdmin.Admin_GR_Reports();

		Thread.sleep(2000);
		aL_Administration_GA_GSR_CompletedReport.Select_FromDate();

		Thread.sleep(2000);
		aL_Administration_GA_GSR_CompletedReport.Select_EndDate();

		Thread.sleep(2000);
		aL_Administration_GA_GSR_CompletedReport.Select_GrievanceDropdown();

		Thread.sleep(2000);
		aL_Administration_GA_GSR_CompletedReport.ClickOn_Reports();

		Thread.sleep(5000);
		pdfutility.downloadPDF(driver,
				"Administration-GrievanceRedressal-Reports - Grievance Status Report - Completed Report");

		Thread.sleep(5000);
		pdfutility.readPDF("Administration-GrievanceRedressal-Reports - Grievance Status Report - Completed Report",
				"ARAVINDKUMAR");

	}

}
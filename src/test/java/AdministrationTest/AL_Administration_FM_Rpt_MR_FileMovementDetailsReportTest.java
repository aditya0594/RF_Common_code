package AdministrationTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Administration.AL_Administration_FM_Rpt_MR_FileMovementDetailsReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Administration_FM_Rpt_MR_FileMovementDetailsReportTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	HomePageAdmin homePageAdmin;
	PDFUtility pdfutility;

	AL_Administration_FM_Rpt_MR_FileMovementDetailsReport aL_Administration_FM_Rpt_MR_FileMovementDetailsReport;

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
	public void aL_Administration_FM_Rpt_MR_FileMovementDetailsReportTest() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);

		aL_Administration_FM_Rpt_MR_FileMovementDetailsReport = new AL_Administration_FM_Rpt_MR_FileMovementDetailsReport(
				driver);

		pdfutility = new PDFUtility(driver);

		test = reports.createTest("AL_Administration_FM_Rpt_MR_FileMovementDetailsReportTest");

		threadWait1();
		RF_AdminLoginPage.loginPage();

		System.out
				.println("Administration->File Movement-> Reports ->Movement Report --> File Movement Details Report ");

		threadWait1();
		homePageAdmin.ADMINISTRATION();

		threadWait1();
		homePageAdmin.FileMovement();

		threadWait1();
		homePageAdmin.Admin_FM_Reports();

		threadWait1();
		aL_Administration_FM_Rpt_MR_FileMovementDetailsReport.ClickOn_MovementReports();

		threadWait1();
		aL_Administration_FM_Rpt_MR_FileMovementDetailsReport.Select_ReportStatusDropdown();

		Thread.sleep(6000);
		aL_Administration_FM_Rpt_MR_FileMovementDetailsReport.ClickOn_DetailsBtn();
		new ProcessBuilder("AutoIT/PrintPDF.exe").start();
		Thread.sleep(15000);
		Thread.sleep(6000);
		pdfutility.downloadPDF(driver,
				"Administration-File Movement-Master -Movement Report - File Movement Details Report");

		Thread.sleep(6000);
		pdfutility.readPDF("Administration-File Movement-Master -Movement Report - File Movement Details Report",
				"SAIBULLA");

	}

}

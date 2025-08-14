package AdministrationTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Administration.AL_Administration_GR_Rpt_GrievanceSummary;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Administration_GR_Rpt_GrievanceSummaryTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;

	HomePageAdmin homePageAdmin;
	PDFUtility pdfutility;

	AL_Administration_GR_Rpt_GrievanceSummary aL_Administration_GR_R_GrievanceSummary;

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
	public void aL_Administration_GR_R_GrievanceSummaryTest() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);

		aL_Administration_GR_R_GrievanceSummary = new AL_Administration_GR_Rpt_GrievanceSummary(driver);

		pdfutility = new PDFUtility(driver);

		test = reports.createTest("AL_Administration_GR_R_GrievanceSummaryTest");

		threadWait1();
		RF_AdminLoginPage.loginPage();

		System.out.println("Administration->GrievanceRedressal->Reports -> GrievanceSummary");

		threadWait1();
		homePageAdmin.ADMINISTRATION();

		threadWait1();
		homePageAdmin.GrievanceRedressal();

		threadWait1();
		homePageAdmin.Admin_GR_Reports();

		threadWait1();
		aL_Administration_GR_R_GrievanceSummary.ClickOn_GrievanceSummary();

		threadWait1();
		aL_Administration_GR_R_GrievanceSummary.Select_FromDate();

		threadWait1();
		aL_Administration_GR_R_GrievanceSummary.Select_ToDate();

		threadWait1();
		aL_Administration_GR_R_GrievanceSummary.Select_GrievanceType();

		Thread.sleep(2000);
		aL_Administration_GR_R_GrievanceSummary.Select_Department();

		threadWait1();
		aL_Administration_GR_R_GrievanceSummary.ClickOn_ShowButton();

		threadWait1();
		aL_Administration_GR_R_GrievanceSummary.ClickOn_PrintButton(); // PRADEEP

		threadWait3();
		pdfutility.downloadPDF(driver, "Administration-GrievanceRedressal-Reports - GrievanceSummary");

		threadWait3();
		pdfutility.readPDF("Administration-GrievanceRedressal-Reports - GrievanceSummary", "PRADEEP");

	}

}

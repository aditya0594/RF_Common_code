package AdministrationTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;


import Administration.AL_Administration_FM_Rpt_SR_AttendanceListReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Administration_FM_Rpt_SR_AttendanceListReportTest extends BaseClass  {
	
	
	ExtentReports reports;
	ExtentTest test;

	HomePageAdmin homePageAdmin;
	PDFUtility pdfutility;

	AL_Administration_FM_Rpt_SR_AttendanceListReport aL_Administration_FM_Rpt_SR_AttendanceListReport;

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
	public void aL_Administration_FM_Rpt_SR_AttendanceListReportTest() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);

		aL_Administration_FM_Rpt_SR_AttendanceListReport = new AL_Administration_FM_Rpt_SR_AttendanceListReport(driver);

		pdfutility = new PDFUtility(driver);

		test = reports.createTest("AL_Administration_FM_Rpt_SR_AttendanceListReportTest");

		threadWait1();
		RF_AdminLoginPage.loginPage();

		System.out.println("Administration->File Movement-> Reports -> Status Report --> Attendance List ");

		threadWait1();
		homePageAdmin.ADMINISTRATION();
		
		threadWait1();
		homePageAdmin.FileMovement();

		threadWait1();
		homePageAdmin.Admin_FM_Reports();
		
		threadWait1();
		aL_Administration_FM_Rpt_SR_AttendanceListReport.ClickOn_StatusReports();
		
		threadWait1();
		aL_Administration_FM_Rpt_SR_AttendanceListReport.Select_SelectFilesDropdown();
		
		threadWait1();
		aL_Administration_FM_Rpt_SR_AttendanceListReport.ClickOn_ShowReport();
		
		
		threadWait1();
		pdfutility.downloadPDF(driver,"Administration-File Movement-Reports -Status Report - Attendance List");

		threadWait1();
		pdfutility.readPDF("Administration-File Movement-Reports -Status Report - Attendance List",
				"SATHICKBASHA");

	}
		
		
		
	}	



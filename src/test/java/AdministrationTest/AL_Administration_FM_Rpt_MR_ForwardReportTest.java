package AdministrationTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;


import Administration.AL_Administration_FM_Rpt_MR_ForwardReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Administration_FM_Rpt_MR_ForwardReportTest extends BaseClass {
	
	ExtentReports reports;
	ExtentTest test;

	HomePageAdmin homePageAdmin;
	PDFUtility pdfutility;

	AL_Administration_FM_Rpt_MR_ForwardReport aL_Administration_FM_Rpt_MR_ForwardReport;

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
	public void aL_Administration_FM_Rpt_MR_ForwardReportTest() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);

		aL_Administration_FM_Rpt_MR_ForwardReport = new AL_Administration_FM_Rpt_MR_ForwardReport(driver);

		pdfutility = new PDFUtility(driver);

		test = reports.createTest("AL_Administration_FM_Rpt_MR_ForwardReportTest");

		threadWait1();
		RF_AdminLoginPage.loginPage();

		System.out.println("Administration->File Movement-> Reports ->Movement Report --> Forward Report Report ");

		threadWait1();
		homePageAdmin.ADMINISTRATION();
		
		threadWait1();
		homePageAdmin.FileMovement();

		threadWait1();
		homePageAdmin.Admin_FM_Reports();
		
		
		threadWait1();
		aL_Administration_FM_Rpt_MR_ForwardReport.ClickOn_MovementReports();
		
		
		threadWait1();
		aL_Administration_FM_Rpt_MR_ForwardReport.Select_ReportStatusDropdown();
		
		
		threadWait1();
		aL_Administration_FM_Rpt_MR_ForwardReport.Select_SectionDropdown();
		
		threadWait1();
		aL_Administration_FM_Rpt_MR_ForwardReport.Select_FromDate();
		
		threadWait1();
		aL_Administration_FM_Rpt_MR_ForwardReport.Select_ToDate();
		
		threadWait1();
		aL_Administration_FM_Rpt_MR_ForwardReport.ClickOn_ShowReport();
		
		threadWait1();
		pdfutility.downloadPDF(driver,
				"Administration-File Movement-Master -Movement Report -  Forward Report ");

		threadWait1();
		pdfutility.readPDF("Administration-File Movement-Master -Movement Report -  Forward Report ",
				"SATHICKBASHA");

	}
		

}

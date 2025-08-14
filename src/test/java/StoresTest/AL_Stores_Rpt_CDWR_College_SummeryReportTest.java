package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Rpt_CDWR_College_SummeryReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Stores_Rpt_CDWR_College_SummeryReportTest extends BaseClass {

	// AL_Stores_Rpt_CDWR_MainStore_SummaryReportTest
	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_CDWR_College_SummeryReport aL_Stores_Rpt_ClgOrDeptWiseItemReportClgSummeryReport;
	HomePageAdmin homePageAdmin;
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

	public void aL_Stores_Rpt_CDWR_College_SummeryReportTest() throws Exception {
		homePageAdmin = new HomePageAdmin(driver);
		aL_Stores_Rpt_ClgOrDeptWiseItemReportClgSummeryReport = new AL_Stores_Rpt_CDWR_College_SummeryReport(driver);

		pdfutility = new PDFUtility(driver);

		test = reports.createTest("Stores->Reports->College Or Department Wise Item Report->Summary report");
		
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Stores->Reports->College Or Department Wise Item Report->Summary report");

		Thread.sleep(2000);
		homePageAdmin.STORE();

		Thread.sleep(2000);
		homePageAdmin.Select_StoreReports();

		Thread.sleep(2000);
		aL_Stores_Rpt_ClgOrDeptWiseItemReportClgSummeryReport.ClickOn_ClgOrDeptWiseItemReport1();

		Thread.sleep(2000);
		aL_Stores_Rpt_ClgOrDeptWiseItemReportClgSummeryReport.ClickOn_ClgOrDeptWiseItemReportCollege();

		Thread.sleep(2000);
		aL_Stores_Rpt_ClgOrDeptWiseItemReportClgSummeryReport.Select_ClgDropdown();

		Thread.sleep(2000);
		aL_Stores_Rpt_ClgOrDeptWiseItemReportClgSummeryReport.ClickOn_ClgOrDeptWiseItemReportSummmery();
		

		Thread.sleep(5000);
		switchToNextWindow();


		Thread.sleep(3000);
		pdfutility.downloadPDF(driver, "Store - College Or Department Wise Item Report - Summery Report");
		Thread.sleep(3000);
		pdfutility.readPDF("Store - College Or Department Wise Item Report - Summery Report", "ALMIRAH");

		// Item Name

	}

}

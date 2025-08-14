package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Rpt_CDWR_College_DetailedReport;
import Stores.AL_Stores_Rpt_CDWR_College_SummeryReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Stores_Rpt_CDWR_College_DetailedReportTest extends BaseClass {
	// AL_Stores_Rpt_CDWR_MainStore_SummaryReportTest
	// AL_Stores_Rpt_CDWR_MainStore_SummaryReport

	ExtentReports reports;
	ExtentTest test;

	HomePageAdmin homePageAdmin;
	PDFUtility pdfutility;
	AL_Stores_Rpt_CDWR_College_DetailedReport aL_Stores_Rpt_ClgOrDeptWiseItemReportClgDetailedReport;

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

	public void aL_Stores_Rpt_CDWR_College_DetailedReportTest() throws Exception {
		homePageAdmin = new HomePageAdmin(driver);

		aL_Stores_Rpt_ClgOrDeptWiseItemReportClgDetailedReport = new AL_Stores_Rpt_CDWR_College_DetailedReport(driver);
		pdfutility = new PDFUtility(driver);

		test = reports.createTest("AL_Stores_Rpt_CDWR_College_DetailedReportTest");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Stores->Reports->College Or Department Wise Item Report - Detail Report");

		Thread.sleep(2000);
		homePageAdmin.STORE();

		Thread.sleep(2000);
		homePageAdmin.Select_StoreReports();

		Thread.sleep(2000);
		aL_Stores_Rpt_ClgOrDeptWiseItemReportClgDetailedReport.ClickOn_ClgOrDeptWiseItemReport1();

		Thread.sleep(2000);
		aL_Stores_Rpt_ClgOrDeptWiseItemReportClgDetailedReport.ClickOn_ClgOrDeptWiseItemReportCollege();

		Thread.sleep(2000);
		aL_Stores_Rpt_ClgOrDeptWiseItemReportClgDetailedReport.Select_ClgDropdown();

		Thread.sleep(2000);
		aL_Stores_Rpt_ClgOrDeptWiseItemReportClgDetailedReport.ClickOn_ClgOrDeptWiseItemReportDetailed();
		
		Thread.sleep(5000);
		switchToNextWindow();

		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Store - College Or Department Wise Item Report - Detail Report");
		Thread.sleep(5000);
		pdfutility.readPDF("Store - College Or Department Wise Item Report - Detail Report","CRESCENT");

		// Item Name

	}

}

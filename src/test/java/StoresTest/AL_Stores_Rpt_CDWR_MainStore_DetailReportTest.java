package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

//import Stores.AL_Stores_Rpt_ClgOrDeptWiseItemReport;
import Stores.AL_Stores_Rpt_CDWR_MainStore_SummaryReport;
//import Stores.AL_Stores_Rpt_FAR_Detailed;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Stores_Rpt_CDWR_MainStore_DetailReportTest extends BaseClass {
	// AL_Stores_Rpt_CDWR_MainStore_DetailReportTest

	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_CDWR_MainStore_SummaryReport aL_Stores_Rpt_ClgOrDeptWiseItemReportMainStoreSummeryReport;
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
	public void aL_Stores_Rpt_CDWR_MainStore_DetailReportTest() throws Exception {
		homePageAdmin = new HomePageAdmin(driver);

		aL_Stores_Rpt_ClgOrDeptWiseItemReportMainStoreSummeryReport = new AL_Stores_Rpt_CDWR_MainStore_SummaryReport(
				driver);

		pdfutility = new PDFUtility(driver);

		test = reports.createTest("AL_Stores_Rpt_FAR_Detailed");

		Thread.sleep(2000);

		RF_AdminLoginPage.loginPage();
		System.out.println("Stores->Reports->College Or Department Wise Item Report");

		Thread.sleep(2000);
		homePageAdmin.STORE();

		Thread.sleep(2000);
		homePageAdmin.Select_StoreReports();

		Thread.sleep(4000);
		aL_Stores_Rpt_ClgOrDeptWiseItemReportMainStoreSummeryReport.ClickOn_ClgOrDeptWiseItemReport1();

		/*
		 * Thread.sleep(4000);
		 * aL_Stores_Rpt_ClgOrDeptWiseItemReportMainStoreSummeryReport.Select_FromDate()
		 * ;
		 * 
		 * Thread.sleep(4000);
		 * aL_Stores_Rpt_ClgOrDeptWiseItemReportMainStoreSummeryReport.Select_ToDate();
		 */

		Thread.sleep(4000);
		
		aL_Stores_Rpt_ClgOrDeptWiseItemReportMainStoreSummeryReport.ClickOn_ClgOrDeptWiseItemReportSummery();

		Thread.sleep(5000);
		switchToNextWindow();


		Thread.sleep(3000);
		pdfutility.downloadPDF(driver, "Store - C"
				+ "ollege Or Department Wise Item Report Main Store Summery Report");
		Thread.sleep(3000);
		pdfutility.readPDF("Store - College Or Department Wise Item Report Main Store Summery Report", "BLACK"); 

	}
}

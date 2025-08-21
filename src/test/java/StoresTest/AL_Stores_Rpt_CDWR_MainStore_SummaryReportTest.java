package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Rpt_CDWR_MainStore_DetailReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Stores_Rpt_CDWR_MainStore_SummaryReportTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_CDWR_MainStore_DetailReport aL_Stores_Rpt_ClgOrDeptWiseItemReportClgMainStoreDetailed;
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
	public void aL_Stores_Rpt_CDWR_MainStore_SummaryReportTest() throws Exception {
		homePageAdmin = new HomePageAdmin(driver);

		aL_Stores_Rpt_ClgOrDeptWiseItemReportClgMainStoreDetailed = new AL_Stores_Rpt_CDWR_MainStore_DetailReport(
				driver);

		pdfutility = new PDFUtility(driver);

		test = reports.createTest("AL_Stores_Rpt_FAR_Detailed");
		RF_AdminLoginPage.loginPage();
		System.out.println("Stores->Reports->College Or Department Wise Item Report");

		homePageAdmin.STORE();
		Thread.sleep(2000);
		homePageAdmin.Select_StoreReports();
		aL_Stores_Rpt_ClgOrDeptWiseItemReportClgMainStoreDetailed.ClickOn_ClgOrDeptWiseItemReport1();
		/*
		 * Thread.sleep(4000);
		 * aL_Stores_Rpt_ClgOrDeptWiseItemReportClgMainStoreDetailed.Select_FromDate();
		 * 
		 * Thread.sleep(4000);
		 * aL_Stores_Rpt_ClgOrDeptWiseItemReportClgMainStoreDetailed.Select_ToDate();
		 */

		aL_Stores_Rpt_ClgOrDeptWiseItemReportClgMainStoreDetailed.ClickOn_ClgOrDeptWiseItemReportDetailed();
		Thread.sleep(1000);
		switchToNextWindow();
		Thread.sleep(1000);
		pdfutility.downloadPDF(driver, "Store - College Or Department Wise Item Report Deatiled Report");
		Thread.sleep(5000);
		pdfutility.readPDF("Store - College Or Department Wise Item Report Deatiled Report", "Item Serial Number");

	}

}


package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Rpt_FAR_Summery;
//import Stores.AL_Stores_Rpt_StockEntryReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Stores_Rpt_FAR_SummeryTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_FAR_Summery aL_Stores_Rpt_FAR_Summery;
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
	public void aL_Stores_Rpt_FAR_SummeryTest() throws Exception {
		homePageAdmin = new HomePageAdmin(driver);
		aL_Stores_Rpt_FAR_Summery = new AL_Stores_Rpt_FAR_Summery(driver);
		pdfutility = new PDFUtility(driver);

		test = reports.createTest("AL_Stores_Rpt_FAR_Summery");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Stores->Reports->Fixed Asset Report-> SummeryTest");

		Thread.sleep(2000);
		homePageAdmin.STORE();

		Thread.sleep(2000);
		homePageAdmin.Select_StoreReports();

		Thread.sleep(4000);
		aL_Stores_Rpt_FAR_Summery.Select_FixedReportTypeSummery();

		/*
		 * Thread.sleep(4000); aL_Stores_Rpt_FAR_Summery.Select_SubCategory();
		 * 
		 * Thread.sleep(4000); aL_Stores_Rpt_FAR_Summery.Select_SelectItem();
		 * 
		 * Thread.sleep(4000); aL_Stores_Rpt_FAR_Summery.Select_FromDate();
		 * 
		 * Thread.sleep(4000); aL_Stores_Rpt_FAR_Summery.Select_ToDate();
		 */

		Thread.sleep(4000);
		aL_Stores_Rpt_FAR_Summery.Click_ShowBtn();

		Thread.sleep(5000);
		switchToNextWindow();

		Thread.sleep(3000);
		pdfutility.downloadPDF(driver, "Stores - Reports - Fixed Asset Report - Summery Report");
		Thread.sleep(3000);
		pdfutility.readPDF("Stores - Reports - Fixed Asset Report - Summery Report", "FAN");

	}
}

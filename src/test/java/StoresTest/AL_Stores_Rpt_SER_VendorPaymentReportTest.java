package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Rpt_SER_VendorPaymentReport;
//import Stores.AL_Stores_Rpt_StockEntryReportss;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Stores_Rpt_SER_VendorPaymentReportTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_SER_VendorPaymentReport aL_Stores_Rpt_SER_VendorPaymentReport;
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
	public void aL_Stores_Rpt_SER_VendorPaymentReportTest() throws Exception {
		homePageAdmin = new HomePageAdmin(driver);
		aL_Stores_Rpt_SER_VendorPaymentReport = new AL_Stores_Rpt_SER_VendorPaymentReport(driver);
		pdfutility = new PDFUtility(driver);

		test = reports.createTest("aL_Stores_Rpt_SER_VendorPaymentReportTest");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Stores->Reports->Stock Entry Report->Vendor Payment Report");

		Thread.sleep(2000);
		homePageAdmin.STORE();

		Thread.sleep(2000);
		homePageAdmin.Select_StoreReports();

		Thread.sleep(4000);
		aL_Stores_Rpt_SER_VendorPaymentReport.Select_ReportType();

		Thread.sleep(4000);
		aL_Stores_Rpt_SER_VendorPaymentReport.Select_StoreName();

		Thread.sleep(4000);
		aL_Stores_Rpt_SER_VendorPaymentReport.Click_ShowBtn();

		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Store - Stock Entry Report - Vendor Payment Report");
		Thread.sleep(5000);
		pdfutility.readPDF("Store - Stock Entry Report - Vendor Payment Report", "AGRO");

	}

}

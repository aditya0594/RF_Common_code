package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Rpt_IIR_RequisitionWiseReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Stores_Rpt_IIR_RequisitionWiseReportTests extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_IIR_RequisitionWiseReport aL_Stores_Rpt_IIR_RequisitionWiseReport;
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
	public void aL_Stores_Rpt_IIR_RequisitionWiseReportTests() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);

		aL_Stores_Rpt_IIR_RequisitionWiseReport = new AL_Stores_Rpt_IIR_RequisitionWiseReport(driver);

		pdfutility = new PDFUtility(driver);

		test = reports.createTest("aL_Stores_Rpt_IIR_RequisitionWiseReportTests");
		
		

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();

		System.out.println("Stores->Reports->Issue Item Report-> Requisition Wise Report");

		Thread.sleep(2000);
		homePageAdmin.STORE();

		Thread.sleep(2000);
		homePageAdmin.Select_StoreReports();

		aL_Stores_Rpt_IIR_RequisitionWiseReport.Select_IssueItemReport();

		aL_Stores_Rpt_IIR_RequisitionWiseReport.Select_RequisitionWiseReport();

		aL_Stores_Rpt_IIR_RequisitionWiseReport.Select_RequisitionNo();

		Thread.sleep(2000);
		aL_Stores_Rpt_IIR_RequisitionWiseReport.Select_Show();

		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Store - Issue Item Report - Requisition Wise Report");
		Thread.sleep(5000);
		pdfutility.readPDF("Store - Issue Item Report - Requisition Wise Report", "TABLE");

	}

}

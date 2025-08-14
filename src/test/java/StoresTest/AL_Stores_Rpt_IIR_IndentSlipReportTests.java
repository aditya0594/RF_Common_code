package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Rpt_IIR_IndentSlipReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Stores_Rpt_IIR_IndentSlipReportTests extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_IIR_IndentSlipReport aL_Stores_Rpt_IIR_IndentSlipReport;
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
	public void aL_Stores_Rpt_IIR_IndentSlipReportTests() throws Exception {
		
		

		homePageAdmin = new HomePageAdmin(driver);

		aL_Stores_Rpt_IIR_IndentSlipReport = new AL_Stores_Rpt_IIR_IndentSlipReport(driver);

		pdfutility = new PDFUtility(driver);

		test = reports.createTest("aL_Stores_Rpt_IIR_IndentSlipReportTests");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();

		System.out.println("Stores->Reports-> Issue Item Report-> Indent Slip Report");

		Thread.sleep(2000);
		homePageAdmin.STORE();

		Thread.sleep(2000);
		homePageAdmin.Select_StoreReports();

		aL_Stores_Rpt_IIR_IndentSlipReport.Select_IssueItemReport();

		aL_Stores_Rpt_IIR_IndentSlipReport.Select_IndentSlipReport();

		Thread.sleep(2000);
		aL_Stores_Rpt_IIR_IndentSlipReport.Select_ShowReport();

		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Store - Issue Item Report - Indent Slip Report");
		Thread.sleep(5000);
		pdfutility.readPDF("Store - Issue Item Report - Indent Slip Report", "ALMIRAH");

	}

}

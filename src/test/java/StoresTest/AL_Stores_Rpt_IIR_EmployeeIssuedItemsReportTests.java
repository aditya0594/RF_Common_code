package StoresTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Stores.AL_Stores_Rpt_IIR_EmployeeIssuedItemsReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Stores_Rpt_IIR_EmployeeIssuedItemsReportTests extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Stores_Rpt_IIR_EmployeeIssuedItemsReport aL_Stores_Rpt_IIR_EmployeeIssuedItemsReport;
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
	public void aL_Stores_Rpt_IIR_EmployeeIssuedItemsReportTests() throws Exception {

		homePageAdmin = new HomePageAdmin(driver);

		aL_Stores_Rpt_IIR_EmployeeIssuedItemsReport = new AL_Stores_Rpt_IIR_EmployeeIssuedItemsReport(driver);

		pdfutility = new PDFUtility(driver);

		test = reports.createTest("AL_Stores_Rpt_FAR_Detailed");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();

		System.out.println("Stores->Reports->Issued Item Report-> Employee Issued Item Report");

		Thread.sleep(2000);
		homePageAdmin.STORE();

		Thread.sleep(2000);
		homePageAdmin.Select_StoreReports();
		
		threadWait1();
		aL_Stores_Rpt_IIR_EmployeeIssuedItemsReport.Select_IssueItemReport();
		threadWait1();
		aL_Stores_Rpt_IIR_EmployeeIssuedItemsReport.Select_EmployeeIssuedItemsReport();
		threadWait1();
		aL_Stores_Rpt_IIR_EmployeeIssuedItemsReport.Select_Department();
		threadWait1();
		aL_Stores_Rpt_IIR_EmployeeIssuedItemsReport.Select_EmployeeName();
		threadWait1();
		
		
		captureScreenshot(driver, "Employee Issued Item Report");
	}

}

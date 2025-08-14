package PayrollTest;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Rpt_DetailReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.PDFUtility;

public class AL_Payroll_Rpt_DetailReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Rpt_DetailReport det_repo;
	HomePageAdmin HP;
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
	public void aL_Payroll_Rpt_DetailReportTest() throws InterruptedException, IOException, AWTException {
		
	System.out.println("Payroll==> Reports==> Detail Report");
		
		det_repo = new AL_Payroll_Rpt_DetailReport(driver);
		HP = new HomePageAdmin(driver);
		pdfutility = new PDFUtility(driver);
		test = reports.createTest("aL_Payroll_Rpt_DetailReportTest");
		
		RF_AdminLoginPage.loginPage();
		HP.PAYROLL();
		Thread.sleep(3000);;
		HP.PAYROLL_Report();
		
		Thread.sleep(5000);
		det_repo.DetailReport(); 
		
		Thread.sleep(5000);
		det_repo.Select_FromDate();
		
		Thread.sleep(5000);
		det_repo.Select_ToDate(); 
		
		Thread.sleep(5000);;
		det_repo.select_SchemeStafff_Type();
		
		Thread.sleep(5000);;
		det_repo.Click_ShowReport_btn();
		
		Thread.sleep(5000);
		switchToNextWindow();

		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Payroll - Detail Report");
		pdfutility.readPDF("Payroll - Detail Report", "KARTHIKEYAN");	
		

	//	captureScreenshot(driver, "Detail Report");

	}
	
}

package RFCCAcademicTest;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FRR_RefunReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Academic_FRR_RefunReportTest extends BaseClass{
	
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FRR_RefunReport RefunReport;
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
	public void aL_Academic_FRR_RefunReportTest() throws Exception {

		RefunReport = new AL_Academic_FRR_RefunReport(driver);
		HP = new HomePageAdmin(driver);
		pdfutility =new PDFUtility(driver);
		test = reports.createTest("aL_Academic_FRR_RefunReportTest");
		
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
        System.out.println("Academic > Fees Related Reports > Refund Reports"); 
		
        Thread.sleep(2000);
		HP.Academic();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		RefunReport.FeesRelatedReports();
		
		Thread.sleep(2000);
		RefunReport.Refundreport();
		
		Thread.sleep(2000);
		RefunReport.Receipttypeddl();
		
		Thread.sleep(2000);
		RefunReport.Fromdate();
		
		Thread.sleep(2000);
		RefunReport.Todate();

		Thread.sleep(2000);
		RefunReport.Reportbutton();

		Thread.sleep(2000);
        switchToNextWindow();
 
        
        Thread.sleep(4000);
		//captureScreenshot(driver, "Refund Report");
		pdfutility.downloadPDF(driver, "Refund Report");
		Thread.sleep(2000);
		pdfutility.readPDF("Refund Report", "Bachelor of Arts");	

	}
}

package PayrollTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Rpt_ESIDeductionReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Payroll_Rpt_ESIDeductionReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Rpt_ESIDeductionReport esi_repo;
	HomePageAdmin HP;
	

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
	public void aL_Payroll_Rpt_ESIDeductionReportTest() throws InterruptedException, IOException {
		
	System.out.println("Payroll==> Reports==> ESI Deduction Report");
		
		esi_repo = new AL_Payroll_Rpt_ESIDeductionReport(driver);
		test = reports.createTest("aL_Payroll_Rpt_ESIDeductionReportTest");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();
		
		Thread.sleep(5000);;
		esi_repo.Reports();
		
		Thread.sleep(5000);;
		esi_repo.ESIDeductionReport();
		
		Thread.sleep(5000);;
		esi_repo.Select_month();
		
		Thread.sleep(5000);
		esi_repo.Select_college();
		
		Thread.sleep(5000);;
		esi_repo.Select_Scheme();
		
		Thread.sleep(5000);;
		esi_repo.Click_ESIC_Report_btn();
		
		Thread.sleep(5000);
		switchToNextWindow();
		
		Thread.sleep(5000);;
		Screenshot.takesScreenshotReports(getCurrentTime());
		captureScreenshot(driver, "ESI Deduction Report");
		
		Thread.sleep(5000);
		switchToFrameOrDefault();
	}
}

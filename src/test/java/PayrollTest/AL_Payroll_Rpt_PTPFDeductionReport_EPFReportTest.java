package PayrollTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Rpt_PTPFDeductionReport_EPFReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Payroll_Rpt_PTPFDeductionReport_EPFReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Rpt_PTPFDeductionReport_EPFReport epf_dedu;
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
	public void aL_Payroll_Rpt_PTPFDeductionReport_EPFReportTest() throws InterruptedException, IOException {
		
	System.out.println("Payroll==> Reports==> PT/ PF Deduction Report ==> EPF Report");
		
		epf_dedu = new AL_Payroll_Rpt_PTPFDeductionReport_EPFReport(driver);
		test = reports.createTest("aL_Payroll_Rpt_PTPFDeductionReport_EPFReportTest");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();
		
		Thread.sleep(5000);;
		epf_dedu.Reports();
		
		Thread.sleep(5000);;
		epf_dedu.PF_PT_Deduction_Repo();
		
		Thread.sleep(5000);;
		epf_dedu.Select_month();
		
		Thread.sleep(5000);
		epf_dedu.Select_college();
		
		Thread.sleep(5000);
		epf_dedu.Select_Staff();
		
		//PT Report btn
		Thread.sleep(5000);;
		epf_dedu.Click_EPFReport_btn();
		
		Thread.sleep(5000);
		switchToNextWindow();
		
		Thread.sleep(5000);;
		Screenshot.takesScreenshotReports(getCurrentTime());
		captureScreenshot(driver, "EPF Report");
		
		Thread.sleep(5000);
		switchToFrameOrDefault();
	}
}

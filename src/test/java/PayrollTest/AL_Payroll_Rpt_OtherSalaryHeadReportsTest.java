package PayrollTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Rpt_OtherSalaryHeadReports;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Payroll_Rpt_OtherSalaryHeadReportsTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Rpt_OtherSalaryHeadReports heads_pays;
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
	public void aL_Payroll_Rpt_OtherSalaryHeadReportsTest() throws InterruptedException, IOException {
		
	System.out.println("Payroll==> Reports==> Other Salary Head Reports");
		
		heads_pays = new AL_Payroll_Rpt_OtherSalaryHeadReports(driver);
		test = reports.createTest("aL_Payroll_Rpt_OtherSalaryHeadReportsTest");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();
		
		Thread.sleep(5000);;
		heads_pays.Reports();
		
		Thread.sleep(5000);;
		heads_pays.OtherSalaryHeadReport();
		
		Thread.sleep(5000);;
		heads_pays.Select_month();
		
		Thread.sleep(5000);
		heads_pays.Select_college();
		
		Thread.sleep(5000);;
		heads_pays.Select_Staff();
		
		Thread.sleep(5000);;
		heads_pays.Select_ShowInReport();
		
		Thread.sleep(5000);;
		heads_pays.Select_PayHeads_PAY();
		
		Thread.sleep(5000);;
		heads_pays.Click_ShowReport_btn();
		
		Thread.sleep(5000);
		switchToNextWindow();
		
		Thread.sleep(5000);;
		Screenshot.takesScreenshotReports(getCurrentTime());
		captureScreenshot(driver, "Other Salary Head Reports");
		
		Thread.sleep(5000);
		switchToFrameOrDefault();
	}
}

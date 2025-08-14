package PayrollTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Rpt_EmployeeJoiningReport;
import Payroll.AL_Payroll_Rpt_OtherSalaryHeadReports;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Payroll_Rpt_EmployeeJoiningReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Rpt_EmployeeJoiningReport EmpJoin;
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
	public void aL_Payroll_Rpt_EmployeeJoiningReportTest() throws InterruptedException, IOException {
		
	System.out.println("Payroll==> Reports==> Employee Joining Report");
		
		EmpJoin = new AL_Payroll_Rpt_EmployeeJoiningReport(driver);
		test = reports.createTest("aL_Payroll_Rpt_EmployeeJoiningReportTest");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();
		
		Thread.sleep(5000);;
		EmpJoin.Reports();
		
		Thread.sleep(5000);;
		EmpJoin.EmployeeJoiningReport();
		
		Thread.sleep(5000);;
		EmpJoin.Click_AAFREEN_BANU();
		
		Thread.sleep(5000);;
		EmpJoin.Click_JoiningReport_btn();
		
		Thread.sleep(5000);
		switchToNextWindow();
		
		Thread.sleep(5000);;
		Screenshot.takesScreenshotReports(getCurrentTime());
		captureScreenshot(driver, "Employee Joining Report");
		
		Thread.sleep(5000);
		switchToFrameOrDefault();
	}
}

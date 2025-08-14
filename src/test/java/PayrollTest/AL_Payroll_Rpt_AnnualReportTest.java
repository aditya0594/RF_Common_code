package PayrollTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Rpt_AnnualReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Payroll_Rpt_AnnualReportTest extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Rpt_AnnualReport Payroll_AnnualReport;
	HomePageAdmin HP;
	


	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception  {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}
		
	@Test
	public void aL_Payroll_Rpt_AnnualReportTest() throws Exception {
		
		Payroll_AnnualReport = new AL_Payroll_Rpt_AnnualReport(driver);
		
		test = reports.createTest("Payroll_AnnualReport");
		Thread.sleep(5000);
		RF_AdminLoginPage.loginPage();
		
		System.out.println("PAYROLL > Report > AnnualReport ");
		
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();

		Thread.sleep(5000);
		Payroll_AnnualReport.Report();
		
		Thread.sleep(5000);;
		Payroll_AnnualReport.AnnualReport();
	
		Thread.sleep(5000);;
		Payroll_AnnualReport.FromDate();
		
		Thread.sleep(5000);;
		Payroll_AnnualReport.ToDate();
		
		Thread.sleep(5000);;
		Payroll_AnnualReport.AllEmployees();
		
		Thread.sleep(5000);;
		Payroll_AnnualReport.SelectCollege(); 
		
		Thread.sleep(5000);;
		Payroll_AnnualReport.Staff();
		
		Thread.sleep(5000);;
		Payroll_AnnualReport.ShowButton();
		
		Thread.sleep(5000);
		switchToNextWindow();
		
		Thread.sleep(5000);;
		Screenshot.takesScreenshotReports(getCurrentTime());
		captureScreenshot(driver, "Annual Report");
		
		Thread.sleep(5000);
		switchToFrameOrDefault();
			
		
	
}
}

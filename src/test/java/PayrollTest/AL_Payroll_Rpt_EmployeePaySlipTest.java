package PayrollTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Rpt_EmployeePaySlip;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Payroll_Rpt_EmployeePaySlipTest extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Rpt_EmployeePaySlip Report_EmployeePaySlip;
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
	public void aL_Payroll_Rpt_EmployeePaySlipTest() throws Exception {
		
		Report_EmployeePaySlip = new AL_Payroll_Rpt_EmployeePaySlip(driver);
		
		test = reports.createTest("Report_EmployeePaySlip");
		Thread.sleep(5000);
		RF_AdminLoginPage.loginPage();
		
		System.out.println("PAYROLL >Report_EmployeePaySlip ");
		
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();

		Thread.sleep(5000);
		Report_EmployeePaySlip.Report();

		Thread.sleep(5000);;
		Report_EmployeePaySlip.employeePaySlip();
	
		Thread.sleep(5000);;
		Report_EmployeePaySlip.SelectMonthYear();
		
		Thread.sleep(5000);;
		Report_EmployeePaySlip.SelectCollege();
		
		Thread.sleep(5000);;
		Report_EmployeePaySlip.SelectStaff();
		
		Thread.sleep(5000);;
		Report_EmployeePaySlip.AllEmployee();
		
		Thread.sleep(5000);;
		Report_EmployeePaySlip.ShowButton();
		
		Thread.sleep(5000);
		switchToNextWindow();
		
		Thread.sleep(5000);;
		Screenshot.takesScreenshotReports(getCurrentTime());
		captureScreenshot(driver, "Employee Pay Slip");
		
		Thread.sleep(5000);
		switchToFrameOrDefault();
		
	}	
}

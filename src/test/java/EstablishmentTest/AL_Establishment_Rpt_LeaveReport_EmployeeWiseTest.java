package EstablishmentTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.AL_Establishment_Rpt_LeaveReport_EmployeeWise;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Establishment_Rpt_LeaveReport_EmployeeWiseTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Rpt_LeaveReport_EmployeeWise emp_wise_btn;
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
	public void aL_Establishment_Rpt_LeaveReport_EmployeeWiseTest() throws InterruptedException, IOException {
		
	System.out.println("ESTABLISHMENT==>REPORTS==> Leave Report==> Employee Wise report");
		
		emp_wise_btn = new AL_Establishment_Rpt_LeaveReport_EmployeeWise(driver);
		test = reports.createTest("aL_Establishment_Rpt_LeaveReport_EmployeeWiseTest");
		RF_AdminLoginPage.loginPage();	
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.ESTABLISHMENT();
		
		Thread.sleep(5000);
		emp_wise_btn.Click_REPORTS();
		
		Thread.sleep(5000);
		emp_wise_btn.Click_LeaveReport();
		
		Thread.sleep(5000);
		emp_wise_btn.Select_College_name();
		
		Thread.sleep(5000);
		emp_wise_btn.Select_leave();
		
		Thread.sleep(5000);
		emp_wise_btn.Select_Stafff_Type();
		
		Thread.sleep(5000);
		emp_wise_btn.Set_from_date();
		
		Thread.sleep(5000);
		emp_wise_btn.Set_to_date();
		
		// Report for...... Type=> Employee Wise
		
		Thread.sleep(5000);
		emp_wise_btn.Click_EmpolyeeWise_checkBox();
		
		Thread.sleep(5000);;
		emp_wise_btn.Select_EmployeeName();
		
		Thread.sleep(5000);;
		emp_wise_btn.Click_EmployeeReport_btn();
		
		Thread.sleep(5000);;

		switchToNextWindow();
		Thread.sleep(5000);

		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		System.out.println("Sceenshot of PDF is taken");
		captureScreenshot(driver, "Leave Report Employee Wise");

	}
}

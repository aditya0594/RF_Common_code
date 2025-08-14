package PayrollTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Rpt_EmployeesAbstactSalary;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Payroll_Rpt_EmployeesAbstactSalaryTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Rpt_EmployeesAbstactSalary abstact_sal;
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
	public void aL_Payroll_Rpt_EmployeesAbstactSalaryTest() throws InterruptedException, IOException {
		
	System.out.println("Payroll==> Reports==> Employee Abstact Salary");
		
		abstact_sal = new AL_Payroll_Rpt_EmployeesAbstactSalary(driver);
		test = reports.createTest("aL_Payroll_Rpt_EmployeesAbstactSalaryTest");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();

		
		Thread.sleep(5000);
		abstact_sal.Reports();
		
		Thread.sleep(5000);
		abstact_sal.Emp_abstact_salary();
		
		Thread.sleep(5000);
		abstact_sal.month();
		
		Thread.sleep(5000);
		abstact_sal.college();
		
		Thread.sleep(5000);
		abstact_sal.Staff();
		
		
		Thread.sleep(5000);;
		abstact_sal.Click_SalaryRegisterWithAbst_btn();
		
		Thread.sleep(5000);
		switchToNextWindow();
		
		Thread.sleep(5000);;
		Screenshot.takesScreenshotReports(getCurrentTime());
		captureScreenshot(driver, "Employee Abstact Salary");
		
		Thread.sleep(5000);
		switchToFrameOrDefault();
		
	}

}

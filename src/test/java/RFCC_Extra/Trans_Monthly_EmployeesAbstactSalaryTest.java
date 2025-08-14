package RFCC_Extra;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import RFCCExtra.Trans_Monthly_EmployeesAbstactSalary;
//import academic.facultyRelated.Biometric_summary_report_Page;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class Trans_Monthly_EmployeesAbstactSalaryTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	Trans_Monthly_EmployeesAbstactSalary abstact_sal;
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
	public void EmployeeAbstactSalary_Test() throws InterruptedException, IOException {
		
	System.out.println("Payroll==> Reports==> Employee Abstact Salary");
		
		abstact_sal = new Trans_Monthly_EmployeesAbstactSalary(driver);
		test = reports.createTest("Trans_Monthly_EmployeesAbstactSalary");
		RF_AdminLoginPage.loginPage();
		
		abstact_sal.PAYROLL();
		
		Thread.sleep(4000);
		abstact_sal.Reports();
		
		Thread.sleep(4000);
		abstact_sal.Emp_abstact_salary();
		
		Thread.sleep(4000);
		abstact_sal.month();
		
		Thread.sleep(4000);
		abstact_sal.college();
		
		Thread.sleep(4000);
		abstact_sal.Staff();
		
		Thread.sleep(4000);
		abstact_sal.Employee_Type();
		
		Thread.sleep(4000);
		abstact_sal.chexkBox_abstactSumary();
		
		Thread.sleep(4000);
		abstact_sal.sal_regi_with_abst();
		 
	}
	
}

package PayrollTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Trans_MW_SalaryProcess_Flow03_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_MW_SalaryProcess_Flow03_1Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_MW_SalaryProcess_Flow03_1 salaryProcess;
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
	public void aL_Payroll_Trans_MW_SalaryProcess_Flow03_1Test() throws Exception {
		
		System.out.println("Payroll==> Transaction ==> Monthly Work ==> Salary Process");
		
		salaryProcess = new AL_Payroll_Trans_MW_SalaryProcess_Flow03_1(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Payroll_Trans_MW_SalaryProcess_Flow03_1Test");
		
		RF_AdminLoginPage.loginPage();
		
		threadWait1();
		HP.PAYROLL();
		
		threadWait1();
		HP.PAYROLL_Transactions();
		
		threadWait1();
		HP.PAYROLL_Trans_MonthlyWork();
		
		threadWait1();
		salaryProcess.Click_SalaryProcess();
		
		threadWait1();
		salaryProcess.Select_MonthYear();
		
		threadWait1();
		salaryProcess.Select_College();
		
		threadWait1();
		salaryProcess.Select_Staff();
		
		threadWait1();
		salaryProcess.Click_ProcessSalaryButton();
		
		threadWait1(); 
		Alert alert = driver.switchTo().alert();
		String expectedMsg = "Salary processed successfully "; 
		String actualMsg = alert.getText();
		Assert.assertEquals(actualMsg, expectedMsg);
		System.out.println("Actual Message: " + actualMsg + "\nExpected Message: " + expectedMsg);
		threadWait1();
		alert.accept();
		
		System.out.println("Salary Process completed successfully");
	}
}

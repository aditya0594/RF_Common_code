package PayrollTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Trans_MW_BulkSalaryProcess;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_MW_BulkSalaryProcessTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_MW_BulkSalaryProcess BulkSalaryProcess;
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
	public void aL_Payroll_Trans_MW_BulkSalaryProcessTest() throws InterruptedException, IOException {
		
		System.out.println("Payroll==> Transaction==> Monthly work => Bulk Salary process");
			
		BulkSalaryProcess = new AL_Payroll_Trans_MW_BulkSalaryProcess(driver);
		test = reports.createTest("Payroll_Trans_Month_BulkSalaryProcess_Test");
		RF_AdminLoginPage.loginPage();
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();
		
		Thread.sleep(2000);
		BulkSalaryProcess.Transaction();
		
		Thread.sleep(2000);
		BulkSalaryProcess.monthlyWork();
		
		Thread.sleep(2000);
		BulkSalaryProcess.bulk_salary();
		
		Thread.sleep(2000);
		BulkSalaryProcess.month_year();
		
		Thread.sleep(2000);
		BulkSalaryProcess.college();
		
		Thread.sleep(2000);
		BulkSalaryProcess.Staff();
		
		Thread.sleep(2000);
		BulkSalaryProcess.ShowBtn();
		
		Thread.sleep(2000);
		BulkSalaryProcess.checkBoxClick();
		
		Thread.sleep(2000);
		BulkSalaryProcess.ProccesSalaryBtn();
	
		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();

		String Act_Msg = alert.getText();
		String Exp_Msg = "Salary Processed Successfully";

		if (Exp_Msg.equals(Act_Msg)) {
		System.out.println("Assertion passed"+ alert.getText());
		alert.accept();
		} else {
		System.out.println("Assertion failed: Expected '" + Exp_Msg + "' but got '" + Act_Msg + "'.");

		// Handle the alert (if any)
		try {

		System.out.println("Alert found: " + alert.getText());
		alert.accept(); // Accept the alert
		System.out.println("Alert accepted.");
		} catch (NoAlertPresentException e) {
		System.out.println("No alert present.");
		}
	}
}
}
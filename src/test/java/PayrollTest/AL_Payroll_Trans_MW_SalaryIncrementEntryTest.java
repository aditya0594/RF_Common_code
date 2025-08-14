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

import Payroll.AL_Payroll_Trans_MW_SalaryIncrementEntry;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_MW_SalaryIncrementEntryTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_MW_SalaryIncrementEntry al_Payroll_Rpt_SalaryIncrementEntry;
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
	public void aL_Payroll_Trans_MW_SalaryIncrementEntryTest() throws Exception {

		al_Payroll_Rpt_SalaryIncrementEntry = new AL_Payroll_Trans_MW_SalaryIncrementEntry(driver);

		test = reports.createTest("aL_Payroll_Trans_MW_SalaryIncrementEntryTest");
		RF_AdminLoginPage.loginPage();

		System.out.println("PAYROLL > Transactions > MonthlyWork -> Salary Increment Entry");

		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();

		Thread.sleep(5000);;
		al_Payroll_Rpt_SalaryIncrementEntry.Transactions();
		
		Thread.sleep(5000);;
		al_Payroll_Rpt_SalaryIncrementEntry.MonthlyWork();

		Thread.sleep(5000);;
		al_Payroll_Rpt_SalaryIncrementEntry.SalaryIncrementEntry();

		Thread.sleep(5000);;
		al_Payroll_Rpt_SalaryIncrementEntry.College();

		Thread.sleep(5000);;
		al_Payroll_Rpt_SalaryIncrementEntry.SchemeStaff();

		Thread.sleep(5000);;
		al_Payroll_Rpt_SalaryIncrementEntry.IncrementMonth();
		
		Thread.sleep(5000);;
		al_Payroll_Rpt_SalaryIncrementEntry.noincrement_txt();
 
		Thread.sleep(5000);
		al_Payroll_Rpt_SalaryIncrementEntry.clickSubmitButton();
		
		Thread.sleep(5000);;  
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Updated Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}

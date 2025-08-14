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

import Payroll.AL_Payroll_Trans_MW_SalaryIncrementEntryWithPercent;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Trans_MW_SalaryIncrementEntryWithPercentTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Trans_MW_SalaryIncrementEntryWithPercent al_Payroll_Rpt_SalaryIncrementEntryWithPercent;
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
	public void aL_Payroll_Trans_MW_SalaryIncrementEntryWithPercentTest() throws Exception {

		al_Payroll_Rpt_SalaryIncrementEntryWithPercent = new AL_Payroll_Trans_MW_SalaryIncrementEntryWithPercent(driver);

		test = reports.createTest("aL_Payroll_Trans_MW_SalaryIncrementEntryWithPercentTest");
		RF_AdminLoginPage.loginPage();

		System.out.println("PAYROLL > Transactions > MonthlyWork -> Salary Increment Entry With Percent");

		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();

		Thread.sleep(5000);;
		al_Payroll_Rpt_SalaryIncrementEntryWithPercent.Transactions();

		Thread.sleep(5000);
		al_Payroll_Rpt_SalaryIncrementEntryWithPercent.MonthlyWork();

		Thread.sleep(5000);;
		al_Payroll_Rpt_SalaryIncrementEntryWithPercent.SalaryIncrementEntryWithPercent();

		Thread.sleep(5000);;
		al_Payroll_Rpt_SalaryIncrementEntryWithPercent.College();

		Thread.sleep(5000);;
		al_Payroll_Rpt_SalaryIncrementEntryWithPercent.SchemeStaff();

		//Thread.sleep(5000);
		//al_Payroll_Rpt_SalaryIncrementEntryWithPercent.Department();

		Thread.sleep(5000);;
		al_Payroll_Rpt_SalaryIncrementEntryWithPercent.IncrementMonth();
		
		Thread.sleep(5000);;
		al_Payroll_Rpt_SalaryIncrementEntryWithPercent.enter_Incrementflag();
		
		Thread.sleep(5000);;
		al_Payroll_Rpt_SalaryIncrementEntryWithPercent.enter_Incrementflag();

		Thread.sleep(5000);;
		al_Payroll_Rpt_SalaryIncrementEntryWithPercent.ShowButton();

		Thread.sleep(5000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record Updated Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
		
		/*
		 * Thread.sleep(5000); switchToNextWindow();
		 * 
		 * Thread.sleep(5000);; Screenshot.takesScreenshot(getCurrentDateAndTime());
		 */

	}
}

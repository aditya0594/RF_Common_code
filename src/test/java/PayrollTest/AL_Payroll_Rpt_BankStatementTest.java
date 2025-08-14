package PayrollTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Rpt_BankStatement;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Payroll_Rpt_BankStatementTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Rpt_BankStatement al_Payroll_Rpt_BankStatement;
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
	public void al_Payroll_Rpt_BankStatementTest() throws Exception {

		al_Payroll_Rpt_BankStatement = new AL_Payroll_Rpt_BankStatement(driver);

		test = reports.createTest("Payroll_AnnualReport");
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage();

		System.out.println("PAYROLL > Report > BankStatement ");

		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();


		Thread.sleep(4000);
		al_Payroll_Rpt_BankStatement.Report();
 
		Thread.sleep(2000);
		al_Payroll_Rpt_BankStatement.BankStatement();

		Thread.sleep(2000);
		al_Payroll_Rpt_BankStatement.MonthAndYear();

		Thread.sleep(2000);
		al_Payroll_Rpt_BankStatement.BankName();

		Thread.sleep(2000);
		al_Payroll_Rpt_BankStatement.BankStatementReport();

		Thread.sleep(3000);
		switchToNextWindow();

		Thread.sleep(1000);
		Screenshot.takesScreenshotReports(getCurrentTime());
		captureScreenshot(driver,"Payroll - BankStatementReport");
		
		Thread.sleep(2000);
		switchToFrameOrDefault();

	}
}

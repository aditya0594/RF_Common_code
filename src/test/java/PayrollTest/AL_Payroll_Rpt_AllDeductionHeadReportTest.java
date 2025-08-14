package PayrollTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Rpt_AllDeductionHeadReport;
import Payroll.AL_Payroll_Rpt_AnnualReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Payroll_Rpt_AllDeductionHeadReportTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Rpt_AllDeductionHeadReport al_Payroll_Rpt_AllDeductionHeadReport;
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
	public void aL_Payroll_Rpt_AllDeductionHeadReportTest() throws Exception {

		al_Payroll_Rpt_AllDeductionHeadReport = new AL_Payroll_Rpt_AllDeductionHeadReport(driver);

		test = reports.createTest("aL_Payroll_Rpt_AllDeductionHeadReportTest"); 
		RF_AdminLoginPage.loginPage();

		System.out.println("PAYROLL > Report > All Deduction Head Report");

		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();

		Thread.sleep(5000);;
		al_Payroll_Rpt_AllDeductionHeadReport.Report();

		Thread.sleep(5000);;
		al_Payroll_Rpt_AllDeductionHeadReport.AllDeductionHeadReport();

		Thread.sleep(5000);;
		al_Payroll_Rpt_AllDeductionHeadReport.College();
		
		Thread.sleep(5000);;
		al_Payroll_Rpt_AllDeductionHeadReport.SchemeStaff();

		Thread.sleep(5000);;
		al_Payroll_Rpt_AllDeductionHeadReport.PayHead();

		Thread.sleep(5000);
		al_Payroll_Rpt_AllDeductionHeadReport.FromDate();

		Thread.sleep(5000);
		al_Payroll_Rpt_AllDeductionHeadReport.ToDate();

		Thread.sleep(6000);
		al_Payroll_Rpt_AllDeductionHeadReport.ShowButton();

		Thread.sleep(5000);
		switchToNextWindow();

		Thread.sleep(5000);;
		Screenshot.takesScreenshot(getCurrentDateAndTime());

	}
}

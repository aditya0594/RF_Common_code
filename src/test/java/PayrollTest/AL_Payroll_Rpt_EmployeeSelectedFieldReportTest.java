package PayrollTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Rpt_EmployeeIDCard;
import Payroll.AL_Payroll_Rpt_EmployeeSelectedFieldReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Payroll_Rpt_EmployeeSelectedFieldReportTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Rpt_EmployeeSelectedFieldReport al_Payroll_Rpt_EmployeeSelectedFieldReport;
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
	public void al_Payroll_Rpt_EmployeeSelectedFieldReport() throws Exception {

		al_Payroll_Rpt_EmployeeSelectedFieldReport = new AL_Payroll_Rpt_EmployeeSelectedFieldReport(driver);

		test = reports.createTest("al_Payroll_Rpt_EmployeeSelectedFieldReport");
		RF_AdminLoginPage.loginPage();

		System.out.println("PAYROLL > Report > EmployeeSelectedFieldReportTest");

		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();

		Thread.sleep(2000);
		al_Payroll_Rpt_EmployeeSelectedFieldReport.Report();

		Thread.sleep(2000);
		al_Payroll_Rpt_EmployeeSelectedFieldReport.EmployeeSelectedFieldReport();

		Thread.sleep(2000);
		al_Payroll_Rpt_EmployeeSelectedFieldReport.FieldsToSelect();

		Thread.sleep(2000);
		al_Payroll_Rpt_EmployeeSelectedFieldReport.RightArrow();

		Thread.sleep(2000);
		al_Payroll_Rpt_EmployeeSelectedFieldReport.SelectedFields();

		Thread.sleep(2000);
		al_Payroll_Rpt_EmployeeSelectedFieldReport.RightArrow2nd();

		Thread.sleep(2000);
		al_Payroll_Rpt_EmployeeSelectedFieldReport.ShowButton();
		
		Thread.sleep(2000);
		al_Payroll_Rpt_EmployeeSelectedFieldReport.ExporttoWord();

//		Thread.sleep(3000);
//		switchToNextWindow();

//		Thread.sleep(2000);
//		Screenshot.takesScreenshot(getCurrentDateAndTime());

	}
}

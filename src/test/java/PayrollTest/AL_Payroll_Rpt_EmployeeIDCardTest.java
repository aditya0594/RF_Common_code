package PayrollTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Rpt_EmployeeIDCard;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Payroll_Rpt_EmployeeIDCardTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Rpt_EmployeeIDCard al_Payroll_Rpt_EmployeeIDCard;
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
	public void aL_Payroll_Rpt_EmployeeIDCardTest() throws Exception {

		al_Payroll_Rpt_EmployeeIDCard = new AL_Payroll_Rpt_EmployeeIDCard(driver);

		test = reports.createTest("aL_Payroll_Rpt_EmployeeIDCardTest");
		RF_AdminLoginPage.loginPage();

		System.out.println("PAYROLL > Report > EmployeeIDCard");

		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();

		Thread.sleep(5000);;
		al_Payroll_Rpt_EmployeeIDCard.Report();

		Thread.sleep(5000);;
		al_Payroll_Rpt_EmployeeIDCard.EmployeeIDCard();

		Thread.sleep(5000);
		al_Payroll_Rpt_EmployeeIDCard.College();

		Thread.sleep(5000);;
		al_Payroll_Rpt_EmployeeIDCard.SchemeStaff();

		Thread.sleep(5000);
		al_Payroll_Rpt_EmployeeIDCard.IDCardType();

		Thread.sleep(7000);
		al_Payroll_Rpt_EmployeeIDCard.EmployeeName();

//		Thread.sleep(5000);
//		al_Payroll_Rpt_EmployeeIDCard.ToDate();

		Thread.sleep(5000);
		al_Payroll_Rpt_EmployeeIDCard.ShowButton();

		Thread.sleep(5000);
		switchToNextWindow();

		Thread.sleep(5000);;
		Screenshot.takesScreenshot(getCurrentDateAndTime());
		

	}
}

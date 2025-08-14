package PayrollTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Rpt_EmployeeCountReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Payroll_Rpt_EmployeeCountReportTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	PDFUtility pdfutility;
	AL_Payroll_Rpt_EmployeeCountReport empCountRepo;
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
	public void aL_Payroll_Rpt_EmployeeCountReportTest() throws Exception {

		empCountRepo = new AL_Payroll_Rpt_EmployeeCountReport(driver);
		pdfutility = new PDFUtility(driver);

		test = reports.createTest("aL_Payroll_Rpt_EmployeeCountReportTest");
		Thread.sleep(5000);
		RF_AdminLoginPage.loginPage();

		System.out.println("PAYROLL > Report > Employee Count Report ");

		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();

		Thread.sleep(5000);;
		empCountRepo.Report();

		Thread.sleep(5000);;
		empCountRepo.EmployeeCountReport();

		Thread.sleep(5000);;
		empCountRepo.Select_Date();

		Thread.sleep(5000);;
		empCountRepo.Select_College();

		Thread.sleep(5000);;
		empCountRepo.Click_ShowButtonBtn();

		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Payroll - Employee Count Report");
		Thread.sleep(2000);
		pdfutility.readPDF("Payroll - Employee Count Report", "Departme");

	}
}

package PayrollTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Rpt_PayAnnualPayHeadReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Payroll_Rpt_PayAnnualPayHeadReportTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Rpt_PayAnnualPayHeadReport al_Payroll_Rpt_PayAnnualPayHeadReport;
	PDFUtility pdfutility;
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
	public void al_Payroll_Rpt_PayAnnualPayHeadReportTest() throws Exception {

		al_Payroll_Rpt_PayAnnualPayHeadReport = new AL_Payroll_Rpt_PayAnnualPayHeadReport(driver);
		pdfutility = new PDFUtility(driver);
		
		test = reports.createTest("al_Payroll_Rpt_PayAnnualPayHeadReport");
		RF_AdminLoginPage.loginPage();

		System.out.println("PAYROLL > Report > PayAnnualPayHeadReport");

		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();

		Thread.sleep(5000);;
		al_Payroll_Rpt_PayAnnualPayHeadReport.Report(); 

		Thread.sleep(5000);;
		al_Payroll_Rpt_PayAnnualPayHeadReport.PayAnnualPayHeadReport();

		Thread.sleep(5000);
		al_Payroll_Rpt_PayAnnualPayHeadReport.FromDate();

		Thread.sleep(5000);
		al_Payroll_Rpt_PayAnnualPayHeadReport.ToDate();
		
		Thread.sleep(5000);;
		al_Payroll_Rpt_PayAnnualPayHeadReport.College();
		
		Thread.sleep(5000);;
		al_Payroll_Rpt_PayAnnualPayHeadReport.SchemeStaff();

		Thread.sleep(5000);;
		al_Payroll_Rpt_PayAnnualPayHeadReport.PayHead();

		Thread.sleep(5000);
		al_Payroll_Rpt_PayAnnualPayHeadReport.ShowButton();

		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Payroll - Pay Annual Pay Head Report");
		pdfutility.readPDF("Payroll - Pay Annual Pay Head Report", "MADHUMATHI");	
	}
}

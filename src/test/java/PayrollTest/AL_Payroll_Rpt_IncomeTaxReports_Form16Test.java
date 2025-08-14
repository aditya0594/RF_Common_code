package PayrollTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Rpt_IncomeTaxReports_ShowTax;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Payroll_Rpt_IncomeTaxReports_Form16Test extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Rpt_IncomeTaxReports_ShowTax IncomeTax;
	HomePageAdmin HP;
	PDFUtility pdfutility;
	@BeforeClass
	
	
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception  {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}
		
	@Test
	public void aL_Payroll_Rpt_IncomeTaxReports_Form16Test() throws Exception {
	
		IncomeTax = new AL_Payroll_Rpt_IncomeTaxReports_ShowTax(driver);
		HP = new HomePageAdmin(driver);
		pdfutility = new PDFUtility(driver);
		test = reports.createTest("aL_Payroll_Rpt_IncomeTaxReports_Form16Test");
		System.out.println("Payroll==> Reports ==> Income Tax Reports ==> Form 16");
		
		Thread.sleep(5000);
		RF_AdminLoginPage.loginPage();
		Thread.sleep(5000);;
		HP.PAYROLL();
		Thread.sleep(5000);;
		HP.PAYROLL_Report();
		
		Thread.sleep(5000);;
		IncomeTax.Click_IncomeTaxReports();
		
		Thread.sleep(5000);;
		IncomeTax.Select_College();
		
		Thread.sleep(5000);;
		IncomeTax.Select_Staff();
		
		Thread.sleep(5000);;
		IncomeTax.Select_Employee();
		
		// 1.Click on SHow Tax btn
		Thread.sleep(5000);;
		IncomeTax.Click_Form16Btn();
		
		Thread.sleep(5000);
		switchToNextWindow();

		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Payroll - Income Tax Reports Form16");
		Thread.sleep(5000);;	
		pdfutility.readPDF("Payroll - Income Tax Reports Form16", "NAZNEEN");	
		Thread.sleep(5000);;
		switchToFrameOrDefault();	
		
		
	}
}

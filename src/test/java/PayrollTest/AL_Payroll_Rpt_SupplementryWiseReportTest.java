package PayrollTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Rpt_AnnualReport;
import Payroll.AL_Payroll_Rpt_SupplementryWiseReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Payroll_Rpt_SupplementryWiseReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Rpt_SupplementryWiseReport suppWise_repo;
	PDFUtility pdfutility;
	HomePageAdmin HP;
	
	
	
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
	public void aL_Payroll_Rpt_SupplementryWiseReportTest() throws Exception {
		
		suppWise_repo = new AL_Payroll_Rpt_SupplementryWiseReport(driver);
		pdfutility =new PDFUtility(driver);
		test = reports.createTest("aL_Payroll_Rpt_SupplementryWiseReportTest");
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage();
		
		System.out.println("PAYROLL > Report > Supplementry Wise Report ");
		
		
		HP = new HomePageAdmin(driver);
		Thread.sleep(3000);
		HP.PAYROLL();


		Thread.sleep(2000);
		suppWise_repo.Report();
		
		Thread.sleep(2000);
		suppWise_repo.SupplementryWiseReport();
		
		Thread.sleep(2000);
		suppWise_repo.Select_Month_year();
		
		Thread.sleep(2000);
		suppWise_repo.Select_College();
		
		Thread.sleep(2000);
		suppWise_repo.Select_SupplymentryHead();
		
		Thread.sleep(2000);
		suppWise_repo.Select_OrderBy();
		
		//Report
		Thread.sleep(2000);
		suppWise_repo.Click_Reportbtn();
		
		Thread.sleep(3000);
		switchToNextWindow();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Payroll - Supplementry Wise Report");
		Thread.sleep(2000);
		pdfutility.readPDF("Payroll - Supplementry Wise Report", "ASHRAF");
		
		
	}
}

package PayrollTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Payroll.AL_Payroll_Rpt_GrossReports;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Payroll_Rpt_GrossReportsTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Payroll_Rpt_GrossReports gross_repo;
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
	public void aL_Payroll_Rpt_DetailReportTest() throws InterruptedException, IOException {
		
	System.out.println("Payroll==> Reports==> Gross Reports");
		
		gross_repo = new AL_Payroll_Rpt_GrossReports(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Payroll_Rpt_DetailReportTest");
		RF_AdminLoginPage.loginPage();
		HP.PAYROLL();
		HP.PAYROLL_Report();
		
		Thread.sleep(2000);
		gross_repo.GrossReports();
		
		Thread.sleep(2000);
		gross_repo.Select_FromDate();
		
		Thread.sleep(2000);
		gross_repo.Select_ToDate();
		
		Thread.sleep(2000);
		gross_repo.Select_PayHead();
		
		// 1sr report
		
		Thread.sleep(2000);
		gross_repo.Click_GrossExcelReport_btn();
		
		Thread.sleep(2000);
		gross_repo.readPDF("GrossExcelReport","37255056");
		
		// 2nd report
		
		Thread.sleep(2000);
		gross_repo.Click_YearlyHeadwiseExcelReport_btn();
		
		Thread.sleep(2000);
		gross_repo.readPDF("YearlyHeadwiseExcelReport","37255056");
		
		// 3rd report
		
		Thread.sleep(2000);
		gross_repo.Click_EmployeeYearlyGrossExcelReport_btn();
		
		Thread.sleep(2000);
		gross_repo.readPDF("EmployeeYearlyGrossExcelReport","37255056");
		
		// 4th report
		
		Thread.sleep(2000);
		gross_repo.Click_DepatmentWiseYearlyGrossSalaryReport_btn();
		
		Thread.sleep(2000);
		gross_repo.readPDF("DepatmentWiseYearlyGrossSalaryReport","37255056");
		
	}
}

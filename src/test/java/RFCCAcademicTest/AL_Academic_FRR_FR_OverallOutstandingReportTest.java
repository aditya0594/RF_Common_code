package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FRR_FR_OverallOutstandingReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.ExcelUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Academic_FRR_FR_OverallOutstandingReportTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_FRR_FR_OverallOutstandingReport al_Academic_FRR_FR_OverallOutstandingReport;
	ExcelUtility excelutilitytest;        

	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*****Starting Test : " + m.getName() + "******" + "\n");
	}

	@Test
	public void aL_Academic_FRR_FR_OverallOutstandingReportTest() throws Exception {

		al_Academic_FRR_FR_OverallOutstandingReport = new AL_Academic_FRR_FR_OverallOutstandingReport(driver);
		homePageAdmin = new HomePageAdmin(driver);
		excelutilitytest = new ExcelUtility(driver);

		test = reports.createTest("aL_Academic_FRR_FR_OverallOutstandingReportTest");

		Thread.sleep(2000);

		RF_AdminLoginPage.loginPage();

		System.out.println("ACADEMIC->Fees Related Reports->Fees Report");

		Thread.sleep(2000);
		// click main Academic menu.
		homePageAdmin.Academic();
		Thread.sleep(2000);

		// Click fees related submenu
		homePageAdmin.Academic_FeesRelated_Reports();
		Thread.sleep(2000);

		// Click Fees Report
		al_Academic_FRR_FR_OverallOutstandingReport.Select_Fees_Report();
		Thread.sleep(5000);

		// Select Overall Outstanding Report(EXCEL)
		al_Academic_FRR_FR_OverallOutstandingReport.Select_Overall_Outstanding_Report();
		Thread.sleep(3000);

		// Select From Date
		al_Academic_FRR_FR_OverallOutstandingReport.Enter_From_Date();
		Thread.sleep(3000);

		// Select To Date
		al_Academic_FRR_FR_OverallOutstandingReport.Enter_To_Date();
		Thread.sleep(3000);

		// Receipt Type
		al_Academic_FRR_FR_OverallOutstandingReport.Check_Receipt_Type();
		Thread.sleep(2000);

		// Click submit button
		al_Academic_FRR_FR_OverallOutstandingReport.Click_Submit_Button();
	
		
		Thread.sleep(5000);
        excelutilitytest.ReadExcel("ASHUTOSH","Consolidated Outstanding Report"); 
	}

}

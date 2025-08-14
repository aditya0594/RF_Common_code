package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FRR_FeesReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Academic_FRR_FeesReportTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FRR_FeesReport al_Academic_FRR_FeesReport;
	HomePageAdmin homePageAdmin ;

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
	public void aL_Academic_FRR_FeesReportTest() throws Exception {
		al_Academic_FRR_FeesReport = new AL_Academic_FRR_FeesReport(driver);
		homePageAdmin = new HomePageAdmin(driver);
		test = reports.createTest("feesReportTest");
		Thread.sleep(3000);

		RF_AdminLoginPage.loginPage(); 

		System.out.println("ACADEMIC->Fees Related Reports->Fees Report");

		Thread.sleep(3000);
		//Click Main Academic menu
		homePageAdmin.Academic();
		Thread.sleep(3000);
		
		//Click Fees Related Report Submenu
		homePageAdmin.Academic_FeesRelated_Reports();
		Thread.sleep(3000);
		
		//Click Fees Report Page
		al_Academic_FRR_FeesReport.Select_Fees_Report();
		System.out.println("click fees Report");
		Thread.sleep(3000);
		
		//Select Report type
		al_Academic_FRR_FeesReport.Select_Report_Type();

		//Select Academic Year
		Thread.sleep(3000);
		al_Academic_FRR_FeesReport.Select_Academic_Year();
		Thread.sleep(3000);

		//Enter From Date
		al_Academic_FRR_FeesReport.Enter_From_Date("05/12/2023");

		Thread.sleep(5000);
		//Enter To Date
		al_Academic_FRR_FeesReport.Enter_To_Date("22/01/2024");
		Thread.sleep(5000);

		//Select Degree
		al_Academic_FRR_FeesReport.Select_Degree();

		Thread.sleep(7000);
		//Receipt Type
		al_Academic_FRR_FeesReport.Check_Receipt_Type();

		Thread.sleep(3000);
		//Click on show button
		al_Academic_FRR_FeesReport.Click_ShowData_Button();		
		
		Thread.sleep(5000);
		al_Academic_FRR_FeesReport.Verify_SearchedData();
}
}

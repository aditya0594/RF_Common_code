package RFCCAcademicTest;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_MF_MiscellaneousFeesReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Academic_MF_MiscellaneousFeesReportTests extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_MF_MiscellaneousFeesReport al_Academic_MF_MiscellaneousFeesReport;
	
	@BeforeTest 
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting Test : " + m.getName() + "\n");
	} 

	@Test 
	public void aL_Academic_MF_MiscellaneousFeesReportTests() throws Exception {
		test = reports.createTest("aL_Academic_MF_MiscellaneousFeesReportTests");
		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_MF_MiscellaneousFeesReport = new AL_Academic_MF_MiscellaneousFeesReport(driver);
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		Thread.sleep(2000);
		System.out.println("ACADEMIC->Miscellaneous Fee->Miscellaneous fees Report");
		
		//Click on Academic from navigation bar
		homePageAdmin.Academic();
		Thread.sleep(2000);
		
		//Click on Miscellaneous Fee option
		homePageAdmin.Academic_MiscellaneousFee();
		Thread.sleep(2000);
		
		//Click on Miscellaneous report from sub menu
		al_Academic_MF_MiscellaneousFeesReport.click_MiscellaneousFeesReport();
		Thread.sleep(2000);

		//Select Cash Book
		al_Academic_MF_MiscellaneousFeesReport.select_Cashbook();
		Thread.sleep(2000);
		
		//Select Transaction Type
		al_Academic_MF_MiscellaneousFeesReport.select_TransactionType();
		Thread.sleep(2000);
		
		//Enter From Date
		al_Academic_MF_MiscellaneousFeesReport.enter_FromDate();
		Thread.sleep(2000);

		//Enter To Date
		al_Academic_MF_MiscellaneousFeesReport.enter_ToDate();
		Thread.sleep(2000);

		//Click on Fee Collection Summary Report
		al_Academic_MF_MiscellaneousFeesReport.click_FeeCollectionSummaryReport();
		Thread.sleep(2000);

		switchToNextWindow();
		threadWait1();
		
		captureScreenshot(driver, "Miscellaneous Fees Report");
	
	}

}

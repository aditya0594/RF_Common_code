package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_FRR_StudentLedgerReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Academic_FRR_StudentLedgerReportTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Academic_FRR_StudentLedgerReport al_Academic_FRR_StudentLedgerReport;
	HomePageAdmin homePageAdmin;
	PDFUtility pdfutility;

	
	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "***** Starting " + m.getName() + " *******" + "\n");
	}

	@Test
	public void aL_Academic_FRR_StudentLedgerReportTest() throws Exception {

		al_Academic_FRR_StudentLedgerReport = new AL_Academic_FRR_StudentLedgerReport(driver);
		test = reports.createTest("aL_Academic_FRR_StudentLedgerReportTest");
		homePageAdmin = new HomePageAdmin(driver);
		pdfutility = new PDFUtility(driver);

		Thread.sleep(3000);

		RF_AdminLoginPage.loginPage();
		
		System.out.println("ACADEMIC->Fees Related Reports->Student ledger report");
		
		homePageAdmin.Academic();
		Thread.sleep(2000);
		
		// Locating the element from Sub Menu
		homePageAdmin.Academic_FeesRelated_Reports();
		
	    //Click on Student ledger report
		al_Academic_FRR_StudentLedgerReport.Click_Student_Ledger_Report();
		Thread.sleep(3000);
		
		//Enter Search Criteria
		al_Academic_FRR_StudentLedgerReport.Enter_Search_Criteria();
		Thread.sleep(3000);
		
		al_Academic_FRR_StudentLedgerReport.Enter_Search_String(); 

		//Click Search Button
		Thread.sleep(3000);
		al_Academic_FRR_StudentLedgerReport.Click_Search_Button();

		Thread.sleep(3000);
		//Select Name
		al_Academic_FRR_StudentLedgerReport.Select_Name();

		Thread.sleep(3000);
		//Click Ledger Report
		al_Academic_FRR_StudentLedgerReport.Click_Ledger_Report();

		Thread.sleep(5000);
		switchToNextWindow();

		Thread.sleep(7000);
		pdfutility.downloadPDF(driver, "Academic - Click Ledger Report");
		Thread.sleep(5000);
		pdfutility.readPDF("Academic - Click Ledger Report", "KEERTHANA");
		
	}

	
}

package AdministrationTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Administration.AL_Administration_VM_Trans_BusTokenIssue;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Administration_VM_Trans_BusTokenIssueTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Administration_VM_Trans_BusTokenIssue busTokenIssue;
	HomePageAdmin HP;
	PDFUtility pdfutility;

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
	public void aL_Administration_VM_Trans_BusTokenIssueTest() throws Exception {

		busTokenIssue = new AL_Administration_VM_Trans_BusTokenIssue(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Administration_VM_Trans_BusTokenIssueTest"); 
		pdfutility =new PDFUtility(driver);	

		
		RF_AdminLoginPage.loginPage();
		System.out.println("ADMINISTRATION > Vehicle Management > Transaction > Bus Token Issue");

		threadWait1();
		HP.ADMINISTRATION();
		
		threadWait1();
		HP.Admin_VehicleManagement();
		
		threadWait1();
		HP.Admin_VM_Transaction();

		threadWait1();
		busTokenIssue.Click_BusTokenIssueLink();
		
		threadWait1();
		busTokenIssue.Enter_Token40();
		
		threadWait1();
		busTokenIssue.Enter_Token30();
		
		threadWait1();
		busTokenIssue.Click_SubmitBtn();
		
		Thread.sleep(2000); 
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Record saved successfully."; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg, Expected_Msg);
		System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
		alert.accept();
		
		// Click on Report Button
		threadWait1();
		busTokenIssue.Click_ReportBtn();
		
		// Enter report date range and show report
		threadWait1();
		busTokenIssue.Enter_FromDate();
		
		threadWait1();
		busTokenIssue.Enter_ToDate();
		
		threadWait1();
		busTokenIssue.Click_ShowReportBtn();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Administration - Bus Token Issue");
		Thread.sleep(2000);
		pdfutility.readPDF("Administration - Bus Token Issue", "Token 30");	

	}
}

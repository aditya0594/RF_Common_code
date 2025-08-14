package EstablishmentTest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Establishment.AL_Establishment_Trans_LeaveShiftManagement;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Establishment_Trans_LeaveShiftManagementTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Establishment_Trans_LeaveShiftManagement leaveShiftManagement;
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
	public void aL_Establishment_Trans_LeaveShiftManagementTest() throws Exception {

		leaveShiftManagement = new AL_Establishment_Trans_LeaveShiftManagement(driver);
		pdfutility = new PDFUtility(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Establishment_Trans_LeaveShiftManagementTest"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("ESTBALISHMENT > Transactions > Leave Shift Management");

		threadWait1();
		HP.ESTABLISHMENT();
		
		threadWait1();
		HP.Estab_Transactions();

		threadWait1();
		leaveShiftManagement.Click_LeaveShiftManagement();
		
		threadWait1();
		leaveShiftManagement.Enter_FromDate();
		
		threadWait1();
		leaveShiftManagement.Select_College();
		
		threadWait1();
		leaveShiftManagement.Select_Incharge();
		
		threadWait1();
		leaveShiftManagement.Select_AssignShiftName();
		
		threadWait1();
		leaveShiftManagement.Click_SelectCheckbox();
		
		threadWait1();
		leaveShiftManagement.Click_SaveButton();
		
		threadWait1(); 
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Record Saved Successfully!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg, Expected_Msg);
		System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
		alert.accept();
		
		
		
		threadWait1();
		leaveShiftManagement.Enter_FromDate();
		
		threadWait1();
		leaveShiftManagement.Select_College();
		
		threadWait1();
		leaveShiftManagement.Select_Incharge();
		
		threadWait1();
		leaveShiftManagement.Click_ReportButton();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Establishment - Leave Shift Management Report");
		Thread.sleep(3000);
		pdfutility.readPDF("Establishment - Leave Shift Management Report", "AYSHA");	

	}
}

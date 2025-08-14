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

import Administration.AL_Administration_VM_Trans_LogbookEntry;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Administration_VM_Trans_LogbookEntryTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Administration_VM_Trans_LogbookEntry logbookEntry;
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
	public void aL_Administration_VM_Trans_LogbookEntryTest() throws Exception {

		logbookEntry = new AL_Administration_VM_Trans_LogbookEntry(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Administration_VM_Trans_LogbookEntryTest"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("ADMINISTRATION > Vehicle Management > Transaction > Logbook Entry");

		threadWait1();
		HP.ADMINISTRATION();
		
		threadWait1();
		HP.Admin_VehicleManagement();
		
		threadWait1();
		HP.Admin_VM_Transaction();

		threadWait1();
		logbookEntry.Click_LogbookEntryLink();
		
		threadWait1();
		logbookEntry.Select_Vehicle();
		
		threadWait1();
		logbookEntry.Select_TripType();
		
		threadWait1();
		logbookEntry.Enter_TourDate();
		
		threadWait1();
		logbookEntry.Enter_DepartureTime();
		
		threadWait1();
		logbookEntry.Enter_FromLocation();
		
		threadWait1();
		logbookEntry.Enter_ToLocation();
		
		threadWait1();
		logbookEntry.Enter_StartMeterReading();
		
		threadWait1();
		logbookEntry.Select_Driver();
		
		threadWait1();
		logbookEntry.Click_SubmitBtn();
		
		Thread.sleep(2000); 
	
		// Verify alert message
		String Expected_Msg = "Record save successfully"; 
		String Actual_Msg = logbookEntry.Get_AlertText();
		Assert.assertEquals(Actual_Msg, Expected_Msg);
		System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
		logbookEntry.Accept_Alert();
		
		// Search and delete the created record
		Thread.sleep(2000);
		logbookEntry.Search_Vehicle();
		
		threadWait1();
		logbookEntry.Click_DeleteIcon();
		
		threadWait1();
		logbookEntry.Click_YesBtn();
		
		Thread.sleep(2000);
		// Verify deletion alert message
		String Expected_Delete_Msg = "Record deleted successfully";
		String Actual_Delete_Msg = logbookEntry.Get_AlertText();
		Assert.assertEquals(Actual_Delete_Msg, Expected_Delete_Msg);
		System.out.println("Delete confirmation message - " + Actual_Delete_Msg + "\n" + "Expected Message - " + Expected_Delete_Msg);
		logbookEntry.Accept_Alert();
	}
}

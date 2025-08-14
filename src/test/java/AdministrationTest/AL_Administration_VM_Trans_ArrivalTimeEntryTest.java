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

import Administration.AL_Administration_VM_Trans_ArrivalTimeEntry;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Administration_VM_Trans_ArrivalTimeEntryTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Administration_VM_Trans_ArrivalTimeEntry arrivalTimeEntry;
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
	public void aL_Administration_VM_Trans_ArrivalTimeEntryTest() throws Exception {

		arrivalTimeEntry = new AL_Administration_VM_Trans_ArrivalTimeEntry(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Administration_VM_Trans_ArrivalTimeEntryTest"); 
		pdfutility =new PDFUtility(driver);	

		
		RF_AdminLoginPage.loginPage();
		System.out.println("ADMINISTRATION > Vehicle Management > Transaction > Arrival Time Entry");

		threadWait1();
		HP.ADMINISTRATION();
		
		threadWait1();
		HP.Admin_VehicleManagement();
		
		threadWait1();
		HP.Admin_VM_Transaction();

		threadWait1();
		arrivalTimeEntry.Click_ArrivalTimeEntryLink();
		
		threadWait1();
		arrivalTimeEntry.Enter_ArrivalDate();
		
		threadWait1();
		arrivalTimeEntry.Select_Route();
		
		threadWait1();
		arrivalTimeEntry.Enter_ArrivalTime();
		
		threadWait1();
		arrivalTimeEntry.Click_AddBtn();
		
		threadWait2();
		arrivalTimeEntry.Enter_ACBus38Count();
		
		threadWait1();
		arrivalTimeEntry.Enter_ACBus55Count();
		
		threadWait1();
		arrivalTimeEntry.Enter_DedicatedBusCount();
		
		threadWait1();
		arrivalTimeEntry.Enter_BusCount();
		
		threadWait1();
		arrivalTimeEntry.Click_SubmitBtn();
		
		Thread.sleep(2000); 
	
		// Verify alert message
		Thread.sleep(2000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Record saved successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();

		Thread.sleep(2000);
		// Click on Show Report button
		arrivalTimeEntry.Click_ShowReportBtn();
		
		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Administration - Arrival Time Entry");
		Thread.sleep(2000);
		pdfutility.readPDF("Administration - Arrival Time Entry", "MIhan");	

	}
}

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

import Administration.AL_Administration_VM_Trans_RoadTax;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Administration_VM_Trans_RoadTaxTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Administration_VM_Trans_RoadTax roadTax;
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
	public void aL_Administration_VM_Trans_RoadTaxTest() throws Exception {

		roadTax = new AL_Administration_VM_Trans_RoadTax(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Administration_VM_Trans_RoadTaxTest"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("ADMINISTRATION > Vehicle Management > Transaction > Road Tax");

		threadWait1();
		HP.ADMINISTRATION();
		
		threadWait1();
		HP.Admin_VehicleManagement();
		
		threadWait1();
		HP.Admin_VM_Transaction();

		threadWait1();
		roadTax.Click_RoadTaxLink();
		
		threadWait1();
		roadTax.Select_Vehicle();
		
		threadWait1();
		roadTax.Enter_ValidFor();
		
		threadWait1();
		roadTax.Select_YearMonth();
		
		threadWait1();
		roadTax.Enter_FromDate();
		
		threadWait1();
		roadTax.Enter_ToDate();
		
		threadWait1();
		roadTax.Enter_Amount();
		
		threadWait1();
		roadTax.Enter_ReceiptNumber();
		
		threadWait1();
		roadTax.Enter_PaidDate();
		
		threadWait1();
		roadTax.Enter_OtherCharges();
		
		threadWait1();
		roadTax.Click_SubmitBtn();
		
		Thread.sleep(2000); 
	
		// Verify alert message
		String Expected_Msg = "Record save successfully"; 
		String Actual_Msg = roadTax.Get_AlertText();
		Assert.assertEquals(Actual_Msg, Expected_Msg);
		System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
		roadTax.Accept_Alert();
		
		// Search and delete the created record
		Thread.sleep(2000);
		roadTax.Search_Vehicle();
		
		threadWait1();
		roadTax.Click_DeleteIcon();
		
		threadWait1();
		roadTax.Click_YesBtn();
		
		Thread.sleep(2000);
		// Verify deletion alert message
		String Expected_Delete_Msg = "Record deleted successfully";
		String Actual_Delete_Msg = roadTax.Get_AlertText();
		Assert.assertEquals(Actual_Delete_Msg, Expected_Delete_Msg);
		System.out.println("Delete confirmation message - " + Actual_Delete_Msg + "\n" + "Expected Message - " + Expected_Delete_Msg);
		roadTax.Accept_Alert();
	}
}

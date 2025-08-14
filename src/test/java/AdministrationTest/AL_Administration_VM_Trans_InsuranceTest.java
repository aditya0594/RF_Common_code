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

import Administration.AL_Administration_VM_Trans_Insurance;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Administration_VM_Trans_InsuranceTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Administration_VM_Trans_Insurance insurance;
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
	public void aL_Administration_VM_Trans_InsuranceTest() throws Exception {

		insurance = new AL_Administration_VM_Trans_Insurance(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Administration_VM_Trans_InsuranceTest"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("ADMINISTRATION > Vehicle Management > Transaction > Insurance");

		threadWait1();
		HP.ADMINISTRATION();
		
		threadWait1();
		HP.Admin_VehicleManagement();
		
		threadWait1();
		HP.Admin_VM_Transaction();

		threadWait1();
		insurance.Click_InsuranceLink();
		
		threadWait1();
		insurance.Select_Vehicle();
		
		threadWait1();
		insurance.Enter_PolicyNumber();
		
		threadWait1();
		insurance.Enter_InsFromDate();
		
		threadWait1();
		insurance.Enter_InsToDate();
		
		threadWait1();
		insurance.Enter_PremiumAmount();
		
		threadWait1();
		insurance.Enter_AgentNumber();
		
		threadWait1();
		insurance.Enter_AgentPhone();
		
		threadWait1();
		insurance.Click_SubmitBtn();
		
		Thread.sleep(2000); 
	
		// Verify alert message
		String Expected_Msg = "Record save successfully"; 
		String Actual_Msg = insurance.Get_AlertText();
		Assert.assertEquals(Actual_Msg, Expected_Msg);
		System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
		insurance.Accept_Alert();
		
		// Search and delete the created record
		Thread.sleep(2000);
		insurance.Search_Vehicle();
		
		threadWait1();
		insurance.Click_DeleteIcon();
		
		threadWait1();
		insurance.Click_YesBtn();
		
		Thread.sleep(2000);
		// Verify deletion alert message
		String Expected_Delete_Msg = "Record deleted successfully";
		String Actual_Delete_Msg = insurance.Get_AlertText();
		Assert.assertEquals(Actual_Delete_Msg, Expected_Delete_Msg);
		System.out.println("Delete confirmation message - " + Actual_Delete_Msg + "\n" + "Expected Message - " + Expected_Delete_Msg);
		insurance.Accept_Alert();
	}
}

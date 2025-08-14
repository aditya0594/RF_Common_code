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

import Administration.AL_Administration_VM_Trans_TourEventDetails;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Administration_VM_Trans_TourEventDetailsTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Administration_VM_Trans_TourEventDetails tourEventDetails;
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
	public void aL_Administration_VM_Trans_TourEventDetailsTest() throws Exception {

		tourEventDetails = new AL_Administration_VM_Trans_TourEventDetails(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Administration_VM_Trans_TourEventDetailsTest"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("ADMINISTRATION > Vehicle Management > Transaction > Tour Event Details");

		threadWait1();
		HP.ADMINISTRATION();
		
		threadWait1();
		HP.Admin_VehicleManagement();
		
		threadWait1();
		HP.Admin_VM_Transaction();

		threadWait1();
		tourEventDetails.Click_TourEventDetailsLink();
		
		threadWait1();
		tourEventDetails.Select_Vehicle();
		
		threadWait1();
		tourEventDetails.Enter_TourEventDate();
		
		threadWait1();
		tourEventDetails.Enter_OUTTime();
		
		threadWait1();
		tourEventDetails.Enter_OUTkm();
		
		
		threadWait1();
		tourEventDetails.Select_Driver();
		
		threadWait1();
		tourEventDetails.Enter_INTime();
		
		threadWait1();
		tourEventDetails.Enter_INkm();
		
		threadWait1();
		tourEventDetails.Enter_MaleCount();
		
		threadWait1();
		tourEventDetails.Enter_Place();
		
		threadWait1();
		tourEventDetails.Enter_Purpose();
		
		threadWait1();
		tourEventDetails.Click_SubmitBtn();
		
		Thread.sleep(2000); 
		tourEventDetails.Validate_AlertMessage();
	}
}

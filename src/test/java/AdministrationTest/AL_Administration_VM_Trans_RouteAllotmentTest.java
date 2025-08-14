package AdministrationTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Administration.AL_Administration_VM_Trans_RouteAllotment;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Administration_VM_Trans_RouteAllotmentTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Administration_VM_Trans_RouteAllotment routeAllotment;
	HomePageAdmin HP;

	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "***** Starting Test: " + m.getName() + "*****" + "\n");
	}

	@Test
	public void aL_Administration_VM_Trans_RouteAllotmentTest() throws Exception {

		routeAllotment = new AL_Administration_VM_Trans_RouteAllotment(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Administration_VM_Trans_RouteAllotmentTest");

		RF_AdminLoginPage.loginPage();
		System.out.println("ADMINISTRATION > Vehicle Management > Transaction > Route Allotment");

		threadWait1();
		HP.ADMINISTRATION();
		
		threadWait1();
		HP.Admin_VehicleManagement();
		
		threadWait1();
		HP.Admin_VM_Transaction();

		threadWait1();
		routeAllotment.Click_RouteAllotmentLink();
		
		threadWait1();
		routeAllotment.Select_OrderBy();
		
		threadWait1();
		routeAllotment.Select_Employee();
		
		threadWait1();
		routeAllotment.Select_Route();
		
		threadWait1();
		routeAllotment.Select_BoardingPoint();
		
		threadWait1();
		routeAllotment.Click_SubmitBtn();
		
		threadWait1();
		routeAllotment.Verify_AlertMessage();
	}
	

}

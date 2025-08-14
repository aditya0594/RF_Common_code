package HostelTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

//import Hostel.AL_Hostel_Transaction_AssetAllotment;
import Hostel.AL_Hostel_Transaction_GuestRoomAllotment;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Hostel_Transaction_GuestRoomAllotmentTests extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_Transaction_GuestRoomAllotment al_Hostel_Transaction_GuestRoomAllotment;
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
	public void al_Hostel_Transaction_GuestRoomAllotment() throws Exception {

		al_Hostel_Transaction_GuestRoomAllotment = new AL_Hostel_Transaction_GuestRoomAllotment(driver);

		test = reports.createTest("AssetAllotment");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Hostel > Transaction > Asset Allotment");

		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.HOSTEL();
		Thread.sleep(2000);

		threadWait1();
		al_Hostel_Transaction_GuestRoomAllotment.Transaction();

		threadWait1();
		al_Hostel_Transaction_GuestRoomAllotment.GuestRoomAllotment();

		threadWait1();
		al_Hostel_Transaction_GuestRoomAllotment.SelectGuest();

		threadWait1();
		al_Hostel_Transaction_GuestRoomAllotment.AllotReport();
		
		Thread.sleep(2000);
		switchToNextWindow();
		Thread.sleep(5000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		captureScreenshot(driver, "Guest Room Allotment");

	}
}

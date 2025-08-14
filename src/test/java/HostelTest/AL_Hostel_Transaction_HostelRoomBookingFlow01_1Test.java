package HostelTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Hostel.AL_Hostel_Transaction_HostelRoomBookingFlow01_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Hostel_Transaction_HostelRoomBookingFlow01_1Test extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_Transaction_HostelRoomBookingFlow01_1 roombooking;	
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
	public void aL_Hostel_Transaction_HostelRoomBookingTests() throws Exception {

		roombooking = new AL_Hostel_Transaction_HostelRoomBookingFlow01_1(driver);
		test = reports.createTest("aL_Hostel_Transaction_HostelRoomBookingTests");
		
		threadWait1();
		RF_AdminLoginPage.loginPage();
		System.out.println("Hostel > Transaction > Hostel Room Booking");
		HP = new HomePageAdmin(driver);
		threadWait1();
		HP.HOSTEL();
		threadWait1();

		
		threadWait1();	
		roombooking.Transaction();
		
		threadWait1();
		roombooking.Hostel_Room_Booking();
		
		threadWait1();
		roombooking.HostelSessionddl();
		
		threadWait1();
		roombooking.HostelNameddl();
		
		threadWait1();
		roombooking.Degreeddl();
		
		threadWait1();
		roombooking.Semesterddl();
		
		threadWait1();
		roombooking.ShowRoombutton();
		
		threadWait1();
		roombooking.ClickOnRoom();
		
		threadWait1();
		roombooking.SearchStudentText();
		
		threadWait1();
		roombooking.SearchStudentButton();
		
		threadWait1();
		roombooking.SelectStudent();
		
		threadWait1();
		roombooking.doj();
		
		threadWait1();
		roombooking.AllotRoomButton();
		
		
		//Accept Alert
		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Room Alloted Successfully With Demand Creation.";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
//		acceptAlert();
				
//		threadWait1();
//		roombooking.ClosePopupButton();
//				
	}
}

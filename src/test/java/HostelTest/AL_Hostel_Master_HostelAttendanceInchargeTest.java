package HostelTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Hostel.AL_Hostel_Master_HostelAttendanceIncharge;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Hostel_Master_HostelAttendanceInchargeTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	//Hostel.AL_Hostel_Master_HostelStaffInformation aL_Hostel_Master_HostelStaffInformation;
	AL_Hostel_Master_HostelAttendanceIncharge al_Hostel_Master_HostelAttendanceIncharge;
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
	public void aL_Hostel_Master_HostelAttendanceInchargeTest() throws Exception {

		al_Hostel_Master_HostelAttendanceIncharge = new Hostel.AL_Hostel_Master_HostelAttendanceIncharge(driver);

		test = reports.createTest("AL_Hostel_Master_HostelAttendanceIncharge");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Hostel > Master > Hostel Attendance Incharge");

		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.HOSTEL();
		Thread.sleep(2000);

		Thread.sleep(2000);
		al_Hostel_Master_HostelAttendanceIncharge.Master();

		Thread.sleep(2000);
		al_Hostel_Master_HostelAttendanceIncharge.HostelStaffInformation();

		Thread.sleep(2000);
		al_Hostel_Master_HostelAttendanceIncharge.HostelName();
		
		Thread.sleep(2000);
		al_Hostel_Master_HostelAttendanceIncharge.BlockName();
		
		Thread.sleep(2000);
		al_Hostel_Master_HostelAttendanceIncharge.InchargeName();
		
		Thread.sleep(2000);
		al_Hostel_Master_HostelAttendanceIncharge.submit();
		
		Thread.sleep(3000);
		//Alert ////Record Saved Successfully!!!.
		Alert alert =  driver.switchTo().alert();
		////Record Already Exist!!!.
		String Expected_Msg = "Record Already Exists.";
		String Actual_Msg =alert.getText();
		Thread.sleep(2000);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		System.out.println(Actual_Msg + "" + Expected_Msg);
		Thread.sleep(2000);
		alert.accept();
	}
}

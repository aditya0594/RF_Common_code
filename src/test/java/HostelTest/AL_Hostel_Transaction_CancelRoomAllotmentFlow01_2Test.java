package HostelTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Hostel.AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2Test extends BaseClass{
	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2 cancelallotment;
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
	public void aL_Hostel_Transaction_CancelRoomAllotmentTests() throws Exception {
		

		cancelallotment = new AL_Hostel_Transaction_CancelRoomAllotmentFlow01_2(driver);

		test = reports.createTest("aL_Hostel_Transaction_CancelRoomAllotmentTests");
		
		threadWait1();
		RF_AdminLoginPage.loginPage();
        System.out.println("Hostel > Transaction > Cancel Room Allotment");
		
        HP = new HomePageAdmin(driver);
    	threadWait1();
    	HP.HOSTEL();
    	threadWait1();

		threadWait1();	
		cancelallotment.Transaction();
		
		threadWait1();
		cancelallotment.Cancel_Room_Allotment();
		
		threadWait1();
		cancelallotment.RoomWiseCancellation();
		
		threadWait1();
		cancelallotment.Sessionddl();
		
		threadWait1();
		cancelallotment.Hostelddl();
		
		threadWait1();
		cancelallotment.Blockddl();
		
		threadWait1();
		cancelallotment.Floorddl();
		
		threadWait1();
		cancelallotment.Roomddl();
		
		threadWait1();
		cancelallotment.CancelDemand();
		
		threadWait1();
		cancelallotment.ShowButton1();

		threadWait1();
		cancelallotment.Searchingrid();
		
		threadWait1();
		cancelallotment.StudentSelectCancel();
		
		threadWait1();
		cancelallotment.ReasonforCancellation();
		
		threadWait1();
		cancelallotment.StudentSubmitCancelbtn();
		
		threadWait1();
		//Accept Alert
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Hostel Room Cancel Successfully.";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	
	}
}

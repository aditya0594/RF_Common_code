package HostelTest;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Hostel.AL_Hostel_Transaction_ChangeHostelRoomAllotment;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Hostel_Transaction_ChangeHostelRoomAllotmentTests extends BaseClass{
	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_Transaction_ChangeHostelRoomAllotment aL_Hostel_Transaction_ChangeHostelRoomAllotment;
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
	public void ChangeHostelRoomAllotment() throws Exception {

		aL_Hostel_Transaction_ChangeHostelRoomAllotment = new AL_Hostel_Transaction_ChangeHostelRoomAllotment(driver);

		test = reports.createTest("ChangeHostelRoomAllotment");
		
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
        System.out.println("Hostel > Transaction > Change Hostel Room Allotment");

        HP = new HomePageAdmin(driver);
    	Thread.sleep(2000);
    	HP.HOSTEL();
    	Thread.sleep(2000);

		
		Thread.sleep(2000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.Transaction();
		
		Thread.sleep(2000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.ChangeRoomAllotment();

		Thread.sleep(2000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.Sessionddl();
		
		Thread.sleep(2000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.Searchbox();
		
		Thread.sleep(2000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.Searchstring();
		
		Thread.sleep(2000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.SearchButton();
		
		Thread.sleep(2000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.SelectStudent();
		
		Thread.sleep(2000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.HostelNameddl();
		
		Thread.sleep(2000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.BlockNameddl();
		
		Thread.sleep(2000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.FloorNameddl();
		
		Thread.sleep(2000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.RoomNameddl();
		
		Thread.sleep(2000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.RoomTypeddl();
		
		Thread.sleep(2000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.RoomChangeDate();
		
		Thread.sleep(2000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.Demandupdate();
		
		Thread.sleep(4000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.SubmitButton();
		
		Thread.sleep(2000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.Successmessage();
		
		Thread.sleep(2000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.ReportButton();
		
		Thread.sleep(2000);
        switchToNextWindow();
        
        Thread.sleep(4000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		captureScreenshot(driver, "Change Hostel Room Allotment");
		
		Thread.sleep(2000);
		switchToFrameOrDefault();
		
		Thread.sleep(1000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.Forjoiningdateupdate();
		
		Thread.sleep(1000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.JoiningDate();
		
		Thread.sleep(1000);	
		aL_Hostel_Transaction_ChangeHostelRoomAllotment.updatebutton();
		
		Thread.sleep(4000);
		//Accept Alert
		Alert alert1 = driver.switchTo().alert();
		String Expected_Msg1 = "Joining Date Updated Successfully.";
		String Actual_Msg1 = alert1.getText();
		System.out.println("Actual Message - " + Actual_Msg1+ "\n"+ "Expected Message - " + Expected_Msg1);
		alert1.accept();
		
}
}

package ManualIssue;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import RFCCExtra.AL_Hostel_Report_RoomAllotmentStatus;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Hostel_Report_RoomAllotmentStatusTests extends BaseClass{
	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_Report_RoomAllotmentStatus aL_Hostel_Report_RoomAllotmentStatus;
	
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
	public void RoomAllotmentStatus() throws Exception {

		aL_Hostel_Report_RoomAllotmentStatus = new AL_Hostel_Report_RoomAllotmentStatus(driver);

		test = reports.createTest("RoomAllotmentStatus"); 
		
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
        System.out.println("Hostel > Report > Room Allotment Status");
        
        Thread.sleep(1000);
        aL_Hostel_Report_RoomAllotmentStatus.HOSTEL();
        
        Thread.sleep(1000);
        aL_Hostel_Report_RoomAllotmentStatus.Report();
        
        Thread.sleep(1000);
        aL_Hostel_Report_RoomAllotmentStatus.Room_Allotment_Status();
        
        Thread.sleep(1000);
        aL_Hostel_Report_RoomAllotmentStatus.sessionddl();
        
        Thread.sleep(1000);
        aL_Hostel_Report_RoomAllotmentStatus.hostelddl();
        
        Thread.sleep(1000);
        aL_Hostel_Report_RoomAllotmentStatus.showbutton();
        
        Thread.sleep(2000);
        switchToNextWindow();
        
        Thread.sleep(4000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		
		Thread.sleep(2000);
		switchToFrameOrDefault();
		
		Thread.sleep(1000);
	    aL_Hostel_Report_RoomAllotmentStatus.StudentListForHostelbutton();
	    
	    Thread.sleep(2000);
        switchToNextWindow();
        
        Thread.sleep(4000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		
		Thread.sleep(2000);
		switchToFrameOrDefault();
	    
	    Thread.sleep(1000);
        aL_Hostel_Report_RoomAllotmentStatus.VacantReportofRoombutton();
        
        Thread.sleep(2000);
        switchToNextWindow();
        
        Thread.sleep(4000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		
		Thread.sleep(2000);
		switchToFrameOrDefault();
        
        Thread.sleep(1000);
        aL_Hostel_Report_RoomAllotmentStatus.StudentAllotmentVacantReportbutton();
        
        Thread.sleep(2000);
        switchToNextWindow();
        
        Thread.sleep(4000);
		//Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		captureScreenshot(driver, "Biometric Consolidate Report");	
		
		Thread.sleep(2000);
		switchToFrameOrDefault(); 
        
}
}


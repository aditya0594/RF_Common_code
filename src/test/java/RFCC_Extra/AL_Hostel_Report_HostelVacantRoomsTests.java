package RFCC_Extra;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import RFCCExtra.AL_Hostel_Report_HostelVacantRooms;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;
public class AL_Hostel_Report_HostelVacantRoomsTests extends BaseClass{
	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_Report_HostelVacantRooms aL_Hostel_Report_HostelVacantRooms;
	
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
	public void HostelVacantRooms() throws Exception {

		aL_Hostel_Report_HostelVacantRooms = new AL_Hostel_Report_HostelVacantRooms(driver);

		test = reports.createTest("Hostel Vacant Rooms"); 
		
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
        System.out.println("Hostel > Report > Hostel Vacant Rooms");
        
        Thread.sleep(2000);
        aL_Hostel_Report_HostelVacantRooms.HOSTEL();
        
        Thread.sleep(2000);
        aL_Hostel_Report_HostelVacantRooms.Report();
        
        Thread.sleep(2000);
        aL_Hostel_Report_HostelVacantRooms.Hostel_Vacant_Rooms();
        
        Thread.sleep(2000);
        aL_Hostel_Report_HostelVacantRooms.sessionddl();
        
        Thread.sleep(2000);
        aL_Hostel_Report_HostelVacantRooms.hostelddl();
        
        Thread.sleep(2000);
        aL_Hostel_Report_HostelVacantRooms.showbutton();
        
        Thread.sleep(2000);
        switchToNextWindow();
        
        Thread.sleep(4000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		
		Thread.sleep(2000);
		switchToFrameOrDefault();
	}
}

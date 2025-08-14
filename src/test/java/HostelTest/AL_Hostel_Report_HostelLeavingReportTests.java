package HostelTest;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Hostel.AL_Hostel_Report_HostelLeavingReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;
public class AL_Hostel_Report_HostelLeavingReportTests extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_Report_HostelLeavingReport aL_Hostel_Report_HostelLeavingReport;
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
	public void HostelLeavingReports() throws Exception {

		aL_Hostel_Report_HostelLeavingReport = new AL_Hostel_Report_HostelLeavingReport(driver);

		test = reports.createTest("Hostel Leaving Report"); 
		
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
        System.out.println("Hostel > Report > Hostel Leaving Report");
        
        HP = new HomePageAdmin(driver);
    	Thread.sleep(2000);
    	HP.HOSTEL();
    	Thread.sleep(2000);

        Thread.sleep(2000);
        aL_Hostel_Report_HostelLeavingReport.Report();
        
        Thread.sleep(2000);
        aL_Hostel_Report_HostelLeavingReport.Hostel_Leaving_Report();
        
        Thread.sleep(2000);
        aL_Hostel_Report_HostelLeavingReport.Sessionddl();
        
        Thread.sleep(2000);
        aL_Hostel_Report_HostelLeavingReport.Hostelddl();
        
        Thread.sleep(2000);
        aL_Hostel_Report_HostelLeavingReport.StudentListForHostelbtn();
        
        Thread.sleep(2000);
        switchToNextWindow();
        
        Thread.sleep(4000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		captureScreenshot(driver, "Hostel Leaving Report");
		
	}
}

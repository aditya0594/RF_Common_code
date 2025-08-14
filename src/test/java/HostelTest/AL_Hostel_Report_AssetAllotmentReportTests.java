package HostelTest; 

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Hostel.AL_Hostel_Report_AssetAllotmentReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;
public class AL_Hostel_Report_AssetAllotmentReportTests extends BaseClass {
	
	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_Report_AssetAllotmentReport aL_Hostel_Report_AssetAllotmentReport;
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
	public void AssetAllotmentReport() throws Exception {

		aL_Hostel_Report_AssetAllotmentReport = new AL_Hostel_Report_AssetAllotmentReport(driver);

		test = reports.createTest("Asset Allotment Report"); 
		
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
        System.out.println("Hostel > Report > Asset Allotment Report");
        
        HP = new HomePageAdmin(driver);
    	Thread.sleep(2000);
    	HP.HOSTEL();
    	Thread.sleep(2000);

        
        Thread.sleep(2000);
        aL_Hostel_Report_AssetAllotmentReport.Report();
        
        Thread.sleep(2000);
        aL_Hostel_Report_AssetAllotmentReport.Asset_Allotment_Report();
        
        Thread.sleep(2000);
        aL_Hostel_Report_AssetAllotmentReport.Hostelddl();
        
        Thread.sleep(2000);
        aL_Hostel_Report_AssetAllotmentReport.showbutton();
        
        Thread.sleep(2000);
        switchToNextWindow();
        
        Thread.sleep(4000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		captureScreenshot(driver, "Asset Allotment Report"); 
		
		Thread.sleep(2000);
		switchToFrameOrDefault();
}
}

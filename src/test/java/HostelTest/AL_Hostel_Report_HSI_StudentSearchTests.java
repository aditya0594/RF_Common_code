package HostelTest;

import java.lang.reflect.Method;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Hostel.AL_Hostel_Report_StudentSearch;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class AL_Hostel_Report_HSI_StudentSearchTests extends BaseClass{
	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_Report_StudentSearch aL_Hostel_Report_StudentSearch;
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
	public void aL_Hostel_Report_HSI_StudentSearchTests() throws Exception {

		aL_Hostel_Report_StudentSearch = new AL_Hostel_Report_StudentSearch(driver);

		test = reports.createTest("aL_Hostel_Report_HSI_StudentSearchTests"); 
		
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
        System.out.println("Hostel > Report >Hostel Student Information >Student Search");
        
        HP = new HomePageAdmin(driver);
    	Thread.sleep(2000);
    	HP.HOSTEL();
    	Thread.sleep(2000);
        Thread.sleep(2000);
        aL_Hostel_Report_StudentSearch.Report();
        
        Thread.sleep(2000);
        aL_Hostel_Report_StudentSearch.StudentSearch();
        
        Thread.sleep(2000);
        aL_Hostel_Report_StudentSearch.searchstudent();
        
        Thread.sleep(2000);
        aL_Hostel_Report_StudentSearch.searchtext();
        
        Thread.sleep(2000);
        aL_Hostel_Report_StudentSearch.searchbutton();
        
        Thread.sleep(2000);
        aL_Hostel_Report_StudentSearch.selectstud();
        
        Thread.sleep(4000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		captureScreenshot(driver, "Studentsearch_Personal Details");
		
		Thread.sleep(2000);
        aL_Hostel_Report_StudentSearch.HostelDetails();
        
        Thread.sleep(4000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		captureScreenshot(driver, "Student search_Hostel Details");
		
		Thread.sleep(2000);
        aL_Hostel_Report_StudentSearch.AssetDetails();
        
        Thread.sleep(4000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		captureScreenshot(driver, "Student search_Asset Details");
		
		Thread.sleep(2000);
        aL_Hostel_Report_StudentSearch.AttendanceDetails();
        
        Thread.sleep(4000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		captureScreenshot(driver, "Student search_Attendance Details");
		
		Thread.sleep(2000);
        aL_Hostel_Report_StudentSearch.EmergencyContactDetails();
        
		Thread.sleep(4000);	
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		captureScreenshot(driver, "Student search_EmergencyContactDetails Details");
}
}

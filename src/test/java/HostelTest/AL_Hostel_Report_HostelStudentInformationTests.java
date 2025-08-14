package HostelTest;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Hostel.AL_Hostel_Report_HostelStudentInformation;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;
public class AL_Hostel_Report_HostelStudentInformationTests extends BaseClass{
	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_Report_HostelStudentInformation aL_Hostel_Report_HostelStudentInformation;
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
	public void HostelStudentInformation() throws Exception {

		aL_Hostel_Report_HostelStudentInformation = new AL_Hostel_Report_HostelStudentInformation(driver);

		test = reports.createTest("Hostel Student Information"); 
		
		threadWait1();
		RF_AdminLoginPage.loginPage();
        System.out.println("Hostel > Report > Hostel Student Information");
        
        HP = new HomePageAdmin(driver);
    	threadWait1();
    	HP.HOSTEL();
    	threadWait1();

        
        threadWait1();
        aL_Hostel_Report_HostelStudentInformation.Report();
        
        threadWait1();
        aL_Hostel_Report_HostelStudentInformation.Hostel_Student_Information();
        
        threadWait1();
        aL_Hostel_Report_HostelStudentInformation.sessionddl();
        
        threadWait1();
        aL_Hostel_Report_HostelStudentInformation.hostelddl();
        
        threadWait1();
        aL_Hostel_Report_HostelStudentInformation.showbutton();
        
        
        Thread.sleep(4000);
		Screenshot.takesScreenshotReports(getCurrentDateAndTime());
		captureScreenshot(driver, "Hostel Student Information");
		
		
}
}


package HostelTest; 

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Hostel.AL_Hostel_Report_AssetAllotmentReport;
import Hostel.AL_Hostel_Report_PhysicallyHandicappedStudentList;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;
public class AL_Hostel_Report_PhysicallyHandicappedStudentListTest extends BaseClass {
	
	ExtentReports reports;
	ExtentTest test;
	AL_Hostel_Report_AssetAllotmentReport aL_Hostel_Report_AssetAllotmentReport;
	AL_Hostel_Report_PhysicallyHandicappedStudentList al_Hostel_Report_PhysicallyHandicappedStudentList;
	PDFUtility pdfutility;
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
	public void aL_Hostel_Report_PhysicallyHandicappedStudentListTest() throws Exception {

		al_Hostel_Report_PhysicallyHandicappedStudentList = new AL_Hostel_Report_PhysicallyHandicappedStudentList(driver);

		test = reports.createTest("AL_Hostel_Report_PhysicallyHandicappedStudentListTest"); 
		pdfutility = new PDFUtility(driver);
		
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
        System.out.println("Hostel > Report > PHYSICALLY HANDICAPPED STUDENT LIST REPORT");
        
        HP = new HomePageAdmin(driver);
    	Thread.sleep(2000);
    	HP.HOSTEL();
    	Thread.sleep(2000);

        
        Thread.sleep(2000);
        al_Hostel_Report_PhysicallyHandicappedStudentList.Report();
        
        Thread.sleep(2000);
        al_Hostel_Report_PhysicallyHandicappedStudentList.PhysicallyHandicappedStudentList();
        
        Thread.sleep(2000);
        al_Hostel_Report_PhysicallyHandicappedStudentList.HostelSession();
        
        Thread.sleep(2000);
        al_Hostel_Report_PhysicallyHandicappedStudentList.showbutton();
        
        Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Hostel - PHYSICALLY HANDICAPPED STUDENT LIST REPORT"); 
		pdfutility.readPDF("Hostel - PHYSICALLY HANDICAPPED STUDENT LIST REPORT", "AFREEN"); 
}
}

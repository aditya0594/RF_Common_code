
package HostelTest;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Hostel.AL_Hostel_Report_RAS_HostelVacantRooms;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Hostel_Report_RAS_HostelVacantRoomsTests extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	PDFUtility pdfutility;
	AL_Hostel_Report_RAS_HostelVacantRooms aL_Hostel_Report_HostelVacantRooms;
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
	public void aL_Hostel_Report_RAS_HostelVacantRoomsTests() throws Exception {

		aL_Hostel_Report_HostelVacantRooms = new AL_Hostel_Report_RAS_HostelVacantRooms(driver);
		pdfutility = new PDFUtility(driver);
		test = reports.createTest("aL_Hostel_Report_RAS_HostelVacantRoomsTests");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Hostel > Report > Hostel Vacant Rooms");

		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.HOSTEL();
		Thread.sleep(2000);
		Thread.sleep(2000);
		aL_Hostel_Report_HostelVacantRooms.Report();

		Thread.sleep(3000);
		aL_Hostel_Report_HostelVacantRooms.Hostel_Vacant_Rooms();

		Thread.sleep(2000);
		aL_Hostel_Report_HostelVacantRooms.sessionddl(); 

		Thread.sleep(2000);
		aL_Hostel_Report_HostelVacantRooms.hostelddl();

		Thread.sleep(2000);
		aL_Hostel_Report_HostelVacantRooms.showbutton();

		Thread.sleep(5000);
		switchToNextWindow();

		Thread.sleep(3000);
		pdfutility.downloadPDF(driver, "Hostel - Hostel Vacant Rooms");
		pdfutility.readPDF("Hostel - Hostel Vacant Rooms", "MB001"); 
	}
}

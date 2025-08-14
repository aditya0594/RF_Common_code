package HostelTest;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Hostel.AL_Hostel_Report_RoomAllotmentStatus;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
//import utility.Screenshot;

public class AL_Hostel_Report_RoomAllotmentStatusTests extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	PDFUtility pdfutility;
	AL_Hostel_Report_RoomAllotmentStatus aL_Hostel_Report_RoomAllotmentStatus;
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
	public void aL_Hostel_Report_RoomAllotmentStatusTests() throws Exception {

		aL_Hostel_Report_RoomAllotmentStatus = new AL_Hostel_Report_RoomAllotmentStatus(driver);
		pdfutility = new PDFUtility(driver);

		test = reports.createTest("aL_Hostel_Report_RoomAllotmentStatusTests");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Hostel > Report > Room Allotment Status");

		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.HOSTEL();
		Thread.sleep(2000);

		Thread.sleep(1000);
		aL_Hostel_Report_RoomAllotmentStatus.Report();

		Thread.sleep(1000);
		aL_Hostel_Report_RoomAllotmentStatus.Room_Allotment_Status();

		Thread.sleep(1000);
		aL_Hostel_Report_RoomAllotmentStatus.sessionddl();

		Thread.sleep(2000);
		aL_Hostel_Report_RoomAllotmentStatus.hostelddl(); 

		Thread.sleep(2000);
		aL_Hostel_Report_RoomAllotmentStatus.Select_FromDate(); 

		Thread.sleep(2000);
		aL_Hostel_Report_RoomAllotmentStatus.Select_ToDate();

		Thread.sleep(1000);
		aL_Hostel_Report_RoomAllotmentStatus.showbutton();

		Thread.sleep(5000);
		switchToNextWindow();

		Thread.sleep(5000);
		pdfutility.downloadPDF(driver, "Hostel - Room Allotment Status Report");
		pdfutility.readPDF("Hostel - Room Allotment Status Report", "230873601001");

	}
}

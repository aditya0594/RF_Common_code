
package HostelTest;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Hostel.AL_Hostel_Report_RAS_StudentListForHostel;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Hostel_Report_RAS_StudentListForHostelTests extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	PDFUtility pdfutility;
	AL_Hostel_Report_RAS_StudentListForHostel aL_Hostel_Report_RAS_StudentListForHostel;
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
	public void aL_Hostel_Report_RAS_StudentListForHostelTests() throws Exception {

		aL_Hostel_Report_RAS_StudentListForHostel = new AL_Hostel_Report_RAS_StudentListForHostel(driver);
		pdfutility = new PDFUtility(driver);
		test = reports.createTest("aL_Hostel_Report_RAS_StudentListForHostelTests");

		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		System.out.println("Hostel > Report > Student List For Hostel");

		HP = new HomePageAdmin(driver);
		Thread.sleep(2000);
		HP.HOSTEL();
		Thread.sleep(2000);

		Thread.sleep(2000);
		aL_Hostel_Report_RAS_StudentListForHostel.Report();

		Thread.sleep(3000);
		aL_Hostel_Report_RAS_StudentListForHostel.Hostel_Studentlistforhostel();

		Thread.sleep(2000);
		aL_Hostel_Report_RAS_StudentListForHostel.sessionddl();

		Thread.sleep(2000);
		aL_Hostel_Report_RAS_StudentListForHostel.hostelddl();

		Thread.sleep(2000);
		aL_Hostel_Report_RAS_StudentListForHostel.Select_FromDate();

		Thread.sleep(2000);
		aL_Hostel_Report_RAS_StudentListForHostel.Select_ToDate();

		Thread.sleep(2000);
		aL_Hostel_Report_RAS_StudentListForHostel.showbutton();

		Thread.sleep(5000);
		switchToNextWindow();

		Thread.sleep(3000);
		pdfutility.downloadPDF(driver, "Hostel - Student List For Hostel");
		pdfutility.readPDF("Hostel - Student List For Hostel", "JAY");
	}
}

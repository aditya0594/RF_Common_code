package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import RFCCAcademic.AL_Academic_AR_FacultywiseAttendanceReport;
import com.qa.pages.HomePageAdmin;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;
import utility.ExcelUtility;

public class AL_Academic_AR_FacultywiseAttendanceReportTest extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	ExcelUtility excelutilitytest;

	AL_Academic_AR_FacultywiseAttendanceReport aL_Academic_AR_FacultywiseAttendanceReport;

	
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
	public void aL_Academic_AR_FacultywiseAttendanceReportTest() throws Exception {


		test = reports.createTest("AL_Academic_AR_FacultywiseAttendanceReport");

		homePageAdmin = new HomePageAdmin(driver);
		excelutilitytest = new ExcelUtility(driver);

		aL_Academic_AR_FacultywiseAttendanceReport = new AL_Academic_AR_FacultywiseAttendanceReport(driver);

		RF_AdminLoginPage.loginPage();

		System.out.println("Academic-> Academic Reports -> Faculty wise Attendance Report "); 

		homePageAdmin.Academic();
		Thread.sleep(2000);
		homePageAdmin.Academic_AcademicReport();
		Thread.sleep(2000);
		
		aL_Academic_AR_FacultywiseAttendanceReport.click_facultywiseAttendanceReport_link();
		Thread.sleep(2000);
		aL_Academic_AR_FacultywiseAttendanceReport.select_session();
		Thread.sleep(2000);
		aL_Academic_AR_FacultywiseAttendanceReport.select_school();
		Thread.sleep(2000);
		aL_Academic_AR_FacultywiseAttendanceReport.select_department();
		Thread.sleep(2000);
		aL_Academic_AR_FacultywiseAttendanceReport.select_faculty();
		Thread.sleep(2000);
		aL_Academic_AR_FacultywiseAttendanceReport.enter_fromDate();
		Thread.sleep(2000);
		aL_Academic_AR_FacultywiseAttendanceReport.enter_toDate();
		Thread.sleep(2000);
		aL_Academic_AR_FacultywiseAttendanceReport.click_show_button();
		Thread.sleep(2000);
		aL_Academic_AR_FacultywiseAttendanceReport.click_facultywiseAttendanceReport_button();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		excelutilitytest.ReadExcel("Saurabh","Faculty wise Attendance Report");
		
		
		
	}
}

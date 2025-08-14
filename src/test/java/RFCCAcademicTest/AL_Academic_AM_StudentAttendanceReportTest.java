package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AM_StudentAttendanceReport;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_AM_StudentAttendanceReportTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Academic_AM_StudentAttendanceReport stuAttendRepo;
	HomePageAdmin HP;
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception  {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}
		
	@Test
	public void aL_Academic_AM_StudentAttendanceReportTest() throws Exception {
		
		stuAttendRepo = new AL_Academic_AM_StudentAttendanceReport(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Academic_AM_StudentAttendanceReportTest"); 
		Thread.sleep(4000);
		RF_AdminLoginPage.loginPage(); 
		
		System.out.println("ACADEMIC > Attendance Management > Student Attendance Report"); 
		
		threadWait1();
		HP.Academic();
		
		threadWait1();
		HP.Academic_AttendanceManagement();
		
		threadWait1();
		stuAttendRepo.Click_StudentAttendanceReport();
		
		threadWait1();
		stuAttendRepo.Select_Session();
		
		threadWait1();
		stuAttendRepo.Select_College();
		
		threadWait1();
		stuAttendRepo.Select_FromDate();
		
		threadWait1();
		stuAttendRepo.Select_ToDate();
		
		threadWait1();
		stuAttendRepo.Click_GlobleElectiveCourseWiseReportBtn();
		
		threadWait2();
		stuAttendRepo.Click_ShowStudentWiseAttendancebtn();
	}
}

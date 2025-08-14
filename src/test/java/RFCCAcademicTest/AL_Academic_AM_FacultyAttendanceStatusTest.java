package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AM_FacultyAttendanceStatus;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_AM_FacultyAttendanceStatusTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_AM_FacultyAttendanceStatus al_Academic_AM_FacultyAttendanceStatus;
	
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
	public void aL_Academic_AM_FacultyAttendanceStatusTest() throws Exception {
		/*
		 * driver.get(
		 * "https://rfcautomationuat.mastersofterp.in/ACADEMIC/TimeTable/iitms6/D+qq/ST5px2SPJGrTrw1YXhvU8Huy7q5nAEBtOd983jG8VobJQ2DAaJ3peNGYXxsf4eNrHO4FnApm8s+cu6g==?enc=J/hOimnKXjYzzJYY1c51Qk0mvBqVWWUPJAjaUDsTFGw="
		 * ); System.out.println("Faculty Attendance Status page open");
		 */
		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_AM_FacultyAttendanceStatus = new AL_Academic_AM_FacultyAttendanceStatus(driver);
		
		test = reports.createTest("aL_Academic_AM_FacultyAttendanceStatusTest");
		RF_AdminLoginPage.loginPage();
		
		System.out.println("ACADEMIC->Attendance Management->Faculty Attendance Status");
		
		Thread.sleep(5000);
		homePageAdmin.Academic();

		Thread.sleep(5000);
		homePageAdmin.Academic_AttendanceManagement();
		
		Thread.sleep(5000);
		//Click on Faculty Attendance Status from sub menu
		al_Academic_AM_FacultyAttendanceStatus.click_facultyAttendanceStatus_Link();
		
		Thread.sleep(5000);
		//Select clg
		al_Academic_AM_FacultyAttendanceStatus.select_College();
		
		Thread.sleep(5000);
		//Select Session
		al_Academic_AM_FacultyAttendanceStatus.select_Session();
		
		Thread.sleep(5000);
		//Select Department
		al_Academic_AM_FacultyAttendanceStatus.select_Department();
		
		Thread.sleep(5000);
		//Select Semester
		al_Academic_AM_FacultyAttendanceStatus.select_Semester();
		
		Thread.sleep(5000);
		//Select Section
		al_Academic_AM_FacultyAttendanceStatus.select_section();
		
		Thread.sleep(5000);
		al_Academic_AM_FacultyAttendanceStatus.select_course();
		
		Thread.sleep(5000);
		al_Academic_AM_FacultyAttendanceStatus.select_faculty();
		Thread.sleep(5000);
		
		al_Academic_AM_FacultyAttendanceStatus.click_facultywiseAttendanceStatus_button();
		Thread.sleep(5000);
		
		al_Academic_AM_FacultyAttendanceStatus.VerifySearchedRecords();
		Thread.sleep(1000);
		
	}
}
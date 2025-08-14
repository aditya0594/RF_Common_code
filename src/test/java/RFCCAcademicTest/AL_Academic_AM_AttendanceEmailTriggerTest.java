package RFCCAcademicTest;



import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AM_AttendanceEmailTrigger;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;

public class AL_Academic_AM_AttendanceEmailTriggerTest extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_AM_AttendanceEmailTrigger aL_Academic_AM_AttendanceEmailTrigger;
	PDFUtility pdfutility;
	
	
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
	public void aL_Academic_AM_AttendanceEmailTrigger() throws Exception {


		test = reports.createTest("AL_Academic_AM_AttendanceEmailTrigger");

		homePageAdmin = new HomePageAdmin(driver);
		aL_Academic_AM_AttendanceEmailTrigger = new AL_Academic_AM_AttendanceEmailTrigger(driver);
		pdfutility = new PDFUtility(driver);
		
		RF_AdminLoginPage.loginPage();

		System.out.println("Academic-> Attendance Management-> Attendance Email Trigger ");

		homePageAdmin.Academic();
		threadWait1();
		homePageAdmin.Academic_AttendanceManagement();
		Thread.sleep(3000);
		aL_Academic_AM_AttendanceEmailTrigger.click_attendanceEmailTrigger_link();
		threadWait1();
		aL_Academic_AM_AttendanceEmailTrigger.select_session();
		threadWait1();
		aL_Academic_AM_AttendanceEmailTrigger.select_college();
		threadWait1();
		aL_Academic_AM_AttendanceEmailTrigger.select_semester();
		threadWait1();
		aL_Academic_AM_AttendanceEmailTrigger.enter_fromDate();
		threadWait1();
		aL_Academic_AM_AttendanceEmailTrigger.enter_toDate();
		threadWait1();
		aL_Academic_AM_AttendanceEmailTrigger.click_show_button();
		threadWait1();
		aL_Academic_AM_AttendanceEmailTrigger.click_checkbox();
		threadWait1();
		aL_Academic_AM_AttendanceEmailTrigger.click_sendEmailToStudent_button();
		threadWait1();
		
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Email Send Successfully !!!"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		Thread.sleep(2000);
		alert.accept();
		
	}
}

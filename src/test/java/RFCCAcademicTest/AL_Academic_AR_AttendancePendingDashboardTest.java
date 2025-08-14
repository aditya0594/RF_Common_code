package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import RFCCAcademic.AL_Academic_AR_AttendancePendingDashboard;
import RFCCAcademic.AL_Academic_PA_AdmissionChangeActivities;
import com.qa.pages.HomePageAdmin;

import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_AR_AttendancePendingDashboardTest extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_AR_AttendancePendingDashboard aL_Academic_AR_AttendancePendingDashboard;

	// AL_Examination_COE_IGradeEntry_BulkIGradeEntry bulk_i_grade;
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
	public void aL_Academic_AR_AttendancePendingDashboard() throws Exception {


		test = reports.createTest("AL_Academic_AR_AttendancePendingDashboard");

		homePageAdmin = new HomePageAdmin(driver);
		aL_Academic_AR_AttendancePendingDashboard = new AL_Academic_AR_AttendancePendingDashboard(driver);

		RF_AdminLoginPage.loginPage();

		System.out.println("Academic-> Academic Reports -> Attendance Pending Dashboard ");

		homePageAdmin.Academic();
		Thread.sleep(4000);
		homePageAdmin.Academic_AcademicReport();
		Thread.sleep(4000);
		
		aL_Academic_AR_AttendancePendingDashboard.click_attendancePendingDashboard_link();
		Thread.sleep(4000);
		
		//Single Email Sending 
		aL_Academic_AR_AttendancePendingDashboard.click_singleEmailSending_radioBtn();
		Thread.sleep(4000);
		aL_Academic_AR_AttendancePendingDashboard.select_session();
		Thread.sleep(4000);
		aL_Academic_AR_AttendancePendingDashboard.enter_fromDate();
		Thread.sleep(4000);
		aL_Academic_AR_AttendancePendingDashboard.enter_toDate();
		Thread.sleep(4000);
		aL_Academic_AR_AttendancePendingDashboard.click_show_btn();
		Thread.sleep(4000);
		aL_Academic_AR_AttendancePendingDashboard.click_sendEmail_btn();
		Thread.sleep(4000);
		aL_Academic_AR_AttendancePendingDashboard.enter_subject();
		Thread.sleep(4000);
		aL_Academic_AR_AttendancePendingDashboard.enter_body();
		Thread.sleep(4000);
		aL_Academic_AR_AttendancePendingDashboard.click_sent_btn();
		Thread.sleep(4000);
		
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Email Sent Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		
		//Bulk Email Sending
		Thread.sleep(3000);
		aL_Academic_AR_AttendancePendingDashboard.click_bulkEmailSending_radioBtn();
		Thread.sleep(4000);
		aL_Academic_AR_AttendancePendingDashboard.select_BulkSession();
		Thread.sleep(4000);
		aL_Academic_AR_AttendancePendingDashboard.enter_fromDateBulk();
		Thread.sleep(4000);
		aL_Academic_AR_AttendancePendingDashboard.enter_toDateBulk();
		Thread.sleep(4000);
		aL_Academic_AR_AttendancePendingDashboard.click_showBulk_button();
		Thread.sleep(4000);
		aL_Academic_AR_AttendancePendingDashboard.click_checkbox();
		Thread.sleep(4000);
		aL_Academic_AR_AttendancePendingDashboard.click_sendEmailBulk_Btn();
		Thread.sleep(5000);
		Alert alert1 =  driver.switchTo().alert();
		String Expected_Msg1 = "Email Sent Successfully"; 
		String Actual_Msg1 = alert1.getText();
		Assert.assertEquals(Actual_Msg1 , Expected_Msg1 );
		System.out.println("Actual Message - " + Actual_Msg1+ "\n"+ "Expected Message - " + Expected_Msg1);
		alert1.accept();
		Thread.sleep(4000);
	}
}

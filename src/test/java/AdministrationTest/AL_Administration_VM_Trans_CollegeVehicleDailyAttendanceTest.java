package AdministrationTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import Administration.AL_Administration_VM_Trans_CollegeVehicleDailyAttendance;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Administration_VM_Trans_CollegeVehicleDailyAttendanceTest extends BaseClass
{
	ExtentReports reports;
	ExtentTest test;
	AL_Administration_VM_Trans_CollegeVehicleDailyAttendance collegeVehicleDailyAttendance;
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
	public void aL_Administration_VM_Trans_CollegeVehicleDailyAttendanceTest() throws Exception {

		collegeVehicleDailyAttendance = new AL_Administration_VM_Trans_CollegeVehicleDailyAttendance(driver);
		HP = new HomePageAdmin(driver);
		test = reports.createTest("aL_Administration_VM_Trans_CollegeVehicleDailyAttendanceTest"); 

		RF_AdminLoginPage.loginPage();
		System.out.println("ADMINISTRATION > Vehicle Management > Transaction > College Vehicle Daily Attendance");

		threadWait1();
		HP.ADMINISTRATION();
		
		threadWait1();
		HP.Admin_VehicleManagement();
		
		threadWait1();
		HP.Admin_VM_Transaction();

		threadWait1();
		collegeVehicleDailyAttendance.Click_CollegeVehicleDailyAttendanceLink();
		
		threadWait1();
		collegeVehicleDailyAttendance.Select_Vehicle();
		
		threadWait1();
		collegeVehicleDailyAttendance.Select_DriverConductor();
		
		threadWait1();
		collegeVehicleDailyAttendance.Click_AttendanceCheckbox();
		
		threadWait1();
		collegeVehicleDailyAttendance.Enter_StudentCount();
		
		threadWait1();
		collegeVehicleDailyAttendance.Enter_StaffCount();
		
		threadWait1();
		collegeVehicleDailyAttendance.Click_AddBtn();
		
		threadWait1();
		collegeVehicleDailyAttendance.Click_SubmitBtn();
		
		Thread.sleep(2000); 
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Record submitted successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg, Expected_Msg);
		System.out.println("Actual Message - " + Actual_Msg + "\n" + "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}

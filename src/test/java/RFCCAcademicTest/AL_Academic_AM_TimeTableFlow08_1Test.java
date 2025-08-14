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

import RFCCAcademic.AL_Academic_AM_TimeTableFlow08_1;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_AM_TimeTableFlow08_1Test extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	AL_Academic_AM_TimeTableFlow08_1 aL_Academic_AM_TimeTable;
	HomePageAdmin homePageAdmin;
	
	@BeforeClass
	public void configuration() {
		reports = Reports.createReport();
	}
	
	@BeforeMethod
	public void launchBrowser(Method m) throws Exception{
		 driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + " *****Starting Test***** : " + m.getName() + "******* " + "\n");
	}
	
	@Test
	public void aL_Academic_AM_TimeTableFlow08_1Test() throws Throwable { 
		
		test = reports.createTest("aL_Academic_AM_TimeTableFlow08_1Test");
		homePageAdmin = new HomePageAdmin(driver);
		aL_Academic_AM_TimeTable = new AL_Academic_AM_TimeTableFlow08_1(driver);
		
		Thread.sleep(3000);
		RF_AdminLoginPage.loginPage();
		
		System.out.println("Academics -> Attendance Management -> Time Table");
		
		Thread.sleep(3000);
		homePageAdmin.Academic();
		Thread.sleep(3000);
		homePageAdmin.Academic_AttendanceManagement();
		Thread.sleep(3000);
		aL_Academic_AM_TimeTable.click_timeTable_link();
		Thread.sleep(3000);
		aL_Academic_AM_TimeTable.select_college();
		Thread.sleep(3000);
		aL_Academic_AM_TimeTable.select_session();
		Thread.sleep(3000);
		aL_Academic_AM_TimeTable.select_department();
		Thread.sleep(3000);
		aL_Academic_AM_TimeTable.select_semester();
		Thread.sleep(3000);
		aL_Academic_AM_TimeTable.select_section();
		Thread.sleep(3000);
		aL_Academic_AM_TimeTable.select_slotType();
		Thread.sleep(3000);
		aL_Academic_AM_TimeTable.enter_startDate();
		Thread.sleep(3000);
		aL_Academic_AM_TimeTable.enter_endDate();
		Thread.sleep(3000);
		aL_Academic_AM_TimeTable.dragAndDropFaculty();
		Thread.sleep(3000);
		aL_Academic_AM_TimeTable.click_save_btn(); 
		
		//Time table added successfully
		Thread.sleep(3000); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Time table added successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}

package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AM_AttendanceEmailTrigger;
import RFCCAcademic.AL_Academic_AM_ScheduleandRoomOccupancy;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.PDFUtility;
import utility.Reports;
import utility.Screenshot;

public class AL_Academic_AM_ScheduleAndRoomOccupancyTest extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_AM_ScheduleandRoomOccupancy aL_Academic_AM_ScheduleandRoomOccupancy;
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
	public void aL_Academic_AM_ScheduleandRoomOccupancy() throws Exception {


		test = reports.createTest("AL_Academic_AM_ScheduleandRoomOccupancy");

		homePageAdmin = new HomePageAdmin(driver);
		aL_Academic_AM_ScheduleandRoomOccupancy = new AL_Academic_AM_ScheduleandRoomOccupancy(driver);
		pdfutility = new PDFUtility(driver);
		
		RF_AdminLoginPage.loginPage();

		System.out.println("Academic-> Attendance Management-> Schedule and Room Occupancy");

		homePageAdmin.Academic();
		Thread.sleep(2000);
		homePageAdmin.Academic_AttendanceManagement();
		Thread.sleep(3000);
		aL_Academic_AM_ScheduleandRoomOccupancy.click_scheduleAndRoomOccupancy_link();
		Thread.sleep(2000);
		aL_Academic_AM_ScheduleandRoomOccupancy.select_scheduleAndRoomOccupancy();
		Thread.sleep(2000);
		aL_Academic_AM_ScheduleandRoomOccupancy.enter_fromDate();
		Thread.sleep(2000);
		aL_Academic_AM_ScheduleandRoomOccupancy.select_type();
		Thread.sleep(4000);
		aL_Academic_AM_ScheduleandRoomOccupancy.click_show_button();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		Thread.sleep(2000);
	
		String Actual_Msg=aL_Academic_AM_ScheduleandRoomOccupancy.getTextFromElement();
		String Expected_Msg = "1ST-FLOOR";  
		
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		//alert.accept();
		}
}

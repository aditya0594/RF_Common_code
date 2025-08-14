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

import RFCCAcademic.AL_Academic_AM_CancelTimeTableFlow08_2;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_AM_CancelTimeTableFlow08_2Test extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	AL_Academic_AM_CancelTimeTableFlow08_2 aL_Academic_AM_CancelTimeTable;
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
	public void aL_Academic_AM_CancelTimeTableFlow08_2Test() throws Throwable { 
		
		test = reports.createTest("aL_Academic_AM_CancelTimeTableFlow08_2Test");
		homePageAdmin = new HomePageAdmin(driver);
		aL_Academic_AM_CancelTimeTable = new AL_Academic_AM_CancelTimeTableFlow08_2(driver);
		
		Thread.sleep(3000);
		RF_AdminLoginPage.loginPage();
		
		System.out.println("Academics -> Attendance Management ->Cancel Time Table");
		
		Thread.sleep(3000);
		homePageAdmin.Academic();
		Thread.sleep(3000);
		homePageAdmin.Academic_AttendanceManagement();
		Thread.sleep(3000);
		aL_Academic_AM_CancelTimeTable.click_cancelTimeTable_link();
		Thread.sleep(3000);
		aL_Academic_AM_CancelTimeTable.select_college();
		Thread.sleep(3000);
		aL_Academic_AM_CancelTimeTable.select_session();
		Thread.sleep(3000);
		aL_Academic_AM_CancelTimeTable.select_department();
		Thread.sleep(3000);
		aL_Academic_AM_CancelTimeTable.select_semester();
		Thread.sleep(3000);
		aL_Academic_AM_CancelTimeTable.select_section();
		Thread.sleep(3000);
		aL_Academic_AM_CancelTimeTable.select_slotType();
		Thread.sleep(3000);
		aL_Academic_AM_CancelTimeTable.enter_startDate();
		Thread.sleep(3000);
		aL_Academic_AM_CancelTimeTable.enter_endDate();
		Thread.sleep(3000);
		aL_Academic_AM_CancelTimeTable.click_show_btn();
		Thread.sleep(3000);
		aL_Academic_AM_CancelTimeTable.click_checkbox();
		Thread.sleep(3000);
		aL_Academic_AM_CancelTimeTable.click_submit_btn();
		Thread.sleep(3000);
		
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Do you really want to Cancel the Time Table ?"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
		Thread.sleep(2000);
		//Thread.sleep(25000); 
		
		/*
		 * driver.switchTo().alert(); String Expected_Msg01 =
		 * "Selected Time Table Cancelled Successfully!"; String Actual_Msg01 =
		 * alert.getText(); Assert.assertEquals(Actual_Msg01 , Expected_Msg01 );
		 * System.out.println("Actual Message - " + Actual_Msg+ "\n"+
		 * "Expected Message - " + Expected_Msg); alert.accept(); Thread.sleep(2000);
		 * alert.accept(); Thread.sleep(3000);
		 */
		
		
	}
}

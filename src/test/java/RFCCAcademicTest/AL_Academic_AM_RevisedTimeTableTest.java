package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.AL_Academic_AM_RevisedTimeTable;
import pojo.Browser;
import pom.RF_AdminLoginPage;
import utility.BaseClass;
import utility.Reports;

public class AL_Academic_AM_RevisedTimeTableTest extends BaseClass{
	
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin;
	AL_Academic_AM_RevisedTimeTable al_Academic_AM_RevisedTimeTable;
	
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
	public void aL_Academic_AM_RevisedTimeTableTest() throws Throwable { 
		
		homePageAdmin = new HomePageAdmin(driver);
		al_Academic_AM_RevisedTimeTable = new AL_Academic_AM_RevisedTimeTable(driver);
		
		test = reports.createTest("aL_Academic_AM_RevisedTimeTableTest");
		
		Thread.sleep(2000);
		RF_AdminLoginPage.loginPage();
		
		System.out.println("Academics -> Attendance Management -> Revised Time Table");
		
		Thread.sleep(2000);
		// click academic
		homePageAdmin.Academic();
		
		Thread.sleep(2000);
		// click attendance management
		homePageAdmin.Academic_AttendanceManagement();

		Thread.sleep(2000);
		// click Revised Time Table Link
		al_Academic_AM_RevisedTimeTable.click_RevisedTimeTable();
		
		Thread.sleep(2000);
		//Select College
		al_Academic_AM_RevisedTimeTable.select_School();
		
		Thread.sleep(3000);
		//Select Session
		al_Academic_AM_RevisedTimeTable.select_Session();
		
		Thread.sleep(3000);
		//Select Department
		al_Academic_AM_RevisedTimeTable.select_department();
		
		Thread.sleep(3000);
		//Select Semester 
		al_Academic_AM_RevisedTimeTable.select_semester();
		
		Thread.sleep(3000);
		//Select Section
		al_Academic_AM_RevisedTimeTable.select_section();
		
		Thread.sleep(3000);
		//Select Slot Type
		al_Academic_AM_RevisedTimeTable.select_slotType();
		
		Thread.sleep(3000);
		//Select Existing Date
		al_Academic_AM_RevisedTimeTable.select_existingDates();
		
		Thread.sleep(2000);
		//Select Start Date
		al_Academic_AM_RevisedTimeTable.enter_startDate();
		
		Thread.sleep(2000);
		//Select End Date
		al_Academic_AM_RevisedTimeTable.enter_endDate();
		
		Thread.sleep(2000);
		//Click on Save Button 
		al_Academic_AM_RevisedTimeTable.click_save_Button();
		
		threadWait1(); 
		Alert alert =  driver.switchTo().alert();
		String Expected_Msg = "Revised Time Table Added Successfully"; 
		String Actual_Msg = alert.getText();
		Assert.assertEquals(Actual_Msg , Expected_Msg );
		System.out.println("Actual Message - " + Actual_Msg+ "\n"+ "Expected Message - " + Expected_Msg);
		alert.accept();
	}
}

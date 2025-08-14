package RFCCAcademicTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageAdmin;

import RFCCAcademic.FL_Academic_FR_AttendanceByFaculty;
import pojo.Browser;
import pom.RF_FacultyLogin;
import utility.BaseClass;
import utility.Reports;

public class FL_Academic_FR_AttendanceByFacultyTest extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	HomePageAdmin homePageAdmin; 
	FL_Academic_FR_AttendanceByFaculty fl_Academic_FR_AttendanceByFaculty;
	
	@BeforeTest
	public void configureReport() { 
		reports = Reports.createReport();
		
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "*******Starting : " + m.getName() + "\n");
	}
	
	@Test
	public void fL_Academic_FR_AttendanceByFacultyTest() throws Exception {
		
		fl_Academic_FR_AttendanceByFaculty = new FL_Academic_FR_AttendanceByFaculty(driver);
		homePageAdmin = new HomePageAdmin(driver);
		
		test=reports.createTest("fL_Academic_FR_AttendanceByFacultyTest");
		Thread.sleep(2000);
		RF_FacultyLogin.loginPage();
		
		System.out.println("Academic->Faculty Related->Attendance By Faculty");
		
		homePageAdmin.Academic();

		// Locating the element from Sub Menu
		Thread.sleep(2000);
		homePageAdmin.Academic_FacultyRelated();

		//Click on Attendance By Faculty Button
		fl_Academic_FR_AttendanceByFaculty.Click_AttendanceByFaculty_Link();
		
		//Click on Radio Button
		fl_Academic_FR_AttendanceByFaculty.Click_Core_RadioButton();
		Thread.sleep(Wait);
		
//		WebElement session = driver.findElement(By.id("select2-ctl00_ContentPlaceHolder1_ddlColgSession-container"));
//		session.click();
//		Thread.sleep(Wait);
//		WebElement sessionDropdown = driver.findElement(By.className("select2-search__field"));
//		sessionDropdown.sendKeys("School of Infrastructure-Dec 2022",Keys.ENTER);
		Thread.sleep(2000);
		
		//Select School
		fl_Academic_FR_AttendanceByFaculty.Select_School();
		Thread.sleep(2000);
		
		//Click on Reqular Radio Button
		fl_Academic_FR_AttendanceByFaculty.Click_Regular_RadioButton();	
		Thread.sleep(2000);
		
		//Click on Date
		fl_Academic_FR_AttendanceByFaculty.Select_Date();
		Thread.sleep(2000);
		
		//Click first Subject Link from Table
		fl_Academic_FR_AttendanceByFaculty.Click_Subject_Details();
		Thread.sleep(2000);
		
		//Click on Checkbox at first line in table
		fl_Academic_FR_AttendanceByFaculty.Click_Checkbox();
		Thread.sleep(2000);
		
		//Click on Submit Button
		fl_Academic_FR_AttendanceByFaculty.Click_Submit_Button();
		Thread.sleep(2000);
		
		Alert alert =  driver.switchTo().alert();
		
		String Expected_Msg = "Attendance Added Successfully!!";
		String Actual_Msg =alert.getText();
		Thread.sleep(2000);
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Actual and Expected Msg matched");
		
		alert.accept();
		
	}
}

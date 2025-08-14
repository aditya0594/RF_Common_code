package ELearningTest;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.pages.HomePageFaculty;

import ELearning.FL_ELearning_Trans_CheckStudentAssignment;
import pojo.Browser;
import pom.RF_FacultyLogin;
import utility.BaseClass;
import utility.Reports;

public class FL_ELearning_Trans_CheckStudentAssignmentTest extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	HomePageFaculty homePageFaculty;
	FL_ELearning_Trans_CheckStudentAssignment fl_ELearning_Trans_CheckStudentAssignment;
	
	@BeforeTest
	public void configureReport() {
		reports = Reports.createReport();
	}

	@BeforeMethod
	public void launchBrowser(Method m) throws Exception {
		driver = Browser.openBrowser("url_RF_LoginAdmin");
		System.out.println("\n" + "******Starting " + m.getName() + "*******" + "\n");
	}

	@Test
	public void fL_ELearning_Trans_CheckStudentAssignmentTest() throws Throwable {
		
		homePageFaculty = new HomePageFaculty(driver);
		fl_ELearning_Trans_CheckStudentAssignment = new FL_ELearning_Trans_CheckStudentAssignment(driver);
		
		test = reports.createTest("Faculty_ELearning_CreateAssignment"); 

		Thread.sleep(2000);
		RF_FacultyLogin.loginPage();

		Thread.sleep(4000);
		homePageFaculty.ELEARNING();

		Thread.sleep(2000); 
		// Locating the element from Sub Menu
		homePageFaculty.Elearning_Trans();
		

		Thread.sleep(2000);
		// Locating the element from Sub Menu
		fl_ELearning_Trans_CheckStudentAssignment.click_selectCourse_Link();

		Thread.sleep(2000);
		fl_ELearning_Trans_CheckStudentAssignment.select_Session();

		Thread.sleep(2000);
		fl_ELearning_Trans_CheckStudentAssignment.select_course();
		
		Thread.sleep(2000);
		fl_ELearning_Trans_CheckStudentAssignment.click_oK_button();

		Thread.sleep(2000);
		
		fl_ELearning_Trans_CheckStudentAssignment.click_checkStudentAssignment();
		
		Thread.sleep(2000);
		fl_ELearning_Trans_CheckStudentAssignment.enter_search();
		
		
		Thread.sleep(2000);
		fl_ELearning_Trans_CheckStudentAssignment.click_studentReply();
		
		Thread.sleep(2000);
		fl_ELearning_Trans_CheckStudentAssignment.click_edit_button();
		
		Thread.sleep(2000);
		fl_ELearning_Trans_CheckStudentAssignment.enter_marks(); 
		
		Thread.sleep(3000);
		fl_ELearning_Trans_CheckStudentAssignment.check_checkbox(); 
		
		Thread.sleep(3000);
		fl_ELearning_Trans_CheckStudentAssignment.check_displayMarks_checkbox();
		
		Thread.sleep(2000);
		fl_ELearning_Trans_CheckStudentAssignment.click_submit_button();
		
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String Expected_Msg = "Marks submitted successfully!";
		String Actual_Msg = alert.getText();
		System.out.println("Actual Confirmation Text - " + Actual_Msg+ "\n"+ "Expected Confiramtion Text - " + Expected_Msg);
		Assert.assertEquals(Actual_Msg, Expected_Msg,"Actual and Expected Msg matched");
		alert.accept(); 

	}

}

